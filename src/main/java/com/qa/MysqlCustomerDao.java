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
	 * This class allow the communication with the database.
	 * Implements the Dao interface.
	 * 
	 */
public class MysqlCustomerDao implements Dao<Customer>{
	/**
	 * @connection variable used to make connection with the database..
	 * 
	 */	
private Connection connection;
	
	
	/**
	 * Constructor initialise the connection variable
	 * 
	 */	
	public MysqlCustomerDao()  throws SQLException{
		
		this.connection=DriverManager.getConnection("jdbc:mysql://34.76.219.229:3306/IMS","Brahim","user123");
	
	}
	
	
	
	/**
	 * Method that update a customer.
	 * 
	 */
	
	public void update(Customer t) {

		
		try {
			
		      String query = "update Customer set firstName=?,surName=? where id=?";
		      
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setString(1,t.getFirstName());
		      preparedStmt.setString(2,t.getSurName());
		      preparedStmt.setLong(3,t.getId()); 
		      
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 

		} 
		
		
	}

	/**
	 * This method delete a customer.
	 * 
	 */
	
	public void delete(int id) {
		
		
		try {
			
		      String query = " delete from Customer where id=?";
		      
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt. setInt(1,id);
		    	      
		  
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 

		}
		
	}
	/**
	 * This method create a customer.
	 * 
	 */
    public void create(Customer t) {
		

		try {
			
		      String query = " insert into Customer (firstName, surName) values (?, ?)";
		      
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setString (1, t.getFirstName());
		      preparedStmt.setString  (2, t.getSurName());
		      
		   
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			

		}
			
		
	} 
    
    /**
	 * This method read all customer .
	 * 
	 */
    
    public List<Customer> readAll() {
	ArrayList<Customer> customers = new ArrayList<Customer>();
	try {
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Customer");
		while (resultSet.next()) {
			Long id = resultSet.getLong("id");
			String firstName = resultSet.getString("firstName");
			String surname = resultSet.getString("surName");
			customers.add(new Customer(id, firstName, surname));
			
			
		}
	} catch (Exception e) {
		 System.out.println(e.getMessage());
	} 
	return customers;
}

    /**
	 * This method retreive the last id in a table
	 * 
	 */
    public int getLastId() {
    	
    	 int id=0 ;
    	try {
			
		      String query = "select max(id) from Customer;";
    		
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
