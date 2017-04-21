import java.util.Scanner;
import java.util.ArrayList;

public class PizzaChoice {

	/**
	 * @author Daniel Ingram
	 * 
	 * This class is the main user interface for the Pizza project.
	 * In this class you will find all methods which deal with the user
	 * interaction and pizza selection. This is where the magic happens.
	 */
	
	//declaration of variables and objects used in the main body of the
	//class.
	PizzaBase base = new PizzaBase();
	PizzaTopping top = new PizzaTopping();
	PizzaMenu p = new PizzaMenu();
	Scanner s = new Scanner(System.in);
	ArrayList<Integer> bill = new ArrayList<Integer>();	
	
	public static void main(String[] args) {
		PizzaChoice b = new PizzaChoice();
		
		int input;
		String i;
		boolean exit = false;
		
		//Calls the methods to populate the menus.
		b.p.popMenu();
		b.base.createBase();
		b.top.createIngs();
		
		
		System.out.println("Welcome to Dingram's Pizzas!");
		do{
			//User input to state if they want a premade pizza or to build their own.
			System.out.print("Would you like to order a pre-made pizza (1) or create your own (2)?\t");
			
			input = b.s.nextInt();
			
			//Calls the correct method.
			//Falls over if char or strings input. Reinforce against this!
			if(input == 1){
				b.pickPreMade();
			}
			else if(input == 2){
				b.buildYourOwn();
			}
			else{
				System.out.println("Sorry, that selection is not valid, please try again.");
			}
			
			//Offers additional pizzas to the user.
			System.out.println("Would you like to add to your order? (Y or N)");
			
			i = b.s.next();
			
			if(i.equals("Y") || i.equals("y")){
				
			}
			else if(i.equals("N") || i.equals("n")){
				exit = true;
			}
			
		}while(exit != true);
		
		//Variables which are used to calculate the final bill.
		
		int count = 0;
		int pizNo = 0;
		double cost = 0;
		double totCost = 0;
		boolean veg = true;
		
		//For loop runs through all entries in the "bill" Array List.
		for(Integer x = 0; x < b.bill.size(); x++){
			//The value 999 is used to tell the bill processor that
			//a new pizza is being ordered.
			if(b.bill.get(x) == 999){
				if(count>0){
					if(veg == false){
						System.out.println("This pizza is not vegetarian");
					}
					else{
						System.out.println("This pizza is vegetarian");
					}
					System.out.println(String.format("Pizza Cost: \t£%.2f", cost));
				}
				totCost += cost;
				pizNo++;
				System.out.println("\nPIZZA #" + pizNo);
				count = 0;
				cost = 0;
			}
			else if (b.bill.get(x) == 888){
				//888 is used for the premade pizzas where there are less than
				//four toppings.
			}
			else if(count == 0){
				//The first value that comes after 999 will always be the base,
				//any subsequent values will be toppings.
				System.out.println("Base:\t\t" + b.base.name.get(b.bill.get(x)));
				cost += b.base.cost.get(b.bill.get(x));
				count++;
			}
			else{
				System.out.println("Topping:\t" + b.top.name.get(b.bill.get(x)));
				cost += b.top.cost.get(b.bill.get(x));
				if(b.top.veg.get(b.bill.get(x)) == false){
					veg = false;
				}
			}
		}
		//Selection statement to inform the user whether the pizza is vegetarian.
		if(veg == false){
			System.out.println("This pizza is not vegetarian");
		}
		else{
			System.out.println("This pizza is vegetarian");
		}
		System.out.println(String.format("Pizza Cost: \t£%.2f", cost));
		totCost += cost;
		System.out.println(String.format("The total cost for this order is:\t£%.2f", totCost));

	}
	
	public void pickPreMade(){
		Pizza newPizza = new Pizza();
		int sel;
		
		//SELECTION OF BASE
		base.displayBase();
		
		newPizza.setBase(s.nextInt());
		
		//DISPLAY OF PRE-MADE PIZZA MENU
		double bCost = base.cost.get(newPizza.getBase());
		
		p.displayMenu(bCost);
		
		//USER SELECTION
		
		sel = s.nextInt();
		
		System.out.println(p.name.get(sel) + " on a " + base.name.get(newPizza.getBase()) + " base selected.");
		
		//ADDING OF PIZZA TO THE BILL.
		bill.add(999);
		bill.add(newPizza.getBase());
		bill.add(p.getKey(p.top1.get(sel)));
		bill.add(p.getKey(p.top2.get(sel)));
		bill.add(p.getKey(p.top3.get(sel)));
		bill.add(p.getKey(p.top4.get(sel)));
		
	}
	
	public void buildYourOwn(){
		Pizza newPizza = new Pizza();
		boolean confirm = true;

		
		do{				
			int count = 1;
			int sel;
						
			base.displayBase();
			
			newPizza.setBase(s.nextInt());
			
			top.displayTops();
			
			//User selection of toppings (Maximum of 4)		
			while(count < 5){
				sel = s.nextInt();
				
				newPizza.setTopping(sel);
				
				System.out.println(top.name.get(sel) + " selected.");
				count++;
				
				if(count<5){
			
					System.out.print("\nWould you like to add another topping? (Y or N): ");
								
					boolean ex = false;
					while(ex == false){
						//Why did I choose mo? Change to a more obvious name!
						String mo = s.next();
						if(mo.equals("Y")||mo.equals("y")){
							System.out.print("\nPlease select a topping:\t");
							ex = true;
						}
						else if(mo.equals("N")||mo.equals("n")){
							count = 5;
							ex = true;
						}
						else{
							System.out.print("\nPlease enter a valid input. Y for Yes, N for No:\t");
						}
					}
				}
				
			}
			
			//LOAD FINAL PIZZA
			double cost = 0;
			boolean veg = true;
			System.out.println("\nThis is the pizza you have selected:");
			System.out.println("Base:\t\t" + base.name.get(newPizza.getBase()));
			cost += base.cost.get(newPizza.getBase());
			for(int x = 0; x < newPizza.topping.size(); x++){
				
				System.out.println("Topping:\t" + top.name.get(newPizza.getTopping(x)));
				
				
				cost += top.cost.get(newPizza.getTopping(x));
				
				//For some reason the output from top.veg.get(x) returns the inverse
				//of what is actually stored in the HashMap. Debug this to find out why.
				
				if(top.veg.get(x) == true){
					
					veg = false;
				}
			}
			System.out.println(String.format("This will cost:\t£%.2f", cost));
			if(veg == true){
				System.out.println("This pizza is vegetarian.");
			}
			else{
				System.out.println("This pizza is not vegetarian.");
			}
			//USER ORDER CONFIRMATION
			
			System.out.print("Please confirm your order. 1 - Confirm; 2 - Retry:\t");
			boolean exit = false;
			do{
				sel = s.nextInt();
				
				if(sel == 1){
					confirm = true;
					exit = true;
					//Adds selection to the bill.
					bill.add(999);
					bill.add(newPizza.getBase());
					for(int x = 0; x < newPizza.topping.size(); x++){
						
						bill.add(newPizza.getTopping(x));
					}
				}
				else if(sel == 2){
					confirm = false;
					exit = true;
				}
				else{
					System.out.print("\nPlease enter a valid option! 1 - Confirm; 2 - Retry:");
				}
			}while(exit != true);
			
		}while(confirm != true);
	}

}
