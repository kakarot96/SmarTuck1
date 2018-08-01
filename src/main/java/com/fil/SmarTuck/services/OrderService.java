package com.fil.SmarTuck.services;

import java.util.List;

import com.fil.SmarTuck.models.Order;

public interface OrderService {

	public List<List<Order>> getAllOrder();
	
	public List<Order> getOrder(String orderId);
	
	public void addOrder(List<Order> o);
}
