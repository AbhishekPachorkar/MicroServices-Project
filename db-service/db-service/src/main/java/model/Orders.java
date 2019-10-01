package model;

import java.util.List;

public class Orders {

	private String userName;
	private List<String> orders;
	
	public Orders(String userName, List<String> orders) {
		super();
		this.userName = userName;
		this.orders = orders;
	}
	
	

	public Orders() {
		
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	
	
}
