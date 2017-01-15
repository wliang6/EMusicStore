package com.emusicstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String cartId;
	private Map<String, CartItem> cartItems;
	private double grandTotal;
	
	private Cart() {
		cartItems = new HashMap<String, CartItem>();
		grandTotal = 0;
	}
	
	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}
	
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	
	
	public void addCartItem(CartItem item){
		String productId = item.getProduct().getProductID();
		if(cartItems.containsKey(productId)){  //if this item is already in the cart
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(productId, existingCartItem); //set the productId with existingCartItem with newly updated quantity
		} else{
			cartItems.put(productId, item);
		}
		updateGrandTotal(); //change total price
	}
	
	public void removeCartItem(CartItem item){
		String productId = item.getProduct().getProductID();
		cartItems.remove(productId);
		updateGrandTotal();
	}
	
	public void updateGrandTotal() {
		grandTotal = 0;
		for(CartItem item : cartItems.values()){
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}
	
}
