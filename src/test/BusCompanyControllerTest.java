package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import controller.BusCompanyController;
import domain.mediator.BusCompanyModel;
import domain.mediator.BusCompanyModelManager;
import view.BusCompanyConsole;
import view.BusCompanyView;

public class BusCompanyControllerTest
{

   private BusCompanyController controller;
   private BusCompanyModel model = new BusCompanyModelManager();
   private BusCompanyView view = new BusCompanyConsole();
   
   @Before
   public void setUp() throws Exception
   {
      controller = new BusCompanyController(this.model, this.view);
   }
   
   @Test
   public void testExecuteAdd()
   {
      assertEquals(model.getReservations().size(), 0);
      String[] values = {"BusAndChauffeur", "12/04/2017", "16/04/2017", "Matt", "23", "500.32", "Legoland"};
      model.createReservation(values);
      assertEquals(model.getReservations().size(), 1);
   }
   
   @Test
   public void testExecuteRemove()
   {
      assertEquals(model.getReservations().size(), 0);
      String[] values = {"BusAndChauffeur", "12/04/2017", "16/04/2017", "Matt", "23", "500.32", "Legoland"};
      model.createReservation(values);
      assertEquals(model.getReservations().size(), 1);
      model.deleteReservation(0);
      assertEquals(model.getReservations().size(), 0);
   }

}