package com.db.dao;

import java.util.List;

import com.db.pojo.Product;

public interface ProductDao {
	
	public Boolean addProduct(Product p);
	public Boolean updateProduct(Product p);
	public Boolean deleteProduct(Integer productId);
	
	public List<Product> showAllProducts();
	public Product showProductById(Integer productId);
	public List<Product> searchProductByName(String productName);
	

}
