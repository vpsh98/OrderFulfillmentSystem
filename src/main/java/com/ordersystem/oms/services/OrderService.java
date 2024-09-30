package com.ordersystem.oms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystem.oms.models.Order;

@Service
public class OrderService {


    @Autowired 
    private LocationService locservice;
    
	public void processOrder(Order orderRequest) {
		// check and select warehouse starting the from nearest
		
		// place order in warehouse
		
	}

}
