package com.qa;


/**
 * This is  order class. 
 * 
 * 
 */
public class Order {
	/**
	 * @orders_id identify a record in order table.. 
	 * 
	 * 
	 */
	private int orders_id;
	/**
	 * @fk_customer_id the foreign key allow the relation ship with customer table. 
	 * 
	 * 
	 */
	private int fk_customer_id;
	/**
	 * @cost the price for an item. 
	 * 
	 * 
	 */
	private double cost;
	
	
	/**
	 * The constructor to initialize the variable class.
	 * 
	 * 
	 */
	public Order(int id,int fk_customer,double price) {
		this.orders_id=id;
		this.fk_customer_id=fk_customer;
		this.cost=price;
	
		
		 
	} 
    
	
	/**
	 * this method return the order_id.
	 * 
	 * 
	 */
	public int getOrders_id() {
		return orders_id;
	}
	/**
	 * this method assign the order_id variable.
	 * 
	 * 
	 */
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	/**
	 * this method return the foreign key of order table.
	 * 
	 * 
	 */
	public int getFk_customer_id() {
		return fk_customer_id;
	}
    
	/**
	 * this method assign a value to the foreign key of order table.
	 * 
	 * 
	 */
	public void setFk_customer_id(int fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}
	/**
	 * this method return the cost value.
	 * 
	 * 
	 */

	public double getCost() {
		return cost;
	}
	/**
	 * this method assign a value to the cost variable..
	 * 
	 * 
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	

}
