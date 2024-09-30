package com.ordersystem.oms.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystem.oms.models.Location;
import com.ordersystem.oms.models.Warehouse;
import com.ordersystem.oms.repository.WarehouseRepository;

@Service
public class LocationService {
	
    @Autowired
    private WarehouseRepository warehouseRepository;  
    
	public Warehouse getNearestWareHouseId( Location userLoc) {
        List<Warehouse> warehouses = warehouseRepository.warehouses;
        
        return warehouses.stream()
                .min(Comparator.comparing(warehouse -> calculateDistance(userLoc, warehouse.loc)))
                .orElseThrow(() -> new RuntimeException("No warehouse found"));
	}
	
    private double calculateDistance(Location loc1, Location loc2) {

        return Math.sqrt(Math.pow(loc2.lat - loc1.lat, 2) + Math.pow(loc2.lon - loc1.lon, 2));
    }

//	
	
}
