package com.liststackqueue;
import java.util.LinkedList;
import java.util.Stack;

class PurchaseHistory {
    private Stack<LinkedList<String>> history;

    public PurchaseHistory() {
        history = new Stack<>();
    }

    public void savePurchase(LinkedList<String> cart) {
        history.push(new LinkedList<>(cart));
    }

    public void undoLastPurchase() {
        if (!history.isEmpty()) {
            history.pop();
        } else {
            System.out.println("No purchase history to undo.");
        }
    }

    public void viewPurchaseHistory() {
        System.out.println("Purchase History: " + history);
    }
}


