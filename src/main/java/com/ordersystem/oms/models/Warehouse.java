package com.ordersystem.oms.models;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Warehouse {

	long warehouseId;
	public String name;
	String address;
	public Location loc;
	ConcurrentLinkedQueue<Order> orderQ = new ConcurrentLinkedQueue<Order>();

	public Warehouse(String n, Location location) {
		name = n;
		loc = location;
	}

}
