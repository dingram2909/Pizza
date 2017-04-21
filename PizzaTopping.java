import java.util.Map;
import java.util.HashMap;

public class PizzaTopping {

	/**
	 * @author Daniel Ingram
	 * 
	 * This class contains all of the toppings used within the Pizza project.
	 * 
	 * It is built with the intention of being protected against any major changes.
	 * The indexes are assigned on the fly so that additional toppings can be added.
	 */

	Map<Integer, String> name = new HashMap<Integer, String>();
	Map<Integer, Double> cost = new HashMap<Integer, Double>();
	Map<Integer, Boolean> veg = new HashMap<Integer, Boolean>();
	
	int index = 0;
	
	public void createIngs(){
		
		//Adds values to the various HashMaps.
		
		addItem("Bacon", 0.59, false);
		addItem("Basil", 0.65, true);
		addItem("Chicken", 0.90, false);
		addItem("Garlic Oil", 1.00, true);
		addItem("Ham", 0.75, false);
		addItem("Meatballs", 1.20, false);
		addItem("Mixed Peppers", 0.80, true);
		addItem("Mozarella", 0.69, true);
		addItem("Mushroom", 0.65, true);
		addItem("Pepperoni", 1.05, false);
		addItem("Pineapple", 0.70, true);
		addItem("Sausage", 0.75, false);
		addItem("Spinach", 0.60, true);
		addItem("Sweetcorn", 0.50, true);
		addItem("Tomato", 0.45, true);
		addItem("Tuna", 0.95, false);
	}
	
	public void addItem(String name, double cost, boolean veg){
		
		//Ensures that all HashMaps have the same index relating to a topping.
		//Would have been better with a database.
		
		this.name.put(index, name);
		this.cost.put(index, cost);
		this.veg.put(index, veg);
		index++;
	}
	
	public void displayTops(){
		
		//Displays the menu in a funky table.
		
		System.out.println("\n Sel |    Topping     | Price | Vegetarian?");
		System.out.println("---------------------------------------------");
		
		for(int x = 0; x < name.size(); x++){
			
			System.out.print(String.format("%3d  |%15s | £%.2f |     ", x, name.get(x), cost.get(x)));
			
			if(veg.get(x) == true){
				System.out.println("Y");
			}
			else{
				System.out.println("N");
			}
		}
		
		System.out.print("\nPlease select a topping from the menu:\t");
	}
}
