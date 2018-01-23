import controller.BusCompanyController;
import domain.mediator.BusCompanyModel;
import domain.mediator.ServerModelManager;
import view.BusCompanyConsole;
import view.BusCompanyView;

public class ServerMain {
	public static void main(String[] args) {
		int port1 = 9876;
		int port2 = 1313;

		BusCompanyModel model = new ServerModelManager(port1, port2);
		BusCompanyView view = new BusCompanyConsole();
		BusCompanyController controller = new BusCompanyController(model, view);

		// Test values
		String[] values01 = {"TripTour", "12/04/2017", "16/04/2017", "Matt", "23", "500.32", "1"};
		String[] values02 = {"TripTour", "01/05/2017", "02/05/2017", "Steve", "3", "210", "2"};
		String[] values03 = {"BusAndChauffeur", "14/05/2017", "18/05/2017", "Erik", "8", "1000.2", "Legoland"};
		String[] values04 = {"BusAndChauffeur", "30/06/2017", "02/07/2017", "Matt", "12", "700", "CPH"};
		model.createReservation(values01);
		model.createReservation(values02);
		model.createReservation(values03);
		model.createReservation(values04);

		view.start(controller);

	}

}
