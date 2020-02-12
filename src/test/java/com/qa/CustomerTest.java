package com.qa;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	Customer customer ; 
	@Test
	public void testGetId() {
		Customer customer = new Customer(1L,"Bob","Marley");
		customer.setId(1L);
		assertEquals(customer.getId(),Long.valueOf(1));
	}

	@Test
	public void testGetFirstName() {
		Customer customer = new Customer(1L,"Bob","Marley");
		customer.setFirstName("Bob");
		assertEquals(customer.getFirstName(),"Bob");
	}
	@Test
	public void testGetSurName() {
		Customer customer= new Customer(1L,"Bob","Marley");
		customer.setSurName("Marley");
		assertEquals(customer.getSurName(),"Marley");;
		
	}
   
	@Test
	public void testSetFirstName() {
		Customer customer = new Customer(1L,"Bob","Marley");
		customer.setFirstName("Bob");
		assertEquals(customer.getFirstName(),"Bob");
	}
	
	@Test
	public void testSetSurName() {
		Customer customer= new Customer(1L,"Bob","Marley");
		customer.setSurName("Marley");
		assertEquals(customer.getSurName(),"Marley");
	}
	
	/*
	 @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);

    }
	 */
}
