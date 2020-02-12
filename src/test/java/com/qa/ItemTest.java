package com.qa;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testGetId() {
		Item item = new Item(1,"TV",2500.99);
		item.setId(1);
		assertEquals(item.getId(),1);
	}

	@Test
	public void testSetId() {
		Item item = new Item(1,"TV",2500.99);
		item.setId(1);
		assertEquals(item.getId(),1);
	}

	@Test
	public void testGetItemName() {
		Item item = new Item(1,"TV",2500.99);
		item.setItemName("TV");
		assertEquals(item.getItemName(),"TV");
	}

	@Test
	public void testSetItemName() {
		Item item = new Item(1,"TV",2500.00);
		item.setItemName("TV");
		assertEquals(item.getItemName(),"TV");
	}

	@Test
	public void testGetPrice() {
		Item item = new Item(1,"TV",2500.99);
		item.setPrice(2500.99);
		assertEquals(item.getPrice(),2500.99,2500.99);
	}

	@Test
	public void testSetPrice() {
		Item item = new Item(1,"TV",2500.99);
		item.setPrice(2500.99);
		assertEquals(item.getPrice(),2500.99,2500.99);
	}

}
