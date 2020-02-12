package com.qa;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Runner {
	
public static void main(String[] args)  throws SQLException{
	 
	 
	
	/**
	 * the main menu of the application
	 * 
	 * 
	 */
		int option;
		java.util.Scanner op= new  java.util.Scanner(System.in);
		do {
			System.out.println("Please choose an option : ? ");
			System.out.println(" 1 - Manage customer . ");
			System.out.println(" 2 - Manage item . ");
			System.out.println(" 3 - Manage order .");
			System.out.println(" 4 - Exit. ");
			
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
		} while(option <1 || option >4);  
	     op.close();
	     
	     
	     
	     
	      
	     
}// end method main   

//******************************** sub menu 


/**
 * this function manage the submenu customer, submenu item , submenu order
 * 
 * 
 */
public static void menu(String str){
	//***************     manage customer ************************
		if(str.equals("customer")){ 
			 int option;
			   do {		    
					System.out.println("Please choose an option : ? ");
					System.out.println(" 1 - Add a  new customer . ");
					System.out.println(" 2 - Delete a customer . ");
					System.out.println(" 3 - Update a customer .");
					System.out.println(" 4 - Show all customers .");
					System.out.println(" 5 - Exit. ");
					java.util.Scanner op = new  java.util.Scanner(System.in);
			                option = op.nextInt();
					switch (option){
			                    case 1:
			                            // call insert 
			                    	insertCustomer();
			                            break;
			                    case 2:
			                            // call delete 
			                    	deleteCustomer();
			                            break;
			                    case 3 :
			                            // call update
			                    	updateCustomer();
			                            break;
			                    case 4 :
			                    	showCustomers();
			                    	    break;
			                    case 5 :
			                            // call update
			                            System.exit(0);
			                            break;
			                   
			                   default:
			                            //System.out.println("Please choose an option ?");
			                            break;

					}// end swith
			  }while(option <1  || option > 5);	// end do
			
		}// end if customer
		
		//***************************   Manage item    *************************
		
		if(str.equals("item")){
			 int option;
			   do {		    
					System.out.println("Please choose an option : ? ");
					System.out.println(" 1 - Add a  new item . ");
					System.out.println(" 2 - Delete an item. ");
					System.out.println(" 3 - Update an item.");
					System.out.println(" 4 - Show all itemss .");
					System.out.println(" 5 - Exit. ");
					java.util.Scanner op = new  java.util.Scanner(System.in);
			                option = op.nextInt();
					switch (option){
			                    case 1:
			                           // call insert  
			                    	insertItem();
			                            break;
			                    case 2:
			                            // call delete 
			                    	deletItem();
			                            break;
			                    case 3 :
			                            // call update
			                    	updateItem();
			                            break;
			                    case 4 :
			                    	showItems();
			                    	    break;
			                    case 5 :
			                            // call update
			                            System.exit(0);
			                            break;
			                   
			                   default:
			                            //System.out.println("Please choose an option ?");
			                            break;

					}// end swith
			  }while(option <1  || option > 5);	// end do
			
		}// end if item
		
		//****************************   Manage order    *****************************************
		
		if(str.equals("order")){
			 int option;
			   do {		    
					System.out.println("Please choose an option : ? ");
					System.out.println(" 1 - Add a  new order. ");
					System.out.println(" 2 - Delete an order . ");
					System.out.println(" 3 - Update an order.");
					System.out.println(" 4 - Show all orders .");
					System.out.println(" 5 - Add orderItems .");
					System.out.println(" 6 - Show all orderItems .");
					
					System.out.println(" 7 - Exit. ");
					java.util.Scanner op = new  java.util.Scanner(System.in);
			                option = op.nextInt();
					switch (option){
			                    case 1:
			                           // call insert  
			                    	insertOrder();
			                            break;
			                    case 2:
			                            // call delete 
			                    	deleteOrder();
			                            break;
			                    case 3 :
			                            // call update
			                    	updateOrder();
			                            break;
			                    case 4 :
			                    	showOrders();
			                    	    break;
			                    case 5 :
		                          
			                    	insertOrdersItems();
		                            break;
		                        case 6 :
		                        	showOrdersDetails();
		                    	    break;
			                    case 7 :
			                            // call update
			                            System.exit(0);
			                            break;
			                   
			                   default:
			                            //System.out.println("Please choose an option ?");
			                            break;

					}// end swith
			  }while(option <1  || option > 5);	// end do
			
		}// end if order
		
		
		
		
		
	}// end  method menu 
	







//************************  end sub menu  *****************************************


//---------------------  Manage  customers   ------------------------------------------------  
/**
 * this method insert a new customern
 * 
 * 
 */      


       public static  void insertCustomer()  { 
    	   try {
			MysqlCustomerDao dao = new MysqlCustomerDao();
			 Scanner scan1 = new Scanner(System.in);
			 System.out.println(" Enter the firstname of the customer to create "); 
			 String firstName =scan1.nextLine(); 
			 Scanner scan2 = new Scanner(System.in);
			 System.out.println(" Enter the surName of the customer to create"); 
			 String surName =  scan2.nextLine();
			 Customer customer = new Customer(0L,firstName,surName);
			 dao.create(customer);
			System.out.println(" A new customer has been added !");
			//JOptionPane.showMessageDialog(null, " A new customer has been added !");
			scan1.close();
			scan2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//e.printStackTrace();

	    System.out.println(e.getMessage());
       }
    	    
       } // end insert
       /**
        * this method delete a customer
        * 
        * 
        */ 
     
       
       public static void  deleteCustomer() {
    	     showCustomers();
    	     try {
				MysqlCustomerDao dao = new MysqlCustomerDao();
				 Scanner scan = new Scanner(System.in);
				 System.out.println(" Enter the id of the Customer to delete  "); 
				 int id = scan.nextInt(); 
				 dao.delete(id);
				 System.out.println(" A record  has been deleted !");
				 scan.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				 System.out.println(e.getMessage()); 
			}
    	    
    	   
       } // end delete
   
       /**
        * this method shows all customers
        * 
        * 
        */ 
       public static void showCustomers() {
    	 
    	  
		try {
			 MysqlCustomerDao dao = new MysqlCustomerDao();
			 List<Customer> customers= dao.readAll();
			 System.out.println( "Id "  + "     " + "firstName" + "      " + "surName");
	      		for(Customer customer:customers) 
	      			
	      			System.out.println(customer.getId() + "       " + customer.getFirstName()+ "            " + customer.getSurName()) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println(e.getMessage()); 
		}
   		
   		}// end of show customers
       
     
       /**
        * this method update a customer
        * 
        * 
        */ 
       public static void  updateCustomer() {
  	          showCustomers();
  	     try {
	  	    	MysqlCustomerDao dao = new MysqlCustomerDao();
	  	    	 Scanner scan = new Scanner(System.in);
	  	    	 System.out.println(" Enter the id of the customer to update ");
	  	    	 long id = scan.nextInt();
				 Scanner scan1 = new Scanner(System.in);
				 System.out.println(" Enter the new firstname of the customer . "); 
				 String firstName =scan1.nextLine(); 
				 Scanner scan2 = new Scanner(System.in);
				 System.out.println(" Enter the new surName of the customer ."); 
				 String surName =  scan2.nextLine();
				 Customer customer = new Customer(id,firstName,surName);
				 dao.update(customer);
				 System.out.println(" A record  has been updated !");
				 scan1.close();
				 scan2.close();
				 scan.close();
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 System.out.println(e.getMessage()); 
			}
  	    
  	   
     } // end update customer
 
       
       //--------------------- Manage items   ------------------------------------------------     
       
       /**
        * this method insert a new item
        * 
        * 
        */ 
       
       public static  void insertItem()  { 
    	   try {
    		   MysqlItemDao dao = new MysqlItemDao();
			 Scanner scan1 = new Scanner(System.in);
			 System.out.println(" Enter the name of the item "); 
			 System.out.println();
			 String name  =scan1.nextLine(); 
			 
			 Scanner scan2 = new Scanner(System.in);
			 System.out.println(" Enter the price of the item "); 
			 System.out.println();
			 double price =  (double)scan2.nextDouble();
			 Item  item = new Item(0,name,price);
			 dao.create(item);
			System.out.println(" A new item has been added !");
			//JOptionPane.showMessageDialog(null, " A new customer has been added !");
			scan1.close();
			scan2.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//e.printStackTrace();

	    System.out.println(e.getMessage()); 
       }  
    	    
       } // end insert item
       
       /**
        * this method show all items
        * 
        * 
        */ 
       public static void showItems() {
      	 
     	  
   		try {
   			MysqlItemDao dao = new MysqlItemDao();
   			 List<Item> items= dao.readAll();
   			     System.out.println("id" + "          "+" Item name " + "        "+ "price");
   	      		for(Item item:items) 
   	      			System.out.println(item.getId() + "            " + item.getItemName()+ "                " +item.getPrice() ) ;
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			 System.out.println(e.getMessage()); 
   		}
      		 
      		}// end of show items

       /**
        * this method update an item
        * 
        * 
        */ 
       
       public static void updateItem() {
    	   showItems();
    	   try {
    		   MysqlItemDao  dao = new MysqlItemDao ();
    		     Scanner scan = new Scanner(System.in);
	  	    	 System.out.println(" Enter the id of the item to update ");
	  	    	 int id = scan.nextInt();
	  	    	 Scanner scan1 = new Scanner(System.in);
	  	      	 System.out.println(" Enter the new item to update  ");
	  	    	 String newItem = scan1.nextLine();
				 Scanner scan2= new Scanner(System.in);
				 System.out.println(" Enter the new price "); 
				 double newPrice  =scan2.nextDouble() ;
				 
				
				 Item item  = new Item(id,newItem,newPrice);
				 dao.update(item);
				 System.out.println(" A record  has been updated !");
				 scan1.close();
				 scan2.close();
				 scan.close();
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 System.out.println(e.getMessage()); 
			}
    	 
       
    	   
       }// end update item
       
       /**
        * this method delete an item
        * 
        * 
        */ 
       public static void deletItem() {
    	   
    	   showItems();
  	     try {
  	    	     MysqlItemDao  dao = new MysqlItemDao ();
				 Scanner scan = new Scanner(System.in);
				 System.out.println(" Enter the id of the item to delete  "); 
				 int id = scan.nextInt(); 
				 dao.delete(id);
				 System.out.println(" A record  has been deleted !");
				 scan.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				 System.out.println(e.getMessage()); 
			}
       }  // end delete 
       
     //------------------------------   Manage Orders ---------------------------------------------

       /**
        * this method insert an order
        * 
        * 
        */ 
       public static void insertOrder() {
    	    double totalPrice=0.0d;
    	    showCustomers();
    	     Scanner scan1 = new Scanner(System.in);
			 System.out.println(" Enter the id of the customer for which you want to add an order "); 
			 System.out.println();
			 int id_customer  =scan1.nextInt() ;
		 showItems();
			
			 Scanner scan3 = new Scanner(System.in);
			 System.out.println(" Enter the price for the  item . "); 
			 System.out.println();
			 double price_item  =(double)scan3.nextDouble();
			 
			 Scanner scan4 = new Scanner(System.in);
			 System.out.println(" Enter the quantity for the item "); 
			 System.out.println();
			 int quantity_item  =scan4.nextInt() ;
			 totalPrice = price_item * quantity_item; 
			 
			 try {
				 MysqlOrderDao dao = new MysqlOrderDao();
				 Order order = new Order(0,id_customer,totalPrice,quantity_item);
				 dao.create(order);
				 System.out.println(" An order has been added.");
				 scan1.close();
				 scan3.close();
				 scan4.close();
			 }
 	     catch ( Exception e) {
 	    	 System.out.println(e.getMessage());
 	     }
       }  // end insert order
       
       /**
        * this method show all orders
        * 
        * 
        */ 
       
       public static void showOrders() {
    	   try {
    		   MysqlOrderDao dao = new MysqlOrderDao();
      			 List<Order> orders= dao.readAll();
      			    System.out.println("orderid"+ "  " + "customer_id" + "   "+ "quantity" + "   " +"cost" );
      	      		for(Order order:orders)
      	      			
      	      			System.out.println( order.getOrders_id()+ "        " +order.getFk_customer_id() + "             "+ order.getQuantity()+"          " +order.getCost() ) ;
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			 System.out.println(e.getMessage()); 
      		}
    	   
       }// end show orders
       
       /**
        * this method update an order
        * 
        * 
        */ 
       public static void updateOrder() {
    	   double totalPrice=0.0d;
    	   showOrders();
    	   int fk_customer=0; // we update only the quantity
    	     // we update only the quantity
    	     Scanner scan1 = new Scanner(System.in);
			 System.out.println(" Enter the id  of the order to update "); 
			 System.out.println();
			 int id  =scan1.nextInt() ;
			 
			 Scanner scan2 = new Scanner(System.in);
			 System.out.println(" Enter the the new quantity "); 
			 System.out.println();
			 int new_quantity  =scan2.nextInt() ;
			 
			 Scanner scan3 = new Scanner(System.in);
			 System.out.println(" Enter the the price  "); 
			 System.out.println();
			 double price =scan3.nextDouble() ;
			 totalPrice = price * new_quantity;
			 try {
				 MysqlOrderDao dao = new MysqlOrderDao();
				 Order order = new Order(id,fk_customer,totalPrice,new_quantity);
				 dao.update(order);
				 System.out.println("The quantity for an order has been updated");
				 scan1.close();
				 scan2.close();
				 scan3.close();
			 }
    	     catch (Exception e) {
    	    	 System.out.println(e.getMessage());
    	     }
    	   
       }// end updateorder
        
       /**
        * this method delete an order
        * 
        * 
        */ 
       public static void  deleteOrder() {
    	   
    	   
       }
       
   //---------------------   Manage OrdersItems  --------------------------------------------
       /**
        * this method insert a detail of an order
        * 
        * 
        */ 
       
       public static void   insertOrdersItems() {
    	   double discount=0.0d;
    	   
		try {
			MysqlOrdersItemsDao dao = new MysqlOrdersItemsDao();
			List<Order> myOrder1 = dao.getInfoOrder();
			//System.out.println(myOrder1.get(3).getCost());
			
		if(  myOrder1.get(0).getCost() > 10000) {
				discount = (myOrder1.get(0).getCost()*10)/100;
			}else {
				 discount=0.0d;
			}
			OrdersItems ordersitem = new OrdersItems(0,myOrder1.get(0).getFk_customer_id(),3,myOrder1.get(0).getQuantity(),discount);
			
			dao.create(ordersitem);
			/*
			for(Order order:myOrder1) {
				System.out.print(order.getOrders_id());
			}*/
			System.out.println("A details for an order has been added .");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
    	    
    	     
    	   
    	     
       }// end ordersItems
       
       /**
        * this method show all record in ordersItems tabld       * 
        * 
        */ 
       public static void showOrdersDetails(){
    	   
    	   try {
    		   MysqlOrdersItemsDao dao = new MysqlOrdersItemsDao();
      			 List<OrdersItems> ordersItems= dao.readAll();
      			    System.out.println("ordersItems"+ "  " + "fk_ordres_Id" + "   "+ "fk_items_id,"+"    "+ "quantity" + "   " +"discount" );
      	      		for(OrdersItems orderItem:ordersItems)
      	      
      	      			System.out.println( orderItem.getId()+"            " +orderItem.getFk_orders()+ "              " +orderItem.getFk_items()+ "               "+ orderItem.getQuantity()+"          " +orderItem.getDiscount() ) ;
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			 System.out.println(e.getMessage()); 
      		}
    	   
       }// end showOrdersDetails
       
       
}// end class





      















