package com.emusicstore.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.emusicstore.model.Product;

/**
 * EMusicStore
 * @author Winnie Nov 16, 2016
 * ProductDao.java
 * Dao - Data Accessing Object
 */
public class ProductDaoDummy {
	private List<Product> productList;
	
	public List<Product> getProductList(){
		Product product1 = new Product();
		product1.setProductID("P123");
		product1.setProductName("Guitar");
		product1.setProductCategory("Instrument");
		product1.setProductDescription("This is a fender strat guitar!");
		product1.setProductPrice(1200);
		product1.setProductCondition("new");
		product1.setProductStatus("Active");
		product1.setUnitInStock(11);
		product1.setProductManufacturer("Fender");
		
		Product product2 = new Product();
		product2.setProductID("P124");
		product2.setProductName("Record");
		product2.setProductCategory("Record");
		product2.setProductDescription("This is an awesome mix of 20th century!");
		product2.setProductPrice(25);
		product2.setProductCondition("new");
		product2.setProductStatus("Active");
		product2.setUnitInStock(50);
		product2.setProductManufacturer("EMI");
		
		Product product3 = new Product();
		product3.setProductID("P125");
		product3.setProductName("Speaker");
		product3.setProductCategory("Accessory");
		product3.setProductDescription("This is a Folk Shelf Speaker!");
		product3.setProductPrice(355);
		product3.setProductCondition("new");
		product3.setProductStatus("Active");
		product3.setUnitInStock(9);
		product3.setProductManufacturer("Polk");
		
		
		productList = new ArrayList<Product>();
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		return productList;
	}


	public Product getProductByID(String productID) throws IOException{
		for(Product product : getProductList()){
			if(product.getProductID().equals(productID)){
				return product;
			}
		}
		throw new IOException("No product found");
	}
	
}
