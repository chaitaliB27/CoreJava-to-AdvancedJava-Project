package com.db.pojo;

public class Cart {

	private Integer cartId;
	private String email;
	private Integer productId; // foreign key references product(productId)
	private Integer quantity;
	
	//Product object will be able to give all deatails about product
	private Product product; // No need to create column for this.
}
