package domain.mediator;

import domain.model.Reservation;
import domain.model.ReservationList;

public interface BusCompanyModel {
	void createReservation(String[] values);

	String showReservations();

	Reservation deleteReservation(int index);

	ReservationList getReservations();

	String getLog();
}
