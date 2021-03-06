package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


	/**
	 * This class allow the communication with the database.
	 * Implements the Dao interface.
	 * 
	 */
public class MysqlOrdersItemsDao implements Dao<OrdersItems> {
	/**
	 * @connection variable used to make connection with the database..
	 * 
	 */	
	private Connection connection;
	/**
	 * Constructor initialise the connection variable
	 * 
	 */
	public MysqlOrdersItemsDao()  throws SQLException{ 
	
	this.connection=DriverManager.getConnection("jdbc:mysql://34.76.219.229:3306/IMS","Brahim","user123");
	
}
	private final Logger LOGGER = Logger.getLogger(this.getClass());
	/**
	 * Method that create a record in OrderItem table.
	 * 
	 */
	public void create(OrdersItems t) {
		try {
			
			double total;
			double discount;;
			if (t.getPrice()* t.getQuantity() > 10000) {
				
				total = Math.round((t.getPrice()* t.getQuantity()) - (t.getPrice()*10)/100);
				discount=(t.getPrice()*10)/100;
				
			}
			else {
				
				total = Math.round(t.getPrice()* t.getQuantity()) ;
				discount=0;
			}
			  String query = "insert into ordersItems (fk_orders_id,fk_items_id,quantity,price) values (?, ?,?,?)";
		   
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setInt(1,t.getFk_orders()); 
		      preparedStmt.setInt(2, t.getFk_items());
		      preparedStmt.setInt(3, t.getQuantity());
		      preparedStmt.setDouble(4, total);
		  
		      preparedStmt.executeUpdate();
		      
		      LOGGER.info(" the total is  :" + total + "  the discount is : " + discount);
		      
		      
		      }catch (Exception e) { 
			LOGGER.info(e.getMessage());
			

		}
		
	} 

     
	
	/**
	 * Method read all record  in ordersItems taqble.
	 * 
	 */
	public List<OrdersItems> readAll() {
		
		ArrayList<OrdersItems> ordersItems = new ArrayList<OrdersItems>(); 
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from ordersItems");
			while (resultSet.next()) {
			     int id = resultSet.getInt("ordersItems_id");
			     int fk_order = resultSet.getInt("fk_orders_id");
			     int fk_item = resultSet.getInt("fk_items_id");
			     int quantity = resultSet.getInt("quantity");
				 double price= resultSet.getDouble("price");
				 ordersItems.add(new OrdersItems(id,fk_order,fk_item, quantity,price));
				
				
			}
		} catch (Exception e) {
			 LOGGER.info(e.getMessage());
		}
		return ordersItems;
		
		 
	} 

	/**
	 * Method update a record in the ordersItems taqble.
	 * 
	 */
	public void update(OrdersItems t) {
		try {
			 double total;
		      String query = "update ordersItems  set quantity=?, price=? where ordersItems_id=?";
		      
		      
		      if (t.getPrice()* t.getQuantity() > 10000) {
					
					total = Math.round((t.getPrice()* t.getQuantity()) - (t.getPrice()*10)/100);
					
					
				}
				else {
					
					total = Math.round(t.getPrice()* t.getQuantity()) ;
					
				}
		      
			      
		      
		      
		      
		      
		      
		      
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setInt(1, t.getQuantity());
		      preparedStmt.setDouble(2,total);
		      preparedStmt.setInt(3, t.getId());
		      
		      
		   
		      preparedStmt.executeUpdate();
		      }catch (Exception e) { 
			LOGGER.info(e.getMessage());
			

		}
		
	} 

	/**
	 * Method delete a record in the ordersItems taqble.
	 * 
	 */
	public void delete(int id) {
		
		
	}
	/**
	 * this method retreive the list of order from order table.
	 * 
	 */
	public List<OrdersItems> getInfoOrder(){
		ArrayList<OrdersItems> orders = new ArrayList<OrdersItems>();
		try {
					
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(" select oi.ordersItems_id,o.cost , oi.quantity from orders o inner join ordersItems oi on   o.orders_id=oi.fk_orders_id; ");
						
					while (resultSet.next()) {
					     int id = resultSet.getInt("ordersItems_id");
					     double  price= resultSet.getInt("cost");
					     int quantity = resultSet.getInt("quantity");
					
						orders.add(new OrdersItems(id, 0, 0,quantity,price));
					}
		} catch (Exception e) {
					 LOGGER.info(e.getMessage());
				} 
		
		
	  return orders;	
	} 

}
