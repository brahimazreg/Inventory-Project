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
public class MysqlItemDao implements Dao<Item>{
	/**
	 * @connection variable used to make connection with the database..
	 * 
	 */	
	private Connection connection;
	
	/**
	 * Constructor initialise the connection variable
	 * 
	 */	
		public MysqlItemDao()  throws SQLException{
		
		this.connection=DriverManager.getConnection("jdbc:mysql://34.76.219.229:3306/IMS","Brahim","user123");
		//this.connection=DriverManager.getConnection("jdbc:mysql://localhost/IMSdb","root","user123");
	}
		/**
		 * Method that create an item.
		 * 
		 */

	public void create(Item t) {
		// TODO Auto-generated method stub
		 // PreparedStatement ps =null;
		 // ResultSet rs = null;

		try {
			// the mysql insert statement
		      String query = "insert into items (items_name, price) values (?, ?)";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setString (1, t.getItemName());
		      preparedStmt.setDouble(2, t.getPrice());
		      
		   // execute the preparedstatement
		      preparedStmt.executeUpdate();
		      }catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		}
		  
	} 
	/**
	 * This method rea all record in item table.
	 * 
	 */
	public List<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items");
			while (resultSet.next()) {
			     int id = resultSet.getInt("items_id");
				String name = resultSet.getString("items_name");
				double price= resultSet.getDouble("price");
				items.add(new Item(id, name, price));
				
				
			}
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		} 
		return items;
		
		
		
		
	
	} 
	/**
	 * Method that update an itemer.
	 * 
	 */
	
	public void update(Item t) {
		
		try {
			// the mysql insert statement
		      String query = "update items set items_name=?,price=?  where items_id=?";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setString(1,t.getItemName());
		      preparedStmt.setDouble(2,t.getPrice());
		      preparedStmt.setLong(3,t.getId()); 
		      // execute the preparedstatement
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		} 
		

				
	}//end update item

	/**
	 * this method delete an item from item table
	 * 
	 */
	public void delete(int id) {

		try {
			// the mysql insert statement
		      String query = " delete from items where items_id=?";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt. setInt(1,id);
		    	      
		   // execute the preparedstatement
		      preparedStmt.execute();
		}catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

		}
		
	}// end delete item
	
	
	//********************************
	/**
	 * this method get the id of the last reord inserted.
	 * 
	 */
	 public int getLastId() {
	    	
    	 int id=0 ;
    	try {
			// the mysql insert statement
		      String query = "select max(items_id) from items;";
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
