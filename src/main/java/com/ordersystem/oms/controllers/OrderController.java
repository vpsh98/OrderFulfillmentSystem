package com.ordersystem.oms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystem.oms.models.Order;
import com.ordersystem.oms.models.OrderQueue;
import com.ordersystem.oms.services.OrderService;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderQueue orderQueue;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order orderRequest) {
    	orderQueue.enqueue(orderRequest);
    	
		return new ResponseEntity<String>("Order placed successfully with orderId : "+
				orderRequest.orderId, HttpStatus.OK);
    }
    
    
}
