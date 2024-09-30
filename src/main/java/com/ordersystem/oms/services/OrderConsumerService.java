package com.ordersystem.oms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ordersystem.oms.models.Order;
import com.ordersystem.oms.models.OrderQueue;
import com.ordersystem.oms.models.Warehouse;
import com.ordersystem.oms.repository.WarehouseRepository;

@Service
public class OrderConsumerService {

    @Autowired
    private OrderQueue orderQueue;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private WarehouseService warehouseService;  

    @Scheduled(fixedRate = 100)  // Every 100ms
    public void consumeOrders() {
        Order order = orderQueue.dequeue();
        while (order != null) {
            // Find the nearest warehouse
            Warehouse nearestWarehouse = warehouseRepository.findNearestWarehouse(order.customer.loc);

            warehouseService.fulfillOrder(nearestWarehouse, order);

            order = orderQueue.dequeue();
        }
    }
}
