package com.qa;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Runner {
	
	private static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) throws SQLException {

		/**
		 * the main menu of the application
		 * 
		 * 
		 */
		int option;
		Scanner op = new Scanner(System.in);
		do {
			LOGGER.info("Please choose an option : ? ");
			LOGGER.info(" 1 - Manage customer . ");
			LOGGER.info(" 2 - Manage item . ");
			LOGGER.info(" 3 - Manage order .");
			LOGGER.info(" 4 - Exit. ");

			option = op.nextInt();
			if (option == 1) {
				menu("customer");
			}
			if (option == 2) {
				menu("item");
			}
			if (option == 3) {
				menu("order");
			}
		} while (option < 1 || option > 4);
		op.close();

	}

	/**
	 * this function manage the submenu customer, submenu item , submenu order
	 * 
	 * 
	 */
	public static void menu(String str) {

		if (str.equals("customer")) {
			int option;
			do {
				LOGGER.info("Please choose an option : ? ");
				LOGGER.info(" 1 - Add a  new customer . ");
				LOGGER.info(" 2 - Delete a customer . ");
				LOGGER.info(" 3 - Update a customer .");
				LOGGER.info(" 4 - Show all customers .");
				LOGGER.info(" 5 - Exit. ");
				java.util.Scanner op = new java.util.Scanner(System.in);
				option = op.nextInt();
				switch (option) {
				case 1:

					insertCustomer();
					break;
				case 2:

					deleteCustomer();
					break;
				case 3:

					updateCustomer();
					break;
				case 4:
					showCustomers();
					break;
				case 5:

					System.exit(0);
					break;

				default:

					break;

				}
			} while (option < 1 || option > 5); // end do

		}

		if (str.equals("item")) {
			int option;
			do {
				LOGGER.info("Please choose an option : ? ");
				LOGGER.info(" 1 - Add a  new item . ");
				LOGGER.info(" 2 - Delete an item. ");
				LOGGER.info(" 3 - Update an item.");
				LOGGER.info(" 4 - Show all itemss .");
				LOGGER.info(" 5 - Exit. ");
				java.util.Scanner op = new java.util.Scanner(System.in);
				option = op.nextInt();
				switch (option) {
				case 1:

					insertItem();
					break;
				case 2:

					deletItem();
					break;
				case 3:

					updateItem();
					break;
				case 4:
					showItems();
					break;
				case 5:

					System.exit(0);
					break;

				default:

					break;

				}
			} while (option < 1 || option > 5);

		}

		if (str.equals("order")) {
			int option;
			do {
				LOGGER.info("Please choose an option : ? ");
				LOGGER.info(" 1 - Add a  new order. ");
				LOGGER.info(" 2 - Delete an order . ");
				LOGGER.info(" 3 - Update an order.");
				LOGGER.info(" 4 - Show all orders .");
				LOGGER.info(" 5 - Add orderItems .");
				LOGGER.info(" 6 - Show all orderItems .");
				LOGGER.info(" 7 - Update quantity of an orther.");
				LOGGER.info(" 8 - Exit. ");
				java.util.Scanner op = new java.util.Scanner(System.in);
				option = op.nextInt();
				switch (option) {
				case 1:

					insertOrder();
					break;
				case 2:

					deleteOrder();
					break;
				case 3:

					updateOrder();
					break;
				case 4:
					showOrders();
					break;
				case 5:

					insertOrdersItems();
					break;
				case 6:
					showOrdersDetails();
					break;
				case 7:
					updateOrderQuantity();
					break;
				case 8:

					System.exit(0);
					break;

				default:

					break;

				}
			} while (option < 1 || option > 8);

		}

	}

	/**
	 * this method insert a new customern
	 * 
	 * 
	 */

	public static void insertCustomer() {
		try {
			MysqlCustomerDao dao = new MysqlCustomerDao();
			Scanner scan1 = new Scanner(System.in);
			LOGGER.info(" Enter the firstname of the customer to create ");
			String firstName = scan1.nextLine();

			Scanner scan2 = new Scanner(System.in);
			LOGGER.info(" Enter the surName of the customer to create");
			String surName = scan2.nextLine();

			Customer customer = new Customer(0L, firstName, surName);
			dao.create(customer);
			LOGGER.info(" A new customer has been added !");

			scan1.close();
			scan2.close();
		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method delete a customer
	 * 
	 * 
	 */

	public static void deleteCustomer() {
		showCustomers();
		try {
			MysqlCustomerDao dao = new MysqlCustomerDao();
			Scanner scan = new Scanner(System.in);
			LOGGER.info(" Enter the id of the Customer to delete  ");
			int id = scan.nextInt();
			dao.delete(id);
			LOGGER.info(" A record  has been deleted !");
			scan.close();
		} catch (SQLException e) {

			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method shows all customers
	 * 
	 * 
	 */
	public static void showCustomers() {

		try {
			MysqlCustomerDao dao = new MysqlCustomerDao();
			List<Customer> customers = dao.readAll();
			LOGGER.info("Id " + "     " + "firstName" + "      " + "surName");
			for (Customer customer : customers)

				LOGGER.info(customer.getId() + "       " + customer.getFirstName() + "            "
						+ customer.getSurName());
		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method update a customer
	 * 
	 * 
	 */
	public static void updateCustomer() {
		showCustomers();
		try {
			MysqlCustomerDao dao = new MysqlCustomerDao();
			Scanner scan = new Scanner(System.in);
			LOGGER.info(" Enter the id of the customer to update ");
			long id = scan.nextInt();
			Scanner scan1 = new Scanner(System.in);
			LOGGER.info(" Enter the new firstname of the customer . ");
			String firstName = scan1.nextLine();
			Scanner scan2 = new Scanner(System.in);
			LOGGER.info(" Enter the new surName of the customer .");
			String surName = scan2.nextLine();
			Customer customer = new Customer(id, firstName, surName);
			dao.update(customer);
			LOGGER.info(" A record  has been updated !");
			scan1.close();
			scan2.close();
			scan.close();

		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

	}

	/**
        * this method insert a new item
        * 
        * 
        */ 
       
       public static  void insertItem()  { 
    	   try {
    		   MysqlItemDao dao = new MysqlItemDao();
			 Scanner scan1 = new Scanner(System.in);
			 LOGGER.info(" Enter the name of the item "); 
			 
			 String name  =scan1.nextLine(); 
			 
			 Scanner scan2 = new Scanner(System.in);
			 
			 LOGGER.info(" Enter the price of the item "); 
			 
			 double price =  (double)scan2.nextDouble();
			 Item  item = new Item(0,name,price);
			 dao.create(item);
			LOGGER.info(" A new item has been added !");
			
			scan1.close();
			scan2.close();  
		} catch (Exception e) {
			
		

	    LOGGER.info(e.getMessage()); 
       }  
    	    
       }

	/**
	 * this method show all items
	 * 
	 * 
	 */
	public static void showItems() {

		try {
			MysqlItemDao dao = new MysqlItemDao();
			List<Item> items = dao.readAll();
			LOGGER.info("id" + "          " + " Item name " + "        " + "price");
			for (Item item : items)
				LOGGER.info(
						item.getId() + "            " + item.getItemName() + "                " + item.getPrice());
		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method update an item
	 * 
	 * 
	 */

	public static void updateItem() {
		showItems();
		try {
			MysqlItemDao dao = new MysqlItemDao();
			Scanner scan = new Scanner(System.in);
			LOGGER.info(" Enter the id of the item to update ");
			int id = scan.nextInt();
			Scanner scan1 = new Scanner(System.in);
			LOGGER.info(" Enter the new item to update  ");
			String newItem = scan1.nextLine();
			Scanner scan2 = new Scanner(System.in);
			LOGGER.info(" Enter the new price ");
			double newPrice = scan2.nextDouble();

			Item item = new Item(id, newItem, newPrice);
			dao.update(item);
			LOGGER.info(" A record  has been updated !");
			scan1.close();
			scan2.close();
			scan.close();

		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method delete an item
	 * 
	 * 
	 */
	public static void deletItem() {

		showItems();
		try {
			MysqlItemDao dao = new MysqlItemDao();
			Scanner scan = new Scanner(System.in);
			LOGGER.info(" Enter the id of the item to delete  ");
			int id = scan.nextInt();
			dao.delete(id);
			LOGGER.info(" A record  has been deleted !");
			scan.close();
		} catch (SQLException e) {

			LOGGER.info(e.getMessage());
		}
	}

	/**
	 * this method insert an order
	 * 
	 * 
	 */
	public static void insertOrder() {
		double totalPrice = 0.0d;
		showCustomers();
		Scanner scan1 = new Scanner(System.in);
		LOGGER.info(" Enter the id of the customer for which you want to add an order ");
		
		int id_customer = scan1.nextInt();
		showItems();

		Scanner scan3 = new Scanner(System.in);
		LOGGER.info(" Enter the price for the  item . ");
		
		double price_item = (double) scan3.nextDouble();

		try {
			MysqlOrderDao dao = new MysqlOrderDao();
			Order order = new Order(0, id_customer, price_item);
			dao.create(order);
			LOGGER.info(" An order has been added.");
			scan1.close();
			scan3.close();

		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
	}

	/**
	 * this method show all orders
	 * 
	 * 
	 */

	public static void showOrders() {
		try {
			MysqlOrderDao dao = new MysqlOrderDao();
			List<Order> orders = dao.readAll();
			LOGGER.info("orderid" + "  " + "customer_id" + "   " + "cost");
			for (Order order : orders)

				LOGGER.info(order.getOrders_id() + "       " + order.getFk_customer_id() + "             "
						+ order.getCost());
		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method update an order
	 * 
	 * 
	 */
	public static void updateOrder() {

		showOrders();
		int fk_customer = 0;

		Scanner scan1 = new Scanner(System.in);
		LOGGER.info(" Enter the id  of the order to update ");
		
		int id = scan1.nextInt();

		Scanner scan3 = new Scanner(System.in);
		LOGGER.info(" Enter the new price  ");
		
		double price = scan3.nextDouble();

		try {
			MysqlOrderDao dao = new MysqlOrderDao();
			Order order = new Order(id, fk_customer, price);
			dao.update(order);
			LOGGER.info("The price has been updated");
			scan1.close();
			scan3.close();
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method delete an order
	 * 
	 * 
	 */
	public static void deleteOrder() {

		showOrders();
		try {
			MysqlOrderDao dao = new MysqlOrderDao();
			Scanner scan = new Scanner(System.in);
			LOGGER.info(" Enter the id of the order to delete.  ");
			int id = scan.nextInt();
			dao.delete(id);
			LOGGER.info(" An order has been deleted");
			scan.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method insert a detail of an order
	 * 
	 * 
	 */

	public static void insertOrdersItems() {

		double discount = 0.0d;
		double total = 0.0d;
		int i;
		showOrders();
		Scanner scan1 = new Scanner(System.in);
		LOGGER.info(" Enter the id of the order for witch you want to add details ");
		
		int order_id = scan1.nextInt();

		showItems();

		Scanner scan2 = new Scanner(System.in);
		LOGGER.info(" Enter the quantity  ");
		
		int quantity = scan2.nextInt();

		Scanner scan3 = new Scanner(System.in);
		LOGGER.info(" Enter the price  ");
		
		double price = scan3.nextDouble();

		Scanner scan4 = new Scanner(System.in);
		LOGGER.info(" Enter the id of the item ");
		
		int item_id = scan4.nextInt();

		try {
			MysqlOrdersItemsDao dao = new MysqlOrdersItemsDao();

			OrdersItems orderItem = new OrdersItems(0, order_id, item_id, quantity, price);
			dao.create(orderItem);

			scan1.close();
			scan3.close();

			scan2.close();
			scan4.close();

			LOGGER.info("A details order has been added .");
		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

	}

	/**
	 * this method show all record in ordersItems tabld *
	 * 
	 */
	public static void showOrdersDetails() {

		try {
			MysqlOrdersItemsDao dao = new MysqlOrdersItemsDao();
			List<OrdersItems> ordersItems = dao.readAll();
			LOGGER.info("ordersItems" + "  " + "fk_ordres_Id" + "   " + "fk_items_id," + "    " + "quantity"
					+ "   " + "cost");
			for (OrdersItems orderItem : ordersItems)

				LOGGER.info(orderItem.getId() + "            " + orderItem.getFk_orders() + "              "
						+ orderItem.getFk_items() + "               " + orderItem.getQuantity() + "          "
						+ orderItem.getPrice());
		} catch (Exception e) {

			LOGGER.info(e.getMessage());
		}

	}

	public static void updateOrderQuantity() {

		showOrdersDetails();

		Scanner scan1 = new Scanner(System.in);
		LOGGER.info(" Enter the ordersItems for which you want to change the quantity");
		
		int ordersItems_id = scan1.nextInt();

		Scanner scan2 = new Scanner(System.in);
		LOGGER.info(" Enter the new quantity for the item");
		
		int newQuantity = scan2.nextInt();

		Scanner scan3 = new Scanner(System.in);
		LOGGER.info(" Enter the new price for the item");
		
		double newPrice = scan3.nextDouble();

		try {
			MysqlOrdersItemsDao dao = new MysqlOrdersItemsDao();
			OrdersItems orderItem = new OrdersItems(ordersItems_id, 0, 0, newQuantity, newPrice);
			dao.update(orderItem);
			LOGGER.info("The quantity has been changed");
			scan1.close();
			scan2.close();
			scan3.close();
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}

	}

}
