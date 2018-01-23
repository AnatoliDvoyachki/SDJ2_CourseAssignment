package domain.model;

import java.io.Serializable;

public class TripTour implements Reservation, Serializable{
	private String startDate, endDate;
	private String chauffeur, price;
	private String passengers, index; 
	private String destination;
	private final static String[] DESTINATIONS = {"Copenhagen", "Aarhus", "Hamburg", "Aalborg", "Berlin", "Rome", "Hong Kong"};

	public TripTour(String startDate, String endDate, String chauffeur,
			String passengers, String price, String index) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.chauffeur = chauffeur;
		this.price = price;
		this.passengers = passengers;
		int choice = Integer.parseInt(index);
		if (choice < 0 || choice > DESTINATIONS.length - 1){
			choice = 0;
		}
		this.destination = DESTINATIONS[choice];
	}
	
	public static String listDestinations(){
		StringBuilder str =  new StringBuilder();
		for (int i = 0; i < DESTINATIONS.length; i++){
			str.append(i + ". " + DESTINATIONS[i] + "\n");
		}
		return str.toString();
	}
	
	public String toString() {
		return startDate + " -> " + endDate + " chauffeur: " + chauffeur
				+ " passengers: " + passengers + " price: " + price
				+ " destination: " + destination;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TripTour)) {
			return false;
		}

		TripTour other = (TripTour) obj;
		return startDate.equals(other.startDate)
				&& endDate.equals(other.endDate)
				&& chauffeur.equals(other.chauffeur)
				&& passengers.equals(other.passengers)
				&& price.equals(other.price)
				&& destination.equals(other.destination);
	}

}
