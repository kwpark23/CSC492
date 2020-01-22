import java.util.Hashtable;

//This is observer
//Order will periodically check Inventory to see if order has been approved

//possible status: "Invalid" or "Looking for Driver"

public class Order {
	private String name;
	public String status = "";
	public Hashtable<String, Integer> orderitems;
	
	public Order(String name, Hashtable<String, Integer> orderitems) {
		super();
		this.name = name;
		this.orderitems = orderitems;
	}
	
	public void update(String status) {
		this.status = status;
		System.out.println(name + " status Update: " + status);
	}
}
