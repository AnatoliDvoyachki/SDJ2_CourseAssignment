package domain.model;

import java.io.Serializable;

public class BusAndChauffeur implements Reservation, Serializable {
	private String startDate, endDate;
	private String chauffeur, price;
	private String passengers, destination;

	public BusAndChauffeur(String startDate, String endDate, String chauffeur,
			String passengers, String price, String destination) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.chauffeur = chauffeur;
		this.price = price;
		this.passengers = passengers;
		this.destination = destination;
	}

	public String toString() {
		return startDate + " -> " + endDate + " chauffeur: " + chauffeur
				+ " passengers: " + passengers + " price: " + price
				+ " destination: " + destination;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BusAndChauffeur)) {
			return false;
		}

		BusAndChauffeur other = (BusAndChauffeur) obj;
		return startDate.equals(other.startDate)
				&& endDate.equals(other.endDate)
				&& chauffeur.equals(other.chauffeur)
				&& passengers.equals(other.passengers)
				&& price.equals(other.price)
				&& destination.equals(other.destination);
	}

}
