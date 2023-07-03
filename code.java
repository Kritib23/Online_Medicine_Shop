/*
 * SOFTWARE ENGINEERING LAB ASSIGNMENT 1
 * NAME: KRITI BHARDWAJ
 * ROLL NO.: 20CS30028
 */

import java.util.*;

public class code {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int ch = 0;
        while(ch!=11) {
            System.out.print("\nSELECT OPTION FROM LIST BELOW:\n\n" +
                    "1> Create a new entity\n" +
                    "2> Delete an entity\n" +
                    "3> Print all entities\n" +
                    "4> Add a product to manufacturer\n" +
                    "5> Add a certain number of copies of a product to a shop\n" +
                    "6> Add an order of a product from a customer\n" +
                    "7> Process an order\n" +
                    "8> List all the purchases made by a customer\n" +
                    "9> List inventory of a shop (Products and counts)\n"+
                    "10> Products made by a manufacturer\n"+
                    "11> Exit\n\n" +
                    "OPTION NUMBER: ");
            		ch = input.nextInt();
                    switch(ch) {
                        case 1:
                            createEntity(input, idGen);
                            break;
                        case 2:
                        	deleteEntity(input);
                            break;
                        case 3:
                        	printEntity(input);
                        	break;
                        case 4:
                            addProductToManufacturer(input);
                            break;
                        case 5:
                            addProductCopyToShop(input);
                            break;
                        case 6:
                            OrderProduct(input);
                            break;
                        case 7:
                            processAnOrder(input);
                            break;
                        case 8:
                            purchasesByCustomer(input);
                            break;
                        case 9:
                        	shopInventory(input);
                        	break;
                        case 10:
                        	productsByManufacturer(input);
                        	break;
                        case 11:
                            System.out.println("\n\tBye!");
                            break;
                        default:
                            System.out.println("\n\tEnter a valid option number.");
                    }
        }
    }
	
	// array whose elements at indices 0, 1, 2, 3, 4 will be used as unique id for manufacturer, customer, product, shop/warehouse, delivery agent respectively
	static int[] idGen = {-1, -1, -1, -1, -1};
	
	static ArrayList<Manufacturer> m = new ArrayList<Manufacturer>();
	static ArrayList<Customer> c = new ArrayList<Customer>();
	static ArrayList<Product> p = new ArrayList<Product>();
	static ArrayList<ShopsAndWarehouses> s = new ArrayList<ShopsAndWarehouses>();
	static ArrayList<DeliveryAgent> ag = new ArrayList<DeliveryAgent>();
	static ArrayList<Orders> o = new ArrayList<Orders>(); // to store records of products getting ordered
	
	/*
	 * FOR UNIQUE ID:
	 * Every manufacturer is assigned its unique id as one of the non-negative integers with unit digit as either 0 or 5
	 * Every customer is assigned its unique id as one of the non-negative integers with unit digit as either 1 or 6
	 * Every product is assigned its unique id as one of the non-negative integers with unit digit as either 2 or 7
	 * Every shop/warehouse is assigned its unique id as one of the non-negative integers with unit digit as either 3 or 8
	 * Every delivery agent is assigned its unique id as one of the non-negative integers with unit digit as either 4 or 9 
	 */
	
	static void createEntity(Scanner input, int[] idGen) {
		System.out.print("\nSELECT THE TYPE OF ENTITY WHICH YOU WANT TO CREATE:\n\n" +
                "0> Manufacturer\n" +
                "1> Customer\n" +
                "2> Product\n" +
                "3> Shops and Warehouses\n" +
                "4> DeliveryAgent\n" +
                "\nOPTION NUMBER: ");
		int choice;
		choice = input.nextInt();
		switch(choice) {
	        case 0:
	            createManufacturer(input, idGeneration(0));
	            break;
	        case 1:
	            createCustomer(input, idGeneration(1));
	            break;
	        case 2:
	            createProduct(input, idGeneration(2));
	            break;
	        case 3:
	            createShopsAndWarehouses(input, idGeneration(3));
	            break;
	        case 4:
	            createDeliveryAgent(input, idGeneration(4));
	            break;
	        default:
	            System.out.println("\n\tEnter a valid option number.");
	    }
	}
	
	static void deleteEntity(Scanner input) {
		System.out.print("\nSELECT THE TYPE OF ENTITY WHICH YOU WANT TO DELETE:\n\n" +
                "0> Manufacturer\n" +
                "1> Customer\n" +
                "2> Product\n" +
                "3> Shops and Warehouses\n" +
                "4> DeliveryAgent\n" +
                "\nOPTION NUMBER: ");
		int choice;
		choice = input.nextInt();
		switch(choice) {
	        case 0:
	            deleteManufacturer(input);
	            break;
	        case 1:
	            deleteCustomer(input);
	            break;
	        case 2:
	            deleteProduct(input);
	            break;
	        case 3:
	            deleteShopsAndWarehouses(input);
	            break;
	        case 4:
	            deleteDeliveryAgent(input);
	            break;
	        default:
	            System.out.println("\n\tEnter a valid option number.");
	    }
	}
	
	static void printEntity(Scanner input) {
		System.out.print("\nSELECT THE TYPE OF ENTITY WHICH YOU WANT TO PRINT:\n\n" +
                "0> Manufacturer\n" +
                "1> Customer\n" +
                "2> Product\n" +
                "3> Shops and Warehouses\n" +
                "4> DeliveryAgent\n" +
                "\nOPTION NUMBER: ");
		int choice;
		choice = input.nextInt();
		switch(choice) {
	        case 0:
	            printManufacturer();
	            break;
	        case 1:
	            printCustomer();
	            break;
	        case 2:
	            printProduct();
	            break;
	        case 3:
	            printShopsAndWarehouses();;
	            break;
	        case 4:
	        	printDeliveryAgent();
	            break;
	        default:
	            System.out.println("\n\tEnter a valid option number.");
	    }
	}
	
	static void createManufacturer(Scanner input, int ID) {
		Manufacturer M = new Manufacturer();
		M.id = ID;
		System.out.println("Enter manufacturer name: ");
		input.nextLine();
		M.name = input.nextLine();
		System.out.println("Enter set of products which can be manufactured: ");
		int k=1;
		while(k==1) {
			System.out.println("Enter product name: ");
			String str = input.next();
			M.productSet.add(str);
			System.out.println("\nEnter 1 to add more product OR Enter 0 to finish inventory: ");
			k = input.nextInt();
		}
		
		m.add(M);
		System.out.print("Manufacturer created!\n");
	}
	
	static void deleteManufacturer(Scanner input) {
		System.out.print("\nFOLLOWING MANUFACTURERS ARE PRESENT:\n\n");
		for(int i=0; i<m.size(); i++) {
			System.out.print("ID: " + m.get(i).id + "\tNAME: " + m.get(i).name + "\n");
		}
		System.out.print("Enter ID of the manufacturer to delete: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<m.size(); i++) {
			if(m.get(i).id == temp) {
				m.remove(i);
				System.out.print("Manufacturer deleted!\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Manufacturer with ID " + temp + " doesnot exist previously. Invalid ID was entered!\n");
		}
	}
	
	static void printManufacturer() {
		System.out.print("\nPRINTING ALL MANUFACTURERS:\n");
		for(int i=0; i<m.size(); i++) {
			System.out.print("\nManufacturer " + (i+1) + "\n");
			System.out.print("ID: " + m.get(i).id + "\nNAME: " + m.get(i).name + "\nSET OF PRODUCTS: " + m.get(i).productSet + "\n");
		}
	}
	
	// function to print all the products made by a manufacturer
	static void productsByManufacturer(Scanner input) {
		System.out.print("\nFOLLOWING MANUFACTURERS ARE PRESENT:\n");
		for(int i=0; i<m.size(); i++) {
			System.out.print("ID: " + m.get(i).id + "\tNAME: " + m.get(i).name + "\n");
		}
		System.out.print("Enter ID of the manufacturer whose set of products is to be printed: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<m.size(); i++) {
			if(m.get(i).id == temp) {
				System.out.println("Set of products which can be manufactured by " + m.get(i).name + "(ID " + m.get(i).id + ") contains: " + m.get(i).productSet + "\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.println("Manufacturer with ID " + temp + " doesnot exist. Invalid ID was entered!\n");
		}
	}
	
	// function to add a product to the set of products a manufacturer can manufacture
	static void addProductToManufacturer(Scanner input){
		System.out.print("\nFOLLOWING MANUFACTURERS ARE PRESENT:\n");
		for(int i=0; i<m.size(); i++) {
			System.out.print("ID: " + m.get(i).id + "\tNAME: " + m.get(i).name + "\n");
		}
		System.out.print("Enter ID of the manufacturer to which you want to add a product: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<m.size(); i++) {
			if(m.get(i).id == temp) {
				System.out.print("Enter product name to be added: ");
				input.nextLine();
				String str = input.nextLine();
				m.get(i).productSet.add(str);
				System.out.print("Product added!\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Manufacturer with ID " + temp + " doesnot exist. Invalid ID was entered!\n");
		}
	}
	
	static void createShopsAndWarehouses(Scanner input, int ID) {
		ShopsAndWarehouses S = new ShopsAndWarehouses();
		S.id = ID;
		System.out.println("Enter name of shop/warehouse: ");
		input.nextLine();
		S.name = input.nextLine();
		System.out.println("Enter zipcode: ");
		S.zipcode = input.nextInt();
		System.out.println("Enter an inventory of the number of available copies of products: ");
		int k=1;
		while(k==1) {
			System.out.println("Enter <productName> <numberOfCopies> format: ");
			String str = input.next();
			int temp = input.nextInt();
			S.availableProducts.put(str, temp);
			System.out.println("\nEnter 1 to add more product OR Enter 0 to finish inventory: ");
			k = input.nextInt();
		}
		s.add(S);
		System.out.print("Shop/Warehouse created!\n");
	}
	
	static void deleteShopsAndWarehouses(Scanner input) {
		System.out.print("\nFOLLOWING SHOPS AND WAREHOUSES ARE PRESENT:\n");
		for(int i=0; i<s.size(); i++) {
			System.out.print("ID: " + s.get(i).id + "\tNAME: " + s.get(i).name + "\n");
		}
		System.out.print("Enter ID of the Shop/Warehouse to delete: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<s.size(); i++) {
			if(s.get(i).id == temp) {
				s.remove(i);
				System.out.print("Shop/Warehouse deleted!\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Shop/Warehouse with ID " + temp + " doesnot exist previously. Invalid ID was entered!\n");
		}
	}
	
	static void printShopsAndWarehouses() {
		System.out.print("\nPRINTING ALL SHOPS AND WAREHOUSES:\n");
		for(int i=0; i<s.size(); i++) {
			System.out.print("\nShop/Warehouse " + (i+1) + "\n");
			System.out.print("ID: " + s.get(i).id + "\nNAME: " + s.get(i).name + "\nZIPCODE: " + s.get(i).zipcode + "\nINVENTORY OF AVAILABLE COPIES OF PRODUCTS:\n");
			for (String j : s.get(i).availableProducts.keySet()) {
			  System.out.println("PRODUCT: " + j + "\t\tNUMBER OF COPIES: " + s.get(i).availableProducts.get(j));
		    }
			System.out.println();
		}
	}
	
	// function to list inventory of a shop
	static void shopInventory(Scanner input){
		System.out.print("\nFOLLOWING SHOPS AND WAREHOUSES ARE PRESENT:\n\n");
		for(int i=0; i<s.size(); i++) {
			System.out.print("ID: " + s.get(i).id + "\tNAME: " + s.get(i).name + "\n");
		}
		System.out.print("Enter ID of the Shop/Warehouse whose inventory is to be printed: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<s.size(); i++) {
			if(s.get(i).id == temp) {
				for (String j : s.get(i).availableProducts.keySet()) {
				  System.out.println("PRODUCT: " + j + "\tNUMBER OF COPIES: " + s.get(i).availableProducts.get(j));
				}
				System.out.println();
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Shop/Warehouse with ID " + temp + " doesnot exist. Invalid ID was entered!\n");
		}
	}
	
	// function to add a certain number of copies of a product to a shop
	static void addProductCopyToShop(Scanner input) {
		System.out.print("\nFOLLOWING SHOPS AND WAREHOUSES ARE PRESENT:\n\n");
		for(int i=0; i<s.size(); i++) {
			System.out.print("ID: " + s.get(i).id + "\tNAME: " + s.get(i).name + "\n");
		}
		System.out.print("Enter ID of the Shop/Warehouse to which you want to add copies of a product: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<s.size(); i++) {
			if(s.get(i).id == temp) {
				System.out.print("\nFOLLOWING PRODUCTS ARE PRESENT IN THE SHOP:\n");
				for (String j : s.get(i).availableProducts.keySet()) {
				  System.out.println("PRODUCT: " + j + "\t\tNUMBER OF COPIES: " + s.get(i).availableProducts.get(j));
				}
				System.out.print("Enter name of the product whose number of copies is to be added: ");
				String str = input.next();
				int flag1 = 0;
				for (String j : s.get(i).availableProducts.keySet()) {
				  if(str.equals(j)) {
					  System.out.print("Enter the number of copies to be added: ");
					  int temp1 = input.nextInt();
					  s.get(i).availableProducts.replace(j, (s.get(i).availableProducts.get(j) + temp1));
					  System.out.print("Added successfully!\n");
					  flag1++;
					  break;
				  }
				}
				
				if(flag1==0) {
					System.out.print("Product with name " + str + " doesnot exist. Invalid name was entered!\n");
				}
				
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Shop/Warehouse with ID " + temp + " doesnot exist. Invalid ID was entered!\n");
		}
	}
	
	static void createProduct(Scanner input, int ID) {
		Product P = new Product();
		P.id = ID;
		System.out.println("Enter name of product: ");
		input.nextLine();
		P.name = input.nextLine();
		System.out.println("Enter name of manufacturer who manufactured the product: ");
		String str = input.nextLine();
		P.productManufacturer.put(P.name, str);
		
		p.add(P);
		System.out.print("Product created!\n");
	}
	
	static void deleteProduct(Scanner input) {
		System.out.print("\nFOLLOWING PRODUCTS ARE PRESENT:\n\n");
		for(int i=0; i<p.size(); i++) {
			System.out.print("ID: " + p.get(i).id + "\tNAME: " + p.get(i).name + "\n");
		}
		System.out.print("Enter ID of the Product to delete: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<p.size(); i++) {
			if(p.get(i).id == temp) {
				p.remove(i);
				System.out.print("Product deleted!\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Product with ID " + temp + " doesnot exist previously. Invalid ID was entered!\n");
		}
	}
	
	static void printProduct() {
		System.out.print("\nPRINTING ALL PRODUCTS:\n");
		for(int i=0; i<p.size(); i++) {
			System.out.print("\nProduct " + (i+1) + "\n");
			System.out.print("ID: " + p.get(i).id + "\nNAME: " + p.get(i).name + "\nMANUFACTURED BY: " + p.get(i).productManufacturer.get(p.get(i).name) + "\n");
		}
	}
	
	static void createCustomer(Scanner input, int ID) {
		Customer C = new Customer();
		C.id = ID;
		System.out.println("Enter name of Customer: ");
		input.nextLine();
		C.name = input.nextLine();
		System.out.println("Enter zipcode: ");
		C.zipcode = input.nextInt();
		
		c.add(C);
		System.out.print("Customer created!\n");
	}
	
	static void deleteCustomer(Scanner input) {
		System.out.print("\nFOLLOWING CUSTOMERS ARE PRESENT:\n");
		for(int i=0; i<c.size(); i++) {
			System.out.print("ID: " + c.get(i).id + "\tNAME: " + c.get(i).name + "\n");
		}
		System.out.print("Enter ID of the Customer to delete: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<c.size(); i++) {
			if(c.get(i).id == temp) {
				c.remove(i);
				System.out.print("Customer deleted!\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Customer with ID " + temp + " doesnot exist previously. Invalid ID was entered!\n");
		}
	}
	
	static void printCustomer() {
		System.out.print("\nPRINTING ALL CUSTOMERS:\n");
		for(int i=0; i<c.size(); i++) {
			System.out.print("\nCustomer " + (i+1) + "\n");
			System.out.print("ID: " + c.get(i).id + "\nNAME: " + c.get(i).name + "\nLIST OF PURCHASED PRODUCTS: " + c.get(i).purchasedProducts + "\n");
		}
	}
	
	// function to print all the purchases made by a customer
	static void purchasesByCustomer(Scanner input) {
		System.out.print("\nFOLLOWING CUSTOMERS ARE PRESENT:\n\n");
		for(int i=0; i<c.size(); i++) {
			System.out.print("ID: " + c.get(i).id + "\tNAME: " + c.get(i).name + "\n");
		}
		System.out.print("Enter ID of the Customer to whose purchase list is to be printed: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<c.size(); i++) {
			if(c.get(i).id == temp) {
				System.out.println("LIST OF PURCHASED PRODUCTS BY CUSTOMER NAMED " + c.get(i).name + " ID " + c.get(i).id + " CONTAINS: " + c.get(i).purchasedProducts + "\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Customer with ID " + temp + " doesnot exist previously. Invalid ID was entered!\n");
		}
	}
	
	static void createDeliveryAgent(Scanner input, int ID) {
		DeliveryAgent AG = new DeliveryAgent();
		AG.id = ID;
		System.out.println("Enter name of delivery agent: ");
		input.nextLine();
		AG.name = input.nextLine();
		System.out.println("Enter zipcode: ");
		AG.zipcode = input.nextInt();
		System.out.println("Enter number of delivered products: ");
		AG.deliveredProducts = input.nextInt();
		
		ag.add(AG);
		System.out.print("Delivery Agent created!\n");
	}
	
	static void deleteDeliveryAgent(Scanner input) {
		System.out.print("\nFOLLOWING DELIVERY AGENTS ARE PRESENT:\n\n");
		for(int i=0; i<ag.size(); i++) {
			System.out.print("ID: " + ag.get(i).id + "\tNAME: " + ag.get(i).name + "\n");
		}
		System.out.print("Enter ID of the DeliveryAgent to delete: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<ag.size(); i++) {
			if(ag.get(i).id == temp) {
				ag.remove(i);
				System.out.print("Delivery Agent deleted!\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Delivery Agent with ID " + temp + " doesnot exist previously. Invalid ID was entered!\n");
		}
	}
	
	static void printDeliveryAgent() {
		System.out.print("\nPRINTING ALL DELIVERY AGENTS:\n\n");
		for(int i=0; i<ag.size(); i++) {
			System.out.print("\nDelivery Agent " + (i+1) + "\n");
			System.out.print("ID: " + ag.get(i).id + "\nNAME: " + ag.get(i).name + "\nNUMBER OF DELIVERED PRODUCTS: " + ag.get(i).deliveredProducts + "\n");
		}
	}
	
	// function to add an order of a product and number of copies of product required in the order from a customer
	static void OrderProduct(Scanner input) {
		System.out.print("\nFOLLOWING CUSTOMERS ARE PRESENT:\n\n");
		for(int i=0; i<c.size(); i++) {
			System.out.print("ID: " + c.get(i).id + "\tNAME: " + c.get(i).name + "\n");
		}
		System.out.print("Enter ID of the Customer who is going to place an order: ");
		int temp = input.nextInt();
		int flag = 0;
		for(int i=0; i<c.size(); i++) {
			if(c.get(i).id == temp) {
				int flag1=0;
				for(int j=0; j<o.size(); j++) {
					// if any customer is placing another order, adding his/her new order to the list of his/her order 
					if(o.get(j).customerID == temp) {
						System.out.print("Enter name of product and number of copies to be ordered: ");
						String str = input.next();
						int temp1 = input.nextInt();
						o.get(j).productCopies.put(str, temp1);
						flag1++;
						break;
					}
				}
				
				// if customer is placing an order for the first time
				if(flag1==0) {
					Orders O = new Orders();
					O.customerID = temp;
					System.out.print("Enter name of product and number of copies to be ordered: ");
					String str = input.next();
					int temp1 = input.nextInt();
					O.productCopies.put(str, temp1);
					o.add(O);
				}
				
				System.out.print("Order successfully placed!\n");
				flag++;
				break;
			}
		}
		
		if(flag==0) {
			System.out.print("Customer with ID " + temp + " doesnot exist previously. Invalid ID was entered!\n");
		}
	}
	
	// function to process an order
	static void processAnOrder(Scanner input) {
		if(o.size() > 0){
			System.out.print("\nFOLLOWING ORDERS ARE PLACED SO FAR:\n\n");
			for(int i=0; i<o.size(); i++) {
				System.out.print("\nCUSTOMER ID " + o.get(i).customerID + "\n");
				for (String j : o.get(i).productCopies.keySet()) {
				  System.out.println("PRODUCT NAME: " + j + "\tNUMBER OF COPIES: " + o.get(i).productCopies.get(j));
				}
			}
			
			System.out.print("\nEnter ID of the customer whose order is to be processed: ");
			int temp = input.nextInt();
			int flag = 0;
			int flag1 = 0;
			for(int i=0; i<o.size(); i++) {
				if(o.get(i).customerID == temp) {
					System.out.print("\nFOLLOWING ORDERS WERE PLACED BY THIS ID\n\n");
					for (String j : o.get(i).productCopies.keySet()) {
					  System.out.println("PRODUCT NAME: " + j + "\tNUMBER OF COPIES: " + o.get(i).productCopies.get(j));
					}
					
					System.out.print("Enter name of the ordered product to be processed: ");
					input.nextLine();
					String str = input.nextLine();
					for(int j=0; j<c.size(); j++) {
						if(c.get(j).id == o.get(i).customerID) {
							int zCode = c.get(j).zipcode;
							Integer quantity = o.get(i).productCopies.get(str);
							int index = isAvailable(zCode, str, (int)quantity); // getting shop index if product is available to be delivered
							if(index != -1) {
								// modifying other details once product availability is confirmed in a shop
								c.get(j).purchasedProducts.add(str);
								s.get(index).availableProducts.replace(str, (s.get(index).availableProducts.get(str) - o.get(i).productCopies.get(str)));
								int index1 = assignDeliveryAgent();
								ag.get(index1).deliveredProducts += o.get(i).productCopies.get(str);
								o.get(i).productCopies.remove(str); // removing order from the list of orders once order is processed
								System.out.print("Order processed successfully!\n");
								flag++;
								break;
							}
						}
					}
					flag1++;
					break;
				}			
			}
			
			if(flag1==0) {
				System.out.print("Customer with ID " + temp + " has no orders to proceed!\n");
			}
			else if(flag==0) {
				System.out.print("Product isn't available!\n");
			}
		}
		else {
			System.out.println("NO ORDERS PLACED SO FAR!");
		}
	}
	
	// function to check if ordered product is available at any shop in customer's zipcode
	static int isAvailable(int zCode, String str, int quantity) {
		int index = -1;
		for(int i=0; i<s.size(); i++) {
			if(s.get(i).zipcode == zCode) {
				for (String j : s.get(i).availableProducts.keySet()) {
					if(str.equals(j) && s.get(i).availableProducts.get(j)>=quantity) {
						index = i;
						break;
					}
				}
			}
		}
		
		return index;
	}
	
	// function to assign a delivery agent who has delivered the least number of products
	static int assignDeliveryAgent() {
		int index = 0;
		int min = ag.get(0).deliveredProducts;
		for(int i=1; i<ag.size(); i++) {
			if(ag.get(i).deliveredProducts < min) {
				min = ag.get(i).deliveredProducts;
				index = i;
			}
		}
		
		return index;
	}
	
	// function to generate unique id for entities being created
	static int idGeneration(int index) {
		if(idGen[index] == -1) {
    		idGen[index] = index;
    	}
    	else {
    		idGen[index] += 5;
    	}
		
		return idGen[index];
	}
}

class Entity{
	int id;
	String name;
}

class Manufacturer extends Entity{
	Set<String> productSet = new HashSet<String>(); // to store set of products a manufacturer can manufacture
}

class Customer extends Entity{
	int zipcode;
	ArrayList<String> purchasedProducts = new ArrayList<>(); // to store purchased products by a customer
}

class Product extends Entity{
	HashMap<String, String> productManufacturer = new HashMap<String, String>(); // to store product name and its manufacturer's name respectively
}

class ShopsAndWarehouses extends Entity{
	int zipcode;
	HashMap<String, Integer> availableProducts = new HashMap<String, Integer>(); // to store product name and its available number of copies in the shop
}

class DeliveryAgent extends Entity{
	int zipcode;
	int deliveredProducts; // to store number of products delivered by a delivery agent
}

class Orders{
	int customerID; // to store id of customer placing an order
	HashMap<String, Integer> productCopies = new HashMap<String, Integer>(); // to store product name and its required number of copies in the order
}

