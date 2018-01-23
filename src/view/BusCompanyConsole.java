package view;

import controller.BusCompanyController;

import java.util.Scanner;

public class BusCompanyConsole implements BusCompanyView {

	private Scanner in;

	public BusCompanyConsole() {
		in = new Scanner(System.in);
	}

	@Override
	public void start(BusCompanyController controller) {

		int menuSelection;
		do {
			menuSelection = menu();
			switch (menuSelection) {
				case 1:
					controller.execute("List");
					break;
				case 2:
					controller.execute("Add TripTour");
					break;
				case 3:
					controller.execute("Add BusAndChauffeur");
					break;
				case 4:
					controller.execute("Remove");
					break;
				case 5:
					controller.execute("Show Log");
					break;
				case 6:
					controller.execute("Quit");
					break;
				default:
					show("Invalid input");
					break;
			}
			System.out.println("\nPress ENTER to continue...");
			in.nextLine();
		} while (menuSelection != 6);

	}

	@Override
	public void show(String value) {

		System.out.println(value);

	}

	@Override
	public String get(String what) {

		System.out.print("Please enter " + what + ": ");
		String input = in.nextLine();
		return input;

	}

	private int menu() {
		System.out.println("VIA Bus");
		System.out.println("--------------");
		System.out.println("1) List all reservations");
		System.out.println("2) Add new TripTour");
		System.out.println("3) Add new BusAndChauffeur");
		System.out.println("4) Remove reservation");
		System.out.println("5) Show Log");
		System.out.println("6) Quit");
		System.out.println();
		System.out.println("Select an item 1-6: ");
		int selection = in.nextInt();
		in.nextLine();
		return selection;
	}



}