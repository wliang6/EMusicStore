package com.emusicstore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;

public class CartDaoImpl implements CartDao{

	private Map<String, Cart> listOfCarts;
	public CartDaoImpl() {
		listOfCarts = new HashMap<String, Cart>();
	}
	
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Unable to create a cart. A cart with the given id(%)" +
					"already" +  "exists.", cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Unable to update cart. The cart with the given id(%)" +
					"does not" +  "exists.", cart.getCartId()));
		}
		listOfCarts.put(cartId, cart);
	}

	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Unable to delete cart. The cart with the given id(%)" +
					"does not" +  "exists.", cartId));
		}
		listOfCarts.remove(cartId);
	}

}
