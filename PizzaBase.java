import java.util.Map;
import java.util.HashMap;

public class PizzaBase {
	/**
	 * @author Daniel Ingram
	 * 
	 * This class contains all of the information regarding the pizza bases
	 * this includes the type of base and the price.
	 */
	Map<Integer, String> name = new HashMap<Integer, String>();
	Map<Integer, Double> cost = new HashMap<Integer, Double>();
	int index = 0;
		
	public void createBase(){
		addItem("Thin", 7.50);
		addItem("Deep-Pan", 8.50);
		addItem("Italian", 7.95);
		
	}
	
	public void addItem(String name, double cost){
		this.name.put(index, name);
		this.cost.put(index, cost);
		index++;
	}
	
	public void displayBase(){
		System.out.println("\n Sel |   Base   | Price");
		System.out.println("------------------------");
		for(int x = 0; x < name.size(); x++){
			
			System.out.println(String.format("%3d  |%9s | £%.2f", x, name.get(x), cost.get(x)));
		}
		System.out.print("\nPlease select a base from the menu:\t");
	}
}
