package com.liststackqueue;
import java.util.LinkedList;
import java.util.Queue;

class CustomerService {
    private Queue<String> serviceRequests;

    public CustomerService() {
        serviceRequests = new LinkedList<>();
    }

    public void addRequest(String request) {
        serviceRequests.add(request);
    }

    public void processRequest() {
        if (!serviceRequests.isEmpty()) {
            System.out.println("Processing request: " + serviceRequests.poll());
        } else {
            System.out.println("No pending customer service requests.");
        }
    }

    public void viewPendingRequests() {
        System.out.println("Pending requests: " + serviceRequests);
    }
}