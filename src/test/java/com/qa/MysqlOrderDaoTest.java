package com.qa;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

public class MysqlOrderDaoTest {

    @Ignore
	@Test
	public void testCreate() {
		try {
			MysqlOrderDao myDao = new MysqlOrderDao();
			int id  = myDao.getLastId();
			Order order= new Order(0,47,3000.99);
			myDao.create(order);
			assertEquals(3000.99, myDao.readAll().get(myDao.readAll().size()-1).getFk_customer_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testReadAll() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testUpdate() {
		try {
			MysqlOrderDao myDao = new MysqlOrderDao();
			int id  = myDao.getLastId();
			Order order= new Order(id,47,2500.59);
			myDao.update(order);
			assertEquals(2500.59,2500.59, myDao.readAll().get(myDao.readAll().size()-1).getCost());
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
