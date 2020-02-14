package com.qa;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

public class MysqlItemDaoTest {


	@Test
	public void testCreate() {
		try {
			MysqlItemDao myDao = new MysqlItemDao();
			//int id  = myDao.getLastId();
			Item item = new Item(0,"test",100.99);
			myDao.create(item);
			assertEquals("test", myDao.readAll().get(myDao.readAll().size()-1).itemName);
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
			MysqlItemDao myDao = new MysqlItemDao();
			int id  = myDao.getLastId();
			Item item = new Item(id,"testto",999.99);
			myDao.create(item);
			assertEquals("testto", myDao.readAll().get(myDao.readAll().size()-1).itemName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testDelete() {
		try {
			MysqlItemDao myDao = new MysqlItemDao();
			int id  = myDao.getLastId();
			Item item = new Item(id,"testto",999.99);
			myDao.delete(id);
			assertEquals(1, id - myDao.getLastId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
