package com.qa;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

public class MysqlOrderDaoTest {


	@Test
	public void testCreate() {
		try {
			MysqlOrderDao myDao = new MysqlOrderDao();
			int id  = myDao.getLastId();
			Order order= new Order(id,2,100.99,12);
			myDao.create(order);
			assertEquals(2, myDao.readAll().get(myDao.readAll().size()-1).getFk_customer_id());
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
			Order order= new Order(id,2,999.99,10);
			myDao.create(order);
			assertEquals(10, myDao.readAll().get(myDao.readAll().size()-1).getQuantity());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
