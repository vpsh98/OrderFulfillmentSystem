package com.ordersystem.oms.models;
import jakarta.persistence.Entity;

@Entity
public class Item {
	long itemId;
	String name;
	int price;
	String description;
}
