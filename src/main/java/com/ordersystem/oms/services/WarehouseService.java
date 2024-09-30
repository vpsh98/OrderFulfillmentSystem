package com.ordersystem.oms.services;
import org.springframework.stereotype.Service;

import com.ordersystem.oms.models.Order;
import com.ordersystem.oms.models.Warehouse;

@Service
public class WarehouseService {

    public void fulfillOrder(Warehouse warehouse, Order order) {
        // send the order to the warehouse for fulfillment
        System.out.println("Sending order " + order.orderId + " to " + warehouse.name);

    }
}
