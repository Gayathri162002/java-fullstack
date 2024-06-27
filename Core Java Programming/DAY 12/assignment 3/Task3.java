package com.example.queuesorter;
import java.util.PriorityQueue;
import java.util.Queue;


public class QueueSorter {
    public static void sortQueue(Queue<Integer> queue) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(queue);
        while (!pq.isEmpty()) {
            queue.add(pq.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(1);
        queue.add(4);
        queue.add(1);
        queue.add(5);
        queue.add(9);
        queue.add(2);
        queue.add(6);
        queue.add(5);
        queue.add(3);
        queue.add(5);

        System.out.println("Original Queue: " + queue);
        sortQueue(queue);
        System.out.println("Sorted Queue: " + queue);
    }
}


