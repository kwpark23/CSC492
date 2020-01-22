import java.util.*;
import java.util.Set;

//This observable
//When Inventory update, it will notify to all orders
//Can add or remove

public class GSInventory {
	private List<Order> orders = new ArrayList<>();
	public List<String> statusList = new ArrayList<>();
	public String status = "Invalid";

	public void add(Order order) {
		orders.add(order);
	}
	
	public void remove(Order order) {
		orders.remove(order);
	}
	
	public void notifyOrders(List<String> statusList) {
		for (int i=0; i < orders.size(); i++ ) {
			orders.get(i).update(statusList.get(i));
		} 
	}
	
	public void updateStatus(Hashtable<String, Integer> gsinventory) {
		
		Set<String> gsi = gsinventory.keySet();
		
		for (int i=0; i < orders.size(); i++ ) {
			int counter = 0;
			
			Set<String> ordItems = orders.get(i).orderitems.keySet();
			
			//iterate keys of grocery inventory and order items
			for (String gskey: gsi) {
				for (String ordkey: ordItems) {
					//if keys of inventory and items match
					if (gskey == ordkey) {
						//check amount is okay
						if (gsinventory.get(gskey) >= orders.get(i).orderitems.get(ordkey)) {
							 counter++;
						}
					}
				}	
			}
			
			if (counter == ordItems.size()) {
				statusList.add("Looking for Driver");
				updateInventory(gsinventory, orders.get(i).orderitems);
			}else {
				statusList.add("Invalid");
			}
		}
		notifyOrders(statusList);
	}
	
	public void updateInventory(Hashtable<String, Integer> gsinventory, Hashtable<String, Integer> orderitems) {
		Set<String> gsi = gsinventory.keySet();
		Set<String> ordi = orderitems.keySet();
		
		for (String gskey: gsi) {
			for (String ordkey: ordi) {
				//if keys of inventory and items match
				if (gskey == ordkey) {
					//check amount and decrement the amount
					if (gsinventory.get(gskey) >= orderitems.get(ordkey) && gsinventory.get(gskey) != 0) {
						//update amount
						 gsinventory.put(gskey, gsinventory.get(gskey) - orderitems.get(ordkey));
					}
				}
			}
		}
	}
}
