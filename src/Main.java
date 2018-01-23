import controller.BusCompanyController;
import domain.mediator.BusCompanyModel;
import domain.mediator.BusCompanyModelManager;
import view.BusCompanyConsole;
import view.BusCompanyView;

public class Main {
	public static void main(String[] args) {
		BusCompanyModel model = new BusCompanyModelManager();
		BusCompanyView view = new BusCompanyConsole();
		BusCompanyController controller = new BusCompanyController(model, view);

		// Test values
		String[] values01 = {"BusAndChauffeur", "12/04/2017", "16/04/2017", "Matt", "23", "500.32", "Legoland"};
		String[] values02 = {"BusAndChauffeur", "01/05/2017", "02/05/2017", "Steve", "3", "210", "Eastside"};
		String[] values03 = {"BusAndChauffeur", "14/05/2017", "18/05/2017", "Erik", "8", "1000.2", "Aarhus"};
		String[] values04 = {"BusAndChauffeur", "30/06/2017", "02/07/2017", "Matt", "12", "700", "CPH"};
		model.createReservation(values01);
		model.createReservation(values02);
		model.createReservation(values03);
		model.createReservation(values04);

//		view.start(controller);
		
		System.out.println(model.showReservations());

	}
}
