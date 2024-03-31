package com.db.test;

import java.util.List;
import java.util.Scanner;

import com.db.dao.ProductDaoImpl;
import com.db.pojo.Product;

public class ProductUI {

	public static void main(String[] args) {

		boolean exit = false;
		int option = 0;
		Scanner sc = new Scanner(System.in);
		Integer productId;
		String productName;
		String productType; 
		Double price;
		Integer quantityInStock;
		Double rating;
		String description;
		
		String choice;
		
		Product p = null;
		ProductDaoImpl pimpl = new ProductDaoImpl();
		Boolean flag;
		List<Product> plist = null;
		
		System.out.println("*****Welcome to Anudip The One Stop Shop*****");
		while(exit==false) {
			
			System.out.println("Enter the options as given below: ");
			System.out.println("1----->Add product");
			System.out.println("2----->Show all products");
			System.out.println("3----->Update product");
			System.out.println("4----->Delete product");
			System.out.println("5----->Search product by name");
			
			option = sc.nextInt();
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

                System.out.print("Enter rating for the product between 1 to 5: ");
                rating = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter short description of the product: ");
                description = sc.nextLine();
                
				p = new Product(productName, productType, price, quantityInStock, rating, 
						description);
				
				flag = pimpl.addProduct(p);
				
				if(flag)
					System.out.println("Product added to database successfully!!!");
				else
					System.out.println("Error while adding the product to database!!!");
				
				break;
				
			case 2:
				plist = pimpl.showAllProducts();
				if(plist!=null && plist.isEmpty()!=true) {
				
					for(Product product:plist) {
						
						System.out.println(product);
						System.out.println("______________________________________"
								+ "________________________________________________"
								+ "_________________________________________________");
					}
				}
				else {
					
					System.out.println("Unable to show product at this moment!!!" + 
					"nPlease try again later");
				}
				
				break;
				
			case 3:
				plist = pimpl.showAllProducts();
				if(plist!=null && plist.isEmpty()!=true) {
				
					for(Product product:plist) {
						
						System.out.println(product.getProductName() + " : " 
						+ product.getProductId());
						System.out.println("______________________________________"
								+ "________________________________________________"
								+ "_________________________________________________");
					}
					
					System.out.println("Please enter the id of the product to be updated: ");
					productId = sc.nextInt();
					sc.nextLine();
					
					p = pimpl.showProductById(productId);
					if(p!=null) {
						
						System.out.println(p);
						System.out.println("Enter yes or no based on if you wamt to update this product");
						choice = sc.nextLine();
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

			                System.out.print("Enter rating for the product between 1 to 5: ");
			                rating = sc.nextDouble();
			                sc.nextLine();

			                System.out.print("Enter short description of the product: ");
			                description = sc.nextLine();
							
			                p.setDescription(description);
			                p.setPrice(price);
			                p.setProductName(productName);
			                p.setProductType(productType);
			                p.setQuantityInStock(quantityInStock);
			                p.setRating(rating);
			                
			                flag = pimpl.updateProduct(p);
			                if(flag)
			                	System.out.println("Product updated successfully");
			                else
			                	System.out.println("Error while updating product!!!");
						}
						else if(choice.equalsIgnoreCase("no")) {
							
							System.out.println("No issues. Continue browsing");
						}
						else {
							
							System.out.println("Please enter yes or no only!!!");
						}
					}
					else {
						
						System.out.println("No product found by this id");
					}
				}
				else {
					
					System.out.println("Unable to show product at this moment!!!" + 
					"nPlease try again later");
				}
				
				break;
				
			case 4:
				
			
			
			case 5:
				System.out.println("Enter the name of the product you want to search:");
				productName = sc.nextLine();
				
				plist  = pimpl.searchProductByName(productName);
				if(plist!=null && plist.isEmpty()!=true) {
					
					for(Product product:plist) {
						
						System.out.println(product);
						System.out.println("______________________________________"
								+ "________________________________________________"
								+ "_________________________________________________");
					}
				}
				else {
					
					System.out.println("Unable to show product at this moment!!!" + 
							"nPlease try again later");
				}
			
			}
			
		}
		
	}

}
