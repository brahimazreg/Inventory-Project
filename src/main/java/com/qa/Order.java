package com.qa;

public class Order {
	private int orders_id;
	private int fk_customer_id;
	private double cost;
	private int quantity;
	
	public Order(int id,int fk_customer,double price,int quantity) {
		this.orders_id=id;
		this.fk_customer_id=fk_customer;
		this.cost=price;
		this.quantity=quantity;
		
		
	} 

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public int getFk_customer_id() {
		return fk_customer_id;
	}

	public void setFk_customer_id(int fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	

}
