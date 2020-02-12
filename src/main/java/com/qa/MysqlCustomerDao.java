package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.AbstractList;
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
	//	this.connection=DriverManager.getConnection("jdbc:mysql://localhost/IMSdb","root","user123");
	}
	
	//private Connection connection= DriverManager.getConnection("jdbc:mysql://34.76.219.229:3306/IMS","root","root");
	
	/**
	 * Method that update a customer.
	 * 
	 */
	
	public void update(Customer t) {

		// TODO Auto-generated method stub
		try {
			// the mysql insert statement
		      String query = "update Customer set firstName=?,surName=? where id=?";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setString(1,t.getFirstName());
		      preparedStmt.setString(2,t.getSurName());
		      preparedStmt.setLong(3,t.getId()); 
		      // execute the preparedstatement
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		} 
		
		
	}// end update 

	/**
	 * This method delete a customer.
	 * 
	 */
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		try {
			// the mysql insert statement
		      String query = " delete from Customer where id=?";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt. setInt(1,id);
		    	      
		   // execute the preparedstatement
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		}
		
	}// end delete
	/**
	 * This method create a customer.
	 * 
	 */
    public void create(Customer t) {
		 // PreparedStatement ps =null;
		 // ResultSet rs = null;

		try {
			// the mysql insert statement
		      String query = " insert into Customer (firstName, surName) values (?, ?)";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setString (1, t.getFirstName());
		      preparedStmt.setString  (2, t.getSurName());
		      
		   // execute the preparedstatement
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		}
			
		
	}// end create
    
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
}// end readAll

    /**
	 * This method retreive the last id in a table
	 * 
	 */
    public int getLastId() {
    	
    	 int id=0 ;
    	try {
			// the mysql insert statement
		      String query = "select max(id) from Customer;";
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
