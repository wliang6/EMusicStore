package com.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * EMusicStore
 * @author Winnie Nov 16, 2016
 * Product.java
 */

@Entity //Tells Spring that this class is an entity to be stored as a table 
		//database. Whenever Spring is running, automatically generate database and persist this table into database
		//One class = one table; one instance of class = one row in table
public class Product {
	
	@Id //defines a unique primary key in table
	@GeneratedValue(strategy = GenerationType.AUTO) //when an instance is made and persisted into database, a product ID is generated automatically in the table in sequential order 
	private String productID;
	
	@NotEmpty (message = "The product name must not be null.")
	public String productName;
	private String productCategory;
	private String productDescription;
	
	@Min(value = 0, message = "The product price must not be less than zero.")
	private double productPrice;
	private String productCondition;
	private String productStatus;
	
	@Min(value = 0, message = "The product unit in stock must not be less than zero.")
	private int unitInStock;
	private String productManufacturer;
	//We don't want uploaded image file to be persisted on DB. We want this to be stored under our resources folder
	@Transient 
	private MultipartFile productImage; //a representation of an uploaded file received in a multipart request
	
	//Getters and setters
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	
}
