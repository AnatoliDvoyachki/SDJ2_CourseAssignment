package domain.model;

public class ReservationFactory {
	public static Reservation getReservation(String[] values) {
		if (values[0].equalsIgnoreCase("TripTour")) {
			return new TripTour(values[1], values[2], values[3], values[4],
					values[5], values[6]);
		} else if (values[0].equalsIgnoreCase("BusAndChauffeur")) {
			return new BusAndChauffeur(values[1], values[2], values[3],
					values[4], values[5], values[6]);
		} else
			return null;
	}
	
	public static void main(String[] args) {
		
		String[] a1 = {"triptour", "24/04/2001", "24/04/2002", "Anatoli", "230.00", "23", "1"};
		String[] a2 = {"busandchauffeur", "24/04/2001", "24/04/2002", "Anatoli", "230.00", "23", "Unknown"};
		Reservation r1 = ReservationFactory.getReservation(a1);
		Reservation r2 = ReservationFactory.getReservation(a2);
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
	}
}

