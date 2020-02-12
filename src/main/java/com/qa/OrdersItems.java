package com.qa;

public class OrdersItems {
	private int id;
	private int fk_orders;
	private int fk_items;
    private double discount;
    private int quantity;
    public OrdersItems(int id,int fk_orders,int fk_items,int quantity,double discount) {
    	this.fk_orders=fk_orders;
    	this.fk_items=fk_items;
    	this.discount=discount;
    	this.quantity=quantity;
    	this.id=id;
    	
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getFk_orders() {
		return fk_orders;
	}

	public void setFk_orders(int fk_orders) {
		this.fk_orders = fk_orders;
	}

	public int getFk_items() {
		return fk_items;
	}

	public void setFk_items(int fk_items) {
		this.fk_items = fk_items;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
     
    
	

}  
