import controller.BusCompanyController;
import domain.mediator.BusCompanyModel;
import domain.mediator.ClientModelManager;
import view.BusCompanyConsole;
import view.BusCompanyView;

public class ClientMain {
	public static void main(String[] args) {
		String address = "localhost";
		int port1 = 9876;
		int port2 = 1313;

		BusCompanyModel model = new ClientModelManager(address, port1, port2);
		BusCompanyView view = new BusCompanyConsole();
		BusCompanyController controller = new BusCompanyController(model, view);

		view.start(controller);

	}

}
