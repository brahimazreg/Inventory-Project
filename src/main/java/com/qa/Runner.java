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
			                             
			                    	insertCustomer(); 
			                            break;
			                    case 2:
			                            
			                    	deleteCustomer();
			                            break;
			                    case 3 :
			                            
			                    	updateCustomer();
			                            break;
			                    case 4 :
			                    	showCustomers();
			                    	    break;
			                    case 5 :
			                            
			                            System.exit(0);
			                            break;
			                   
			                   default:
			                            
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
			                           
			                    	insertItem();
			                            break;
			                    case 2:
			                           
			                    	deletItem();
			                            break;
			                    case 3 :
			                         
			                    	updateItem();
			                            break;
			                    case 4 :
			                    	showItems();
			                    	    break;
			                    case 5 :
			                            
			                            System.exit(0);
			                            break;
			                   
			                   default:
			                            
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
					System.out.println(" 7 - Update quantity of an orther.");
					System.out.println(" 8 - Exit. ");
					java.util.Scanner op = new  java.util.Scanner(System.in);
			                option = op.nextInt();
					switch (option){
			                    case 1:
			                           
			                    	insertOrder();
			                            break;
			                    case 2:
			                          
			                    	deleteOrder();
			                            break;
			                    case 3 :
			                            
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
		                        case 7:
		                        	updateOrderQuantity();
		                        	break;
			                    case 8 :
			                            
			                            System.exit(0);
			                            break;
			                   
			                   default:
			                          
			                            break;

					}// end swith
			  }while(option <1  || option > 8);	// end do
			
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
		
			scan1.close();
			scan2.close();
		} catch (Exception e) {
		
		

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
			
			scan1.close();
			scan2.close();  
		} catch (Exception e) {
			
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
			 
			
			 
			 try {
				 MysqlOrderDao dao = new MysqlOrderDao();
				 Order order = new Order(0,id_customer,price_item);
				 dao.create(order);
				 System.out.println(" An order has been added.");
				 scan1.close();
				 scan3.close();
				 
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
      			    System.out.println("orderid"+ "  " + "customer_id" + "   " + "cost" );
      	      		for(Order order:orders)
      	      			
      	      			System.out.println( order.getOrders_id()+ "       " +order.getFk_customer_id() + "             " +order.getCost() ) ;
      		} catch (Exception e) {
      			
      			 System.out.println(e.getMessage()); 
      		}
    	   
       }// end show orders
       
       /**
        * this method update an order
        * 
        * 
        */ 
       public static void updateOrder() {
    	   
    	   showOrders();
    	   int fk_customer=0; 
    	     
    	     Scanner scan1 = new Scanner(System.in);
			 System.out.println(" Enter the id  of the order to update "); 
			 System.out.println();
			 int id  =scan1.nextInt() ;
			 
			 Scanner scan3 = new Scanner(System.in);
			 System.out.println(" Enter the new price  "); 
			 System.out.println();
			 double price =scan3.nextDouble() ;
			 
			 try {
				 MysqlOrderDao dao = new MysqlOrderDao();
				 Order order = new Order(id,fk_customer,price);
				 dao.update(order);
				 System.out.println("The price has been updated");
				 scan1.close();
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
    	   
    	   showOrders();
  	     try {
  	    	     MysqlOrderDao dao = new MysqlOrderDao();
				 Scanner scan = new Scanner(System.in);
				 System.out.println(" Enter the id of the order to delete.  "); 
				 int id = scan.nextInt(); 
				 dao.delete(id);
				 System.out.println(" An order has been deleted");
				 scan.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				 System.out.println(e.getMessage()); 
			}
    	   
    	   
    	   
    	   
       }
       
   //---------------------   Manage OrdersItems  --------------------------------------------
       /**
        * this method insert a detail of an order
        * 
        * 
        */ 
      
       public static void   insertOrdersItems() {
    	  
    	   double discount=0.0d;
    	   double total=0.0d;
    	   int  i;
    	     showOrders();
    	     Scanner scan1 = new Scanner(System.in);
			 System.out.println(" Enter the id of the order for witch you want to add details "); 
			 System.out.println();
			 int order_id  =scan1.nextInt() ;
			
		     showItems();
			
			 Scanner scan2 = new Scanner(System.in);
			 System.out.println(" Enter the quantity  "); 
			 System.out.println();
			 int quantity  = scan2.nextInt();
    	   
			 Scanner scan3 = new Scanner(System.in);
			 System.out.println(" Enter the price  "); 
			 System.out.println();
			 double price   = scan3.nextDouble();
			 
			 Scanner scan4 = new Scanner(System.in);
			 System.out.println(" Enter the id of the item "); 
			 System.out.println();
			 int item_id  = scan4.nextInt();
			 
    	   
		try {
			MysqlOrdersItemsDao dao = new MysqlOrdersItemsDao();
			
			 
			
			 OrdersItems  orderItem = new OrdersItems(0,order_id,item_id,quantity,price);
			 dao.create(orderItem);
			
           
			
			 
			 scan1.close();
			 scan3.close();
			 
			 scan2.close();
			 scan4.close();
	
			
			
			System.out.println("A details order has been added .");
		} catch (Exception e) {
			
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
      			    System.out.println("ordersItems"+ "  " + "fk_ordres_Id" + "   "+ "fk_items_id,"+"    "+ "quantity" + "   " +"cost" );
      	      		for(OrdersItems orderItem:ordersItems)
      	      
      	      			System.out.println( orderItem.getId()+"            " +orderItem.getFk_orders()+ "              " +orderItem.getFk_items()+ "               "+ orderItem.getQuantity()+"          " +orderItem.getPrice() ) ;
      		} catch (Exception e) {
      		
      			 System.out.println(e.getMessage()); 
      		}
    	   
       }// end showOrdersDetails
       
       
       public static void updateOrderQuantity() {
    	  
    	   showOrdersDetails();
    	  
    	     
    	     Scanner scan1 = new Scanner(System.in);
			 System.out.println(" Enter the ordersItems for which you want to change the quantity"); 
			 System.out.println();
			 int ordersItems_id  =scan1.nextInt() ;
			 
			 Scanner scan2 = new Scanner(System.in);
			 System.out.println(" Enter the new quantity for the item"); 
			 System.out.println();
			 int newQuantity =scan2.nextInt() ;
			 
			 Scanner scan3 = new Scanner(System.in);
			 System.out.println(" Enter the new price for the item"); 
			 System.out.println();
			 double newPrice =scan3.nextDouble() ;
			
			 
			 try {
				 MysqlOrdersItemsDao dao = new MysqlOrdersItemsDao();
				 OrdersItems orderItem = new OrdersItems(ordersItems_id,0,0,newQuantity,newPrice);
				 dao.update(orderItem);
				 System.out.println("The quantity has been changed");
				 scan1.close();
				 scan2.close();
				 scan3.close();
			 }
    	     catch (Exception e) {
    	    	 System.out.println(e.getMessage());
    	     }
    	   
       }
       
       
}// end class





      















