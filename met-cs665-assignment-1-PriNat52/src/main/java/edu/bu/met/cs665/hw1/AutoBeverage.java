package edu.bu.met.cs665.hw1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * @author priyanka gnanasekaran
 *
 */
class Drink {
	
	private int count;
	private String beverage;
	
	public Drink(int count ,String beverage) {	
		this.count = count;
		this.beverage = beverage;
	}
	public String toString() {
		return "("+ count + ")"+ beverage;
    }
}
public class AutoBeverage implements Condinents {
	
	public AutoBeverage() {}
	
	private int count=0;
	private int milkcount=0;
	private int sugarcount=0;
	ArrayList<Drink> order = new ArrayList<Drink>();
	
	public void createDrink(String beverage) {
		//using regex for careating tea or coffee and then adding to thecollection
		
		count++;
		String regex ="\\BAmericano|Espresso|Latte Macchiato\\B";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);	 // Input pattern to be searched
		
		String regexTea ="\\BBlack Tea|Green Tea|Yellow Tea\\B";
		Pattern patternTea = Pattern.compile(regexTea, Pattern.CASE_INSENSITIVE);	 // Input pattern to be searched
		
		/* refered to cs622 my assignments and https://howtodoinjava.com/java/regex/java-regex-specific-contain-word/ */
		
		if(!pattern.matcher(beverage).matches()) {	
			Drink data = new Drink(count, beverage);
			order.add(data);
		}else if(!patternTea.matcher(beverage).matches()) {
			Drink data = new Drink(count, beverage);
			order.add(data);
		}
	}

	@Override
	public void addMilk() {
		//checking for units and adding to the collection
		
		milkcount++;
		if(milkcount <= 3) {
		Drink data = new Drink(count, "Milk");
		order.add(data);
		}else {
			milkcount--;
		}
	}

	@Override
	public void addSugar() {
		//checking for units and adding to the collection
		
		sugarcount++;
		if(sugarcount <= 3) {
		Drink data = new Drink(count, "Sugar");
		order.add(data);
		}else {
			sugarcount--;
		}
		
		Iterator<Drink> itr = order.iterator();	//creating iterator object
		System.out.print("Your Order: ");
		itr.forEachRemaining(value-> { System.out.print(" "+value);});
	}

	public int getTotalNumberOfCondiments() {
		//calculated the total units added to the customer order
		
		int total = sugarcount + milkcount;
		System.out.println();
		System.out.println("Total Condiments: "+total);
		return total;
	}
	
	 public String getBeverageName(String beverage) {
		 //getting beverage name with conditiond to match the product name
		 
		 String regex ="\\BAmericano|Espresso|Latte Macchiato\\B";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);	 // Input pattern to be searched
			
			String regexTea ="\\BBlack Tea|Green Tea|Yellow Tea\\B";
			Pattern patternTea = Pattern.compile(regexTea, Pattern.CASE_INSENSITIVE);	 // Input pattern to be searched
			
			/* refered to cs622 assignments and https://howtodoinjava.com/java/regex/java-regex-specific-contain-word/ */
			
			if(!pattern.matcher(beverage).matches()) {
				return beverage;
			}else if(!patternTea.matcher(beverage).matches()) {
				return beverage;
			}
			return null; 
		  }
}


