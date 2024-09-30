package com.ordersystem.oms.models;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.stereotype.Component;

@Component
public class OrderQueue {

    private final ConcurrentLinkedQueue<Order> queue = new ConcurrentLinkedQueue<>();

    public void enqueue(Order order) {
        queue.add(order); 
    }

    public Order dequeue() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }
}
