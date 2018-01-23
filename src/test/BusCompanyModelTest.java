
package test;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Before;
import org.junit.Test;

import controller.BusCompanyController;
import domain.mediator.BusCompanyModel;
import domain.mediator.BusCompanyModelManager;
import view.BusCompanyConsole;
import view.BusCompanyView;

public class BusCompanyModelTest{

	private BusCompanyController controller;
	private BusCompanyModel model = new BusCompanyModelManager();
	private BusCompanyView view = new BusCompanyConsole();

	@Before
	public void setUp() throws Exception {
		controller = new BusCompanyController(this.model, this.view);
	}

	@Test
	public void testCreateReservation() {

		String[] values = {"BusAndChauffeur",  "12/04/2017", "16/04/2017", "Matt", "23", "500.32",
				"Legoland" };
		model.createReservation(values);
		assertEquals(
				model.showReservations(),
				"0 - 12/04/2017 -> 16/04/2017 chauffeur: Matt passengers: 23 price: 500.32 destination: Legoland\n");

	}

	@Test(expected = InputMismatchException.class)
	public void testCreateReservationMissingValue() {

		String[] values = { "12/04/2017", "16/04/2017", "Matt", "23", "500.32" };
		model.createReservation(values);

	}

	@Test(expected = InputMismatchException.class)
	public void testCreateReservationExtraValue() {

		String[] values = {"assdasdasd", "BusAndChauffeur", "12/04/2017", "16/04/2017", "Matt", "23",
				"500.32", "Legoland" };
		model.createReservation(values);

	}

	@Test(expected = InputMismatchException.class)
	public void testCreateReservationWrongValue() {

		String[] values = { "12/04/2017", "16/04/2017", "Matt", "abc",
				"500.32", "Legoland" };
		model.createReservation(values);

	}

	@Test
	public void testDeleteReservation() {

		String[] values1 = {"BusAndChauffeur",  "12/04/2017", "16/04/2017", "Matt", "23",
				"500.32", "Legoland" };
		String[] values2 = {"BusAndChauffeur",  "12/04/2018", "16/04/2018", "John", "33",
				"600.32", "Africa" };
		String[] values3 = {"BusAndChauffeur",  "12/04/2019", "16/04/2019", "Joe", "43", "700.32",
				"USA" };

		model.createReservation(values1);
		model.createReservation(values2);
		model.createReservation(values3);
		model.deleteReservation(1);

		assertEquals(
				model.showReservations(),
				"0 - 12/04/2017 -> 16/04/2017 chauffeur: Matt passengers: 23 price: 500.32 destination: Legoland\n"
						+ "1 - 12/04/2019 -> 16/04/2019 chauffeur: Joe passengers: 43 price: 700.32 destination: USA\n");

	}

	@Test
	public void testShowReservations() {
		assertEquals(model.showReservations(), "");

		String[] values = {"BusAndChauffeur",  "12/04/2017", "16/04/2017", "Matt", "23", "500.32",
				"Legoland" };
		model.createReservation(values);
		assertEquals(
				model.showReservations(),
				"0 - 12/04/2017 -> 16/04/2017 chauffeur: Matt passengers: 23 price: 500.32 destination: Legoland\n");

		model.deleteReservation(0);
		assertEquals(model.showReservations(), "");

	}

	@Test
	public void testGetReservation() {

		String[] values = {"BusAndChauffeur",  "12/04/2017", "16/04/2017", "Matt", "23", "500.32",
				"Legoland" };

		assertEquals(model.getReservations().toString(), "");
		assertEquals(model.getReservations().size(), 0);

		model.createReservation(values);

		assertEquals(
				model.getReservations().toString(),
				"0 - 12/04/2017 -> 16/04/2017 chauffeur: Matt passengers: 23 price: 500.32 destination: Legoland\n");
		assertEquals(model.getReservations().size(), 1);

		model.deleteReservation(0);

		assertEquals(model.getReservations().toString(), "");
		assertEquals(model.getReservations().size(), 0);

	}

}
