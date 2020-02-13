package com.qa;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	

	

	@Test
	public void testGetOrders_id() {
		Order order = new Order(26,1,2500.99);
		order.setOrders_id(26);;
		assertEquals(26,order.getOrders_id());
	}

	@Test
	public void testSetOrders_id() {
		Order order = new Order(26,1,2500.99);
		order.setOrders_id(26);;
		assertEquals(26,order.getOrders_id());
	}

	@Test
	public void testGetFk_customer_id() {
		Order order = new Order(26,1,2500.99);
		assertEquals(1,order.getFk_customer_id());
	}

	@Test
	public void testSetFk_customer_id() {
		Order order = new Order(26,1,2500.99);
		order.setFk_customer_id(1);
		assertEquals(1,order.getFk_customer_id());
	
	}

	@Test
	public void testGetCost() {
		Order order = new Order(26,1,2500.99);
		order.setCost(2500.99);
		assertEquals(2500.99,2500.99,order.getCost());
	
	}

	@Test
	public void testSetCost() {
		Order order = new Order(26,1,2500.99);
		order.setCost(2500.99);
		assertEquals(2500.99,2500.99,order.getCost());
	}

}
