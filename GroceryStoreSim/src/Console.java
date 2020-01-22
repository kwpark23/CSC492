import java.util.Hashtable;

public class Console {
	public static void main(String[] args) {
		
		//Grocery Store Inventory
		Hashtable<String, Integer> gsinv = new Hashtable<String, Integer>();
		gsinv.put("apple", 10);
		gsinv.put("orange", 20);
		gsinv.put("cabbage", 7);
		gsinv.put("cookie box", 5);
		gsinv.put("cereal", 8);
		
		//New grocery store
		GSInventory gs = new GSInventory();
		
		//Order items
		Hashtable<String, Integer> or1item = new Hashtable<String, Integer>();
		Hashtable<String, Integer> or2item = new Hashtable<String, Integer>();
		Hashtable<String, Integer> or3item = new Hashtable<String, Integer>();
		
		//valid order case
		or1item.put("apple", 10);
		or1item.put("cookie box", 3);
		
		//invalid order case
		or2item.put("apple", 7);
		or2item.put("orange", 3);
		
		//valid order case
		or3item.put("cabbage", 4);
		or3item.put("cereal", 3);
		
		//create new orders
		Order or1 = new Order("Order1", or1item);
		Order or2 = new Order("Order2", or2item);
		Order or3 = new Order("Order3", or3item);
		
		//Subscribe observers to observable
		gs.add(or1);
		gs.add(or2);
		gs.add(or3);
		
		//update grocery inventory AND change status for each orders
		gs.updateStatus(gsinv);

					
		 
	}
}
