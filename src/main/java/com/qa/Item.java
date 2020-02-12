package com.qa;

public class Item {
	  /**
		 * @id  identify a record in the item table.
		 * 
		 */
	private int id;
	/**
	 * @itemName the name of the item.
	 * 
	 */
	String itemName;
	/**
	 * @price  the price of the item.
	 * 
	 */
	private double price;
	/**
	 *constructor create an instance of item table.
	 * 
	 */
	
	public Item(int id,String name, double price) {
		 this .id=id;
		 this.itemName=name;
		 this.price=price;
	}
  
	/**
	 * method getid return the id of the item.
	 * 
	 */
	public int getId() {
		return id;
	}
	/**
	 * method setid assign a value to the id
	 * 
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * method getItemName return the name of the item.
	 * 
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * method setItemName assign a name to an item.
	 * 
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * method getPrice return the price of an item.
	 * 
	 */

	public double getPrice() {
		return price;
	}
	/**
	 * method setPrice assign  price to an item.
	 * 
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	

}
