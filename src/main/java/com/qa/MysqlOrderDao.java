package com.qa;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class allow the communication with the database qnd access to the order table.
 * Implements the Dao interface.
 * 
 */

public class MysqlOrderDao implements Dao<Order>{
	/**
	 * @connection variable used to make connection with the database..
	 * 
	 */
	private Connection connection;
	/**
	 * Constructor initialise the connection variable
	 * 
	 */	
	
	public MysqlOrderDao()  throws SQLException{
	
	this.connection=DriverManager.getConnection("jdbc:mysql://34.76.219.229:3306/IMS","Brahim","user123");
	
}
	/**
	 * Method that create an order.
	 * 
	 */
	public void create(Order t) {

		try {
			
		      String query = "insert into orders (fk_customer_id,cost) values (?,?)";
		     
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setInt(1, t.getFk_customer_id());
		      preparedStmt.setDouble(2, t.getCost());
		      
		  
		      preparedStmt.executeUpdate();
		      }catch (Exception e) { 
			System.out.println(e.getMessage());
			

		}
		 
	}   
	/**
	 * Method that read all orders from order table..
	 * 
	 */
	
	public List<Order> readAll() {
	     
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
			     int id = resultSet.getInt("orders_id");
				int fk_customer = resultSet.getInt("fk_customer_id");
				
				double price= resultSet.getDouble("cost");
				orders.add(new Order(id, fk_customer, price)); 
				
				
			}
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		} 
		return orders;
	
	} 
    
	/**
	 * Method that update a record in the order table.
	 * 
	 */
	public void update(Order t) {
		try {
			
		      String query = "update orders set cost=? where orders_id=?";
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setDouble(1, t.getCost());
		      preparedStmt.setInt(2, t.getOrders_id());
		      
		      
		   
		      preparedStmt.executeUpdate();
		      }catch (Exception e) { 
			System.out.println(e.getMessage());
			

		}
		
		
	}

	public void delete(int id) {
		try {
			
		      String query = "delete from orders  where orders_id=?";
		      
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt. setInt(1,id);
		    	      
		   
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			

		}
		
	}

	/**
	 * Method get the last id in order table .
	 * 
	 */
	 public int getLastId() {
	    	
    	 int id=0 ;
    	try {
			
		      String query = "select max(orders_id) from orders;";
    		
		       PreparedStatement preparedStmt= connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		       preparedStmt.execute();
	

		       ResultSet keys = preparedStmt.getResultSet();

		       if(keys.next()) {
		    	   id = keys.getInt(1);
		       }
		       System.out.println("Last Key: " +id);
		       return id;
		 	       
		 		      
		       
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 

		} 
    	
    	return 0;
    }
} 
