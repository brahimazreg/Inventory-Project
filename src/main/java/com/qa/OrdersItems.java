package com.qa;


	
	/**
	 * we create this class because we have relation many to many between the item table and order table.
	 *
	 * 
	 */
public class OrdersItems {
	/**
	 * @id identify each record in ordersitems table.
	 *
	 * 
	 */
	private int id;
	/**
	 * @fk_orders foreign key to make relation with order table.
	 *
	 * 
	 */
	private int fk_orders;
	/**
	 * @fk_items foreign key to make relation with item table.
	 *
	 * 
	 */
	private int fk_items;
	/**
	 * @discount=10% this is a calculated field if the quantity * price is greater than 10000.
	 *
	 * 
	 */
    private double price;
    /**
	 * @quantity the quantity of item  that the customer buy .
	 *
	 * 
	 */
    
    private int quantity;
    /**
   	 * the constructure initialize the variables class.
   	 *
   	 * 
   	 */
    public OrdersItems(int id,int fk_orders,int fk_items,int quantity,double price) {
    	this.fk_orders=fk_orders;
    	this.fk_items=fk_items;
    	this.price=price;
    	this.quantity=quantity;
    	this.id=id;
    	
    	
    }
    /**
   	 * This method reteive the id in order table.
   	 *
   	 * 
   	 */
    
	public int getId() {
		return id;
	}
	/**
   	 * This method assign a value to the id.
   	 *
   	 * 
   	 */
  
	public void setId(int id) {
		this.id = id;
	}
	/**
   	 * This method assign a value to the quantity.
   	 *
   	 * 
   	 */
	public int getQuantity() {
		return quantity;
	}
	/**
   	 * This method assign a value to the quantity.
   	 *
   	 * 
   	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
   	 * This method get the foreign key of the order table.
   	 *
   	 * 
   	 */
	public int getFk_orders() {
		return fk_orders;
	}
	/**
   	 * This method set the value to the foreign key of the order table.
   	 *
   	 * 
   	 */
	public void setFk_orders(int fk_orders) {
		this.fk_orders = fk_orders;
	}
	/**
   	 * This method sreturn the value of theitem's  foreign key  .
   	 *
   	 * 
   	 */
	public int getFk_items() {
		return fk_items;
	}
	/**
   	 * This method sreturn the value of the item's  foreign key  .
   	 *
   	 * 
   	 */
	public void setFk_items(int fk_items) {
		this.fk_items = fk_items;
	}
    
	/**
   	 * This method return the value of the discount.
   	 *
   	 * 
   	 */
	public double getPrice() {
		return price;
	}
	/**
   	 * This method set the value to the discount
   	 *
   	 * 
   	 */
	public void setPrice(double discount) {
		this.price = discount;
	}
     
    
	

}  
