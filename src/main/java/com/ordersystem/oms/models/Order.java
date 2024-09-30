package com.ordersystem.oms.models;

import java.util.ArrayList;
import jakarta.persistence.Entity;

@Entity
public class Order {
	public long orderId;
	long timestamp;
	ArrayList<Item> itemList;
	public Customer customer;
}
