package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.model.Product;

/**
 * EMusicStore
 * @author Winnie Nov 17, 2016
 * ProductDaoInterface.java
 */

public interface ProductDao {
	
	void addProduct(Product product);
	void editProduct(Product product);
	Product getProductByID(String productID);
	List<Product> getAllProducts();
	void deleteProduct(String id);
}
