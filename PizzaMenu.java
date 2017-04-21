import java.util.Map;
import java.util.HashMap;

public class PizzaMenu {
	/**
	 * @author Daniel Ingram
	 * 
	 * This class is where the menu items for the PizzaBuild class are stored.
	 * These are the prebuilt pizzas. Toppings and Bases are found in the PizzaTopping.java
	 * and PizzaBase.java classes respectively.
	 */
	
	//Lots of HashMaps. A database would be easier. Implement this ASAP.
	Map<Integer, String> name = new HashMap<Integer, String>();
	Map<Integer, String> top1 = new HashMap<Integer, String>();
	Map<Integer, String> top2 = new HashMap<Integer, String>();
	Map<Integer, String> top3 = new HashMap<Integer, String>();
	Map<Integer, String> top4 = new HashMap<Integer, String>();
	PizzaTopping top = new PizzaTopping();
	int index = 0;

	public void popMenu(){
		addItem("Margherita", "Tomato", "Mozarella", "Basil","");
		addItem("Meat Feast", "Bacon", "Chicken", "Ham", "Pepperoni");
		addItem("Deluxe Vegetarian", "Mushroom", "Spinach", "Mixed Peppers", "Garlic Oil");
		addItem("Fish Lovers", "Tuna", "Sweetcorn", "Mixed Peppers", "Garlic Oil");
		addItem("Hawaiian", "Ham", "Pineapple", "", "");
		
	}
	
	public void addItem(String name, String top1, String top2, String top3, String top4){
	
		this.name.put(index, name);
		this.top1.put(index, top1);
		this.top2.put(index, top2);
		this.top3.put(index, top3);
		this.top4.put(index, top4);
		
		index++;
		
	}
	
	public void displayMenu(double base){
		
		//Method creates the viewable menu and calculates costs of the pizzas on the
		//fly. This was needed to account for the changing costs of the base.
		top.createIngs();
		
		for(int x = 0; x < name.size(); x++){
			
			double cost = base;
			
			System.out.print(x + " - " + name.get(x) + " (" + top1.get(x));
			
			cost += top.cost.get(getKey(top1.get(x)));
			
			if(top2.get(x).equals("")){
				
			}
			else{
				System.out.print(", " + top2.get(x));
				cost += top.cost.get(getKey(top2.get(x)));
			}
			
			if(top3.get(x).equals("")){
				
			}
			else{
				System.out.print(", " + top3.get(x));
				cost += top.cost.get(getKey(top3.get(x)));
			}
			
			if(top4.get(x).equals("")){
				
			}
			else{
				System.out.print(", " + top4.get(x));
				cost += top.cost.get(getKey(top4.get(x)));
			}
			System.out.println(String.format(") - £%.2f", cost));
			
		}
		
		System.out.print("\nPlease select a pizza from the menu:\t");
	}
	
	/*Complex method used to get the keys of a map using the values.
	 *
	 *Need to get the indexes of the ingredients to store them in the bill.
	 *
	 *Needed so that this class will still work if anyone adds more ingredients to
	 *the list.
	 *
	 *More ingredients could mean that the contents of each pizza change.
	 */
	
	public int getKey(String x){
		for(int i = 0; i < top.name.size(); i++){
			if(top.name.get(i).equals(x)){
				return i;		
			}
		}
		//If blank return 888 so the bill compiler will know to not add more lines.
		return 888;
		
		
	}
}
