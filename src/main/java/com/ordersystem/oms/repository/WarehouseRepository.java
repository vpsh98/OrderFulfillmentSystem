package com.ordersystem.oms.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ordersystem.oms.models.Location;
import com.ordersystem.oms.models.Warehouse;

@Repository
public class WarehouseRepository {

    public final List<Warehouse> warehouses = List.of(
            new Warehouse("Warehouse1", new Location(40, -74)),  
            new Warehouse("Warehouse2", new Location(34, -118))  
        );

    public Warehouse findNearestWarehouse(Location orderLocation) {
        return warehouses.stream()
            .min((w1, w2) -> Double.compare(
                distance(orderLocation, w1.loc), 
                distance(orderLocation, w2.loc)
            ))
            .orElseThrow(() -> new RuntimeException("No warehouses available"));
    }

    private double distance(Location loc1, Location loc2) {

        double latDiff = loc1.lat - loc2.lat;
        double lonDiff = loc1.lon - loc2.lon;
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }
}
