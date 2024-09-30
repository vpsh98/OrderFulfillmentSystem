package com.ordersystem.oms.models;

import jakarta.persistence.Entity;

@Entity
public class Customer {
	long customerId;
	String name;
	String address;
	public Location loc;
}
