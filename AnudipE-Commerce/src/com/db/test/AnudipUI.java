package com.db.test;

import java.util.List;

import java.util.Scanner;

import com.db.dao.CustomerDao;
import com.db.dao.CustomerDaoImpl;
import com.db.dao.LoginDaoImpl2;
import com.db.dao.ProductDaoImpl;
import com.db.pojo.Customer;
import com.db.pojo.Product;

public class AnudipUI {

	public static void main(String[] args) {
		
		
		Integer option;
		Boolean exit=false, logout=false;
		Integer productId;         
		String productName;        
		String productType; 
		Double price;              
		Integer quantityInStock;   
		Double rating;             
		String description;  
		String choice;
		
		Integer custId;		
		String custName;                  
		String email;		 
		String permanentAddress;          
		Long contact;                     
		String password=null;	
		
		Scanner sc=new Scanner(System.in);
		
		Product p=null;
		ProductDaoImpl pimpl=new ProductDaoImpl();
		Customer c=null;
		CustomerDaoImpl cimpl=new CustomerDaoImpl();
		Boolean flag;
		List<Customer> custlist=null;
		List<Product> plist=null;
		
		System.out.println("-------------------------------Welcome to Anudip The One Stop Shop------------------------------------");
		while(logout==false) {
			
			System.out.println("Enter 1 to Customer Login");
			System.out.println("Enter 2 to Customer Register ");
			int i=sc.nextInt();
			sc.nextLine();
			
			if(i==1) {
				LoginDaoImpl2 limpl=cimpl.makeObject();
				
				System.out.print("Enter email: ");
				email=sc.nextLine();
				
				System.out.print("Enter password: ");
				password=sc.nextLine();
				
				if(limpl.adminLogin(email, password)) {
					
					System.out.println("You have logged in as admin!!!");
					System.out.println();
					System.out.println("-------------------------------Welcome to Anudip The One Stop Shop (Admin)------------------------------------");
					while(exit==false) {
						
						System.out.println("Enter the options as given below:-");
						System.out.println("1------> Add product");
						System.out.println("2------> Show all products");
						System.out.println("3------> Update product");
						System.out.println("4------> Delete a product");
						System.out.println("5------> Search product by name");
						
						option=sc.nextInt();
						sc.nextLine();
						
						switch(option) {
						
						case 1:
							System.out.print("Enter name of product: ");
			                productName = sc.nextLine();

			                System.out.print("Enter type of product: ");
			                productType = sc.nextLine();

			                System.out.print("Enter price of product: ");
			                price = sc.nextDouble();
			                sc.nextLine();

			                System.out.print("Enter number of product in stock: ");
			                quantityInStock = sc.nextInt();
			                sc.nextLine();

			                System.out.print("Enter rating for the product: ");
			                rating = sc.nextDouble();
			                sc.nextLine();

			                System.out.print("Enter short description of the product: ");
			                description=sc.nextLine();      
							
							p=new Product(productName, productType, price, quantityInStock,rating, description);
							
							flag=pimpl.addProduct(p);
							if(flag)
								System.out.println("Product added to database successfully!!!\n***************************************************");
							else 
								System.err.println("Error while adding the product to database..");
							break;
							
						case 2:
							plist=pimpl.showAllProducts();
							if(plist!=null && plist.isEmpty()!=true) {
								
								for(Product product : plist) {
									
									System.out.println(product);

								}
							}
							else
								System.err.println("Unable to show products at this moment!! Please try again later...");
							break;
							
						case 3:
							
							plist=pimpl.showAllProducts();
							if(plist!=null && plist.isEmpty()!=true) {
								
								for(Product product : plist) {
									System.out.println(product.getProductName()+" : "+product.getProductId());
									System.out.println("__________________________________________________\n");
								}
								
								System.out.print("Please enter the id of the product to be updated: ");
								productId=sc.nextInt();
								sc.nextLine();
								
								p=pimpl.showProductById(productId);
								if(p!=null) {
									
									System.out.println(p);
									System.out.print("Enter yes or no based on if you want to update this product: ");
									choice=sc.nextLine();
									
									if(choice.equalsIgnoreCase("yes")) {
										
										System.out.print("Enter name of product: ");
						                productName = sc.nextLine();

						                System.out.print("Enter type of product: ");
						                productType = sc.nextLine();

						                System.out.print("Enter price of product: ");
						                price = sc.nextDouble();
						                sc.nextLine();

						                System.out.print("Enter number of product in stock: ");
						                quantityInStock = sc.nextInt();
						                sc.nextLine();

						                System.out.print("Enter rating for the product: ");
						                rating = sc.nextDouble();
						                sc.nextLine();

						                System.out.print("Enter short description of the product: ");
						                description=sc.nextLine();
						                
						                p.setDescription(description);
						                p.setPrice(price);
						                p.setProductName(productName);
						                p.setProductType(productType);
						                p.setQuantityInStock(quantityInStock);
						                p.setRating(rating);
						                
						                flag=pimpl.updateProduct(p);
						                if(flag)
						                	System.out.println("Product updated successfully!");
						                else
						                	System.err.println("Error while updating product...");
									}
									else if(choice.equalsIgnoreCase("no"))
										System.out.println("No issues. Continue browsing");
									else 
										System.out.println("Please enter yes or no only!!!");
		
								}
								else 
									System.out.println("No product found by this id");
							
							}
							else
								System.err.println("Unable to show products at this moment!! Please try again later...");
							break;
							
						case 4:
							plist=pimpl.showAllProducts();
							if(plist!=null && plist.isEmpty()!=true) {
								
								for(Product product : plist) {
									
									System.out.println(product.getProductName()+" : "+product.getProductId());
									System.out.println("__________________________________________________\n");
								}
								
								System.out.print("Please enter the id of the product to be deleted: ");
								productId=sc.nextInt();
								sc.nextLine();
								
								p=pimpl.showProductById(productId);
								
								if(p!=null) {
									
									System.out.println("****Product******");
									System.out.println(p);
									
									System.out.println("Are you sure you want to delete this Product?");
									System.out.println("Answer in yes or no");
									choice=sc.next();
									sc.nextLine();
									
									if(choice.equalsIgnoreCase("yes")) {
										
										flag=pimpl.deleteProduct(productId);
										if(flag)
											System.out.println("Product with ID " + productId + " deleted successfully.");
										else
											System.out.println("Error while deleting product!!");
									}
									else
										System.out.println("No problem. Please continue browsing!!");
								}
								else
									System.out.println("No product of this id found!!");
							}
							
							break;
							
						case 5:
							
							System.out.print("Enter the name of the product you want to search: ");
							productName=sc.nextLine();
							
							plist=pimpl.searchProductByName(productName);
							if(plist!=null && plist.isEmpty()!=true) {
								
								for(Product product : plist) {
									System.out.println(product);
									System.out.println("__________________________________________________\n");
								}
							}
							else
								System.err.println("Unable to show products at this moment!! Please try again later...");
							break;
						}
					}
				}
				else if(limpl.customerLogin(email, password)) {
					
					System.out.println("-------------------------------Welcome to Anudip The One Stop Shop------------------------------------");
					exit=false;
					while(exit==false) {
						
						System.out.println("\n****************edit customer***************\nPlease enter the number as given in option ...");
						
						System.out.println("1--------> Add customer");
						System.out.println("2--------> Update customer");
						
						int opt=sc.nextInt();
						sc.nextLine();
						
						switch(opt) {
						
						case 1:
							System.out.print("Enter your name: ");
							custName=sc.nextLine();
							
							System.out.print("Enter your email: ");
							email=sc.nextLine();
							
							System.out.print("Enter your permanent address: ");
							permanentAddress=sc.nextLine();
							
							System.out.print("Enter your contact no: ");
							contact=sc.nextLong();
							sc.nextLine();
							
							System.out.print("Enter password: ");
							password=sc.nextLine();
							
							c=new Customer(custName, email, permanentAddress, contact, password);
							
							flag=cimpl.addCustomer(c);
							
							if(flag) {
								
								System.out.println("You are registered successfully.\n***************************************************");
								
							}
							else 
								System.err.println("Error while adding customer!!!");
							
							break;
							
						case 2:
							System.out.print("Enter id of customer to be updated: ");
							custId=sc.nextInt();
							sc.nextLine();
							
							c=cimpl.showCustomerById(custId);
							if(c!=null) {
								
								System.out.println(c);
								System.out.print("Enter yes or no based on if you want to update this product: ");
								choice=sc.nextLine();
								
								if(choice.equalsIgnoreCase("yes")) {
									
									System.out.print("Enter your name: ");
									custName=sc.nextLine();
									
									System.out.print("Enter your email: ");
									email=sc.nextLine();
									
									System.out.print("Enter your permanent address: ");
									permanentAddress=sc.nextLine();
									
									System.out.print("Enter your contact no: ");
									contact=sc.nextLong();
									sc.nextLine();
									
									System.out.print("Enter password: ");
									password=sc.nextLine();
					                
					                c.setCustName(custName);
					                c.setEmail(email);
					                c.setPermanentAddress(permanentAddress);
					                c.setContact(contact);
					                c.setPassword(password);
					                
					                flag=cimpl.updateCustomer(c);
					                if(flag)
					                	System.out.println("Customer updated successfully!");
					                else
					                	System.err.println("Error while updating Customer...");
								}
								else if(choice.equalsIgnoreCase("no"))
									System.out.println("No issues. Continue browsing");
								else 
									System.out.println("Please enter yes or no only!!!");
								
							}
							else 
								System.out.println("No Customer found by this id");
							break;
						}
					}
				}
				else 
					System.out.println("Credentials do not match Please try again...");
				
			}
			else if(i==2) {
				
				System.out.print("Enter your name: ");
				custName=sc.nextLine();
				
				System.out.print("Enter your email: ");
				email=sc.nextLine();
				
				System.out.print("Enter your permanent address: ");
				permanentAddress=sc.nextLine();
				
				System.out.print("Enter your contact no: ");
				contact=sc.nextLong();
				sc.nextLine();
				
				System.out.print("Enter password: ");
				password=sc.nextLine();
				
				c=new Customer(custName, email, permanentAddress, contact, password);
				
				flag=cimpl.addCustomer(c);
				
				if(flag) {
					
					System.out.println("You are registered successfully.\n***************************************************");
					
				}
				else 
					System.err.println("Error while adding customer!!!");
				
			}
			else 
				System.out.println("Please enter 1 or 2 only!!!");
		}
	}

}
