package com.liststackqueue;

public class shoppingApp {
	public static void main(String[] args) {
        // Shopping cart operations
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple");
        cart.addItem("Banana");
        cart.viewCart();
        cart.removeItem("Apple");
        cart.viewCart();

        // Purchase history operations
        PurchaseHistory history = new PurchaseHistory();
        cart.addItem("Grapes");
        history.savePurchase(cart.cart);  // Save the current state of the cart
        cart.viewCart();
        history.viewPurchaseHistory();
        history.undoLastPurchase();
        history.viewPurchaseHistory();

        // Customer service operations
        CustomerService service = new CustomerService();
        service.addRequest("Need help with my order.");
        service.addRequest("Request for a refund.");
        service.viewPendingRequests();
        service.processRequest();
        service.viewPendingRequests();
    }
}

