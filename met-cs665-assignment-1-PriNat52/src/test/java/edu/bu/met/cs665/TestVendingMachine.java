package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.bu.met.cs665.hw1.AutoBeverage;

/**
 * @author priyanka gnanasekaran
 *
 */

public class TestVendingMachine {

	 public TestVendingMachine() {}
	 
	@Test
	public void test() {}
	
	/*JUnit Test: for coffee name*/
	@Test
	  public void testCoffeeName() {
		 AutoBeverage myDrink = new AutoBeverage();
		 myDrink.createDrink("Americano");
	    assertEquals("Americano", myDrink.getBeverageName("Americano"));
	  }
	 
	/*JUnit Test: for tea name*/
	 @Test
	  public void testTeaName() {
		 AutoBeverage myDrink = new AutoBeverage();
		 myDrink.createDrink("Black Tea");
	    assertEquals("Black Tea", myDrink.getBeverageName("Black Tea"));
	  }
	
	/*JUnit test Example from Assignment 1*/
	@Test
	public void testCondimentNumber() {
		AutoBeverage myDrink = new AutoBeverage();
		 myDrink.createDrink("Yellow Tea");
		 
		 //added 4 units of milk and only 3 units accepted
		 myDrink.addMilk();
		 myDrink.addMilk();
		 myDrink.addMilk();
		 myDrink.addMilk();
			
		 //added 1 unit of sugar and total becomes 4
		 myDrink.addSugar();
		 assertEquals(myDrink.getTotalNumberOfCondiments(), 4);
	}
	
	/*JUnit test: when added more than 6 units of condiments*/
	@Test
	public void testExceededCondimentNumber() {
		AutoBeverage myDrink = new AutoBeverage();
		 myDrink.createDrink("Green Tea");
		 
		//added 4 units of milk and only 3 units accepted
		 myDrink.addMilk();
		 myDrink.addMilk();
		 myDrink.addMilk();
		 myDrink.addMilk();
			
		//added 4 units of sugar and only 3 units accepted
		 myDrink.addSugar();
		 myDrink.addSugar();
		 myDrink.addSugar();
		 myDrink.addSugar();
		 
		 assertEquals(myDrink.getTotalNumberOfCondiments(), 6);
	}

	/*JUnit test: when added 0 units of milk and 1 unit of sugar*/
	@Test
	public void testLessCondimentNumber() {
		AutoBeverage myDrink = new AutoBeverage();
		 myDrink.createDrink("Americano");
		 	
		 //added only sugar
		 myDrink.addSugar();
		 
		 assertEquals(myDrink.getTotalNumberOfCondiments(), 1);
	}
	
	/*JUnit test: when added 0 units of condiments*/
	@Test
	public void testZeroCondimentNumber() {
		AutoBeverage myDrink = new AutoBeverage();
		 myDrink.createDrink("Latte Macchiato");
				 
		 assertEquals(myDrink.getTotalNumberOfCondiments(), 0);
	}
	
}
