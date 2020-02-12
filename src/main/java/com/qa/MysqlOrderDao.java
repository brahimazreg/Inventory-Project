package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MysqlOrderDao implements Dao<Order>{
	
	private Connection connection;
	public MysqlOrderDao()  throws SQLException{
	
	this.connection=DriverManager.getConnection("jdbc:mysql://34.76.219.229:3306/IMS","Brahim","user123");
	//this.connection=DriverManager.getConnection("jdbc:mysql://localhost/IMSdb","root","user123");
}

	public void create(Order t) {

		try {
			// the mysql insert statement
		      String query = "insert into orders (fk_customer_id,quantity,cost) values (?,?,?)";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setInt(1, t.getFk_customer_id());
		      preparedStmt.setInt(2, t.getQuantity());
		      preparedStmt.setDouble(3, t.getCost());
		      
		   // execute the preparedstatement
		      preparedStmt.executeUpdate();
		      }catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		}
		
	} 

	public List<Order> readAll() {
	     
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
			     int id = resultSet.getInt("orders_id");
				int fk_customer = resultSet.getInt("fk_customer_id");
				int quantity=resultSet.getInt("quantity");
				double price= resultSet.getDouble("cost");
				orders.add(new Order(id, fk_customer, price,quantity));
				
				
			}
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		} 
		return orders;
	
	}

	public void update(Order t) {
		try {
			// the mysql insert statement
		      String query = "update orders set quantity =? ,  cost=? where orders_id=?";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setInt(1, t.getQuantity());
		      preparedStmt.setDouble(2, t.getCost());
		      preparedStmt.setInt(3, t.getOrders_id());
		      
		      
		   // execute the preparedstatement
		      preparedStmt.executeUpdate();
		      }catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		}
		
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	 public int getLastId() {
	    	
    	 int id=0 ;
    	try {
			// the mysql insert statement
		      String query = "select max(orders_id) from orders;";
    		//String query = " SELECT* from Customer";
    		
		      // create the mysql insert preparedstatement
		       PreparedStatement preparedStmt= connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		       preparedStmt.execute();
	
//		       ResultSet keys = preparedStmt.getGeneratedKeys();
		       ResultSet keys = preparedStmt.getResultSet();
//		       keys.next();
		       if(keys.next()) {
		    	   id = keys.getInt(1);
		       }
		       System.out.println("Last Key: " +id);
		       return id;
		 	       
		 		      
		       
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		} 
    	
    	return 0;
    }
} 
