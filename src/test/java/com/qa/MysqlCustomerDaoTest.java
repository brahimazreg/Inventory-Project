package com.qa;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

public class MysqlCustomerDaoTest {
  

	@Test
	public void testUpdate() {
		
		try {
			MysqlCustomerDao myDao = new MysqlCustomerDao();
			Long id  =Long.valueOf( myDao.getLastId());
			Customer customer = new Customer(id,"newFirstName","newSurName");
			myDao.update(customer);
			assertEquals("newFirstName", myDao.readAll().get(myDao.readAll().size()-1).getFirstName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	@Test
	public void testCreate() {
		
		try {
			MysqlCustomerDao myDao = new MysqlCustomerDao();
			//Long id  = Long.valueOf(myDao.getLastId());
			Customer customer = new Customer(0L,"OldName","oldSurName");
			myDao.create(customer);
			assertEquals("OldName", myDao.readAll().get(myDao.readAll().size()-1).getFirstName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  
	
	@Ignore
	@Test
	public void testReadAll() {
		try {
			MysqlCustomerDao myDao = new MysqlCustomerDao();
			Long id  = Long.valueOf(myDao.getLastId());
			//Customer customer = new Customer(id,"oldFirstName","oldSurName");
			//myDao.create(customer);
			assertEquals(id +1, myDao.readAll().get(myDao.readAll().size()-1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	
	@Ignore
	@Test
	public void testDelete() {
		
	
   }  
} 
