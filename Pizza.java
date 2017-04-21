import java.util.ArrayList;

public class Pizza {
	
	/**
	 * @author Daniel Ingram
	 * 
	 * This class is the used to store the inputs for the user-created pizzas.
	 * The class will store one base and technically an infinite number of
	 * toppings.
	 */
	
	private int base;
	ArrayList<Integer> topping = new ArrayList<Integer>();
	
	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getTopping(int x) {
		return topping.get(x);
	}

	public void setTopping( int sel) {
		topping.add(sel);
	}
}
