package domain.mediator;

import java.util.InputMismatchException;

import domain.model.Reservation;
import domain.model.ReservationFactory;
import domain.model.ReservationList;

public class BusCompanyModelManager implements BusCompanyModel {

	private ReservationList reservations;

	public BusCompanyModelManager() {
		reservations = new ReservationList();
	}

	@Override
	public void createReservation(String[] values) {

		// Input Verification
		if (values.length != 7) {
			throw new InputMismatchException();
		}
		try {
			int passengers = Integer.parseInt(values[4]);
			double price = Double.parseDouble(values[5]);
		} catch (Exception e) {
			throw new InputMismatchException();
		}

		reservations.add(ReservationFactory.getReservation(values));
	}

	@Override
	public Reservation deleteReservation(int index) {
		return reservations.remove(index);
	}

	@Override
	public String showReservations() {
		return reservations.toString();
	}

	@Override
	public ReservationList getReservations() {
		return reservations;
	}

	@Override
	public String getLog() {
		// TODO Auto-generated method stub
		return null;
	}
}
