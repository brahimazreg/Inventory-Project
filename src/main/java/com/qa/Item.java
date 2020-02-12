package com.qa;

public class Item {
	
	private int id;
	String itemName;
	private double price;
	
	public Item(int id,String name, double price) {
		 this .id=id;
		 this.itemName=name;
		 this.price=price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
