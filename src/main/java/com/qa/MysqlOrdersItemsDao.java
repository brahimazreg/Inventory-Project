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
	//this.connection=DriverManager.getConnection("jdbc:mysql://localhost/IMSdb","root","user123");
}
	/**
	 * Method that create a record in OrderItem table.
	 * 
	 */
	public void create(OrdersItems t) {
		try {
			// the mysql insert statement
		      String query = "insert into ordersItems (fk_orders_id,fk_items_id,discountPrice,quantity) values (?, ?,?,?)";
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt= connection.prepareStatement(query);
		      preparedStmt.setInt(1,t.getFk_orders());
		      preparedStmt.setInt(2, t.getFk_items());
		      preparedStmt.setDouble(3, t.getDiscount());
		      preparedStmt.setInt(4, t.getQuantity());
		      
		   // execute the preparedstatement
		      preparedStmt.executeUpdate();
		      }catch (Exception e) { 
			System.out.println(e.getMessage());
			 //System.err.println(e.getMessage());

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
				 double discount= resultSet.getDouble("discountPrice");
				 ordersItems.add(new OrdersItems(id,fk_order,fk_item, quantity,discount));
				
				
			}
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		return ordersItems;
		
		
	} 

	/**
	 * Method update a record in the ordersItems taqble.
	 * 
	 */
	public void update(OrdersItems t) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method delete a record in the ordersItems taqble.
	 * 
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * this method retreive the list of order from order table.
	 * 
	 */
	public List<Order> getInfoOrder(){
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
					
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from orders ");
						
					while (resultSet.next()) {
					     int ordrer_id = resultSet.getInt("orders_id");
					     int fk_customer = resultSet.getInt("fk_customer_id");
					     int quantity = resultSet.getInt("quantity");
						 double cost= resultSet.getDouble("cost");
						
						
						orders.add(new Order(ordrer_id, fk_customer, cost,quantity));
					}
		} catch (Exception e) {
					 System.out.println(e.getMessage());
				} 
		
		
	  return orders;	
	} 

}
