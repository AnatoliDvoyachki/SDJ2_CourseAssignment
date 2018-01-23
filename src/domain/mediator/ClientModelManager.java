package domain.mediator;

import domain.model.Reservation;
import domain.model.ReservationList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientModelManager implements BusCompanyModel {
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	private Socket connectionSocket;

	public ClientModelManager(String address, int port1, int port2) {
		try {
			connectionSocket = new Socket(address, port1);
			outToServer = new ObjectOutputStream(connectionSocket.getOutputStream());
			inFromServer = new ObjectInputStream(connectionSocket.getInputStream());
			Socket notificationSocket = new Socket(address, port2);
			ClientReceiver receiver = new ClientReceiver(notificationSocket);
			new Thread(receiver).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createReservation(String[] values) {
		String[] outputToServer = new String[values.length + 1];
		for (int i = 0; i < values.length; i++) {
			outputToServer[i] = values[i];
		}
		outputToServer[outputToServer.length - 1] = "2";
		try {
			outToServer.writeObject(outputToServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String showReservations() {
		String[] outputToServer = {"1"};
		String list = "";
		try {
			outToServer.writeObject(outputToServer);
			list = (String) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Reservation deleteReservation(int index) {
		String[] outputToServer = {"" + index, "3"};
		Reservation deletedReservation = null;
		try {
			outToServer.writeObject(outputToServer);
			deletedReservation = (Reservation) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedReservation;
	}

	@Override
	public ReservationList getReservations() {
		String[] outputToServer = {"5"};
		ReservationList reservations = null;
		try {
			outToServer.writeObject(outputToServer);
			reservations = (ReservationList) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public String getLog() {
		String[] outputToServer = {"6"};
		String log = "";
		try {
			outToServer.writeObject(outputToServer);
			log = (String) inFromServer.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return log;
	}
}
