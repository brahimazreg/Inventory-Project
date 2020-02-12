package com.qa;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testGetQuantity() {
		Order order = new Order(1,3,12504.15,5);
		order.setQuantity(5);
		assertEquals(order.getQuantity(),5);
	}

	@Test
	public void testSetQuantity() {
		Order order = new Order(1,3,12504.15,5);
		order.setOrders_id(1);
		assertEquals(order.getQuantity(),5);
	}

	@Test
	public void testGetOrders_id() {
		Order order = new Order(1,3,12504.15,5);
		order.setFk_customer_id(3);
		assertEquals(order.getOrders_id(),1);
	}

	@Test
	public void testSetOrders_id() {
		Order order = new Order(1,3,12504.15,5);
		order.setFk_customer_id(3);
		assertEquals(order.getOrders_id(),1);
	}

	@Test
	public void testGetFk_customer_id() {
		Order order = new Order(1,3,12504.15,5);
		order.setOrders_id(1);
		assertEquals(order.getFk_customer_id(),3);
	}

	@Test
	public void testSetFk_customer_id() {
		Order order = new Order(1,3,12504.15,5);
		order.setFk_customer_id(3);;
		assertEquals(order.getOrders_id(),1);
	
	}

	@Test
	public void testGetCost() {
		Order order = new Order(1,3,12504.15,5);
		order.setCost(12504.15);
		assertEquals(order.getOrders_id(),1);
	
	}

	@Test
	public void testSetCost() {
		Order order = new Order(1,3,12504.15,5);
		order.setCost(12504.15);
		assertEquals(order.getOrders_id(),1);
	}

}
