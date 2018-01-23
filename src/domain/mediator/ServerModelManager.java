package domain.mediator;

import domain.model.Logger;
import domain.model.Reservation;
import domain.model.ReservationFactory;
import domain.model.ReservationList;

import java.util.Observable;

public class ServerModelManager extends Observable implements BusCompanyModel {
	private ReservationList reservations;

	private Logger logger = Logger.getInstance();
	
	public ServerModelManager(int port1, int port2) {
		reservations = new ReservationList();
		new Thread(new ServerConnection(port1, port2, this)).start();
	}

	@Override
	public synchronized void createReservation(String[] values) {
		notifyClients(new String("A reservation was created"));
		logger.writeToLog("A reservation was created");
		reservations.add(ReservationFactory.getReservation(values));
	}

	@Override
	public synchronized Reservation deleteReservation(int index) {
		notifyClients(new String("A reservation was deleted"));
		logger.writeToLog("A reservation was deleted");
		return reservations.remove(index);
	}

	@Override
	public synchronized String showReservations() {
		return reservations.toString();
	}

	@Override
	public synchronized ReservationList getReservations() {
		return reservations;
	}

	public void notifyClients(String message) {
		super.setChanged();
		super.notifyObservers(message);
	}

	@Override
	public synchronized String getLog() {
		return logger.toString();
	}
}
