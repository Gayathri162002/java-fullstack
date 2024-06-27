package com.liststackqueue;
	import java.util.LinkedList;

	class ShoppingCart {
	    LinkedList<String> cart;

	    public ShoppingCart() {
	        cart = new LinkedList<>();
	    }

	    public void addItem(String item) {
	        cart.add(item);
	    }

	    public void removeItem(String item) {
	        cart.remove(item);
	    }

	    public void viewCart() {
	        System.out.println("Items in the cart: " + cart);
	    }
	}

