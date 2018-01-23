package controller;

import domain.model.Logger;
import domain.model.Reservation;
import domain.model.TripTour;
import view.BusCompanyView;
import domain.mediator.BusCompanyModel;

public class BusCompanyController {

	private BusCompanyModel model;
	private BusCompanyView view;

	public BusCompanyController(BusCompanyModel model, BusCompanyView view) {
		this.model = model;
		this.view = view;
	}

	public void execute(String what) {
		switch (what) {
			case "List":
				view.show(model.showReservations());
				break;

			case "Add TripTour":
				String[] values = new String[7];
				values[0] = "triptour";
				values[1] = view.get("start date");
				values[2] = view.get("end date");
				values[3] = view.get("chauffeur");
				values[4] = view.get("passengers");
				values[5] = view.get("price");
				System.out.println("Choose a predefined destination");
				System.out.println(TripTour.listDestinations());
				values[6] = view.get("destination");
				model.createReservation(values);
				break;

			case "Add BusAndChauffeur":
				String[] values1 = new String[7];
				values1[0] = "busandchauffeur";
				values1[1] = view.get("start date");
				values1[2] = view.get("end date");
				values1[3] = view.get("chauffeur");
				values1[4] = view.get("passengers");
				values1[5] = view.get("price");
				values1[6] = view.get("destination");
				model.createReservation(values1);
				break;

			case "Remove":
				int index = -1;
				while (true) {
					try {
						index = Integer.parseInt(view.get("index of reservation to delete"));
					}
					catch (Exception e) {
					}
					if (index < 0 || index >= model.getReservations().size()) {
						System.out.println("Invalid input");
					}
					else {
						break;
					}
				}
				Reservation deletedReservation = model.deleteReservation(index);
				view.show(deletedReservation.toString());
				break;
				
			case "Show Log":
				view.show(model.getLog());
				break;
				
			case "Quit":
				System.exit(0);
				break;

			default:
				break;
		}
	}

}
