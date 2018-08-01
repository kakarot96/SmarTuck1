package com.fil.SmarTuck.services;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.fil.SmarTuck.models.Order;

public interface OrderService {

	public List<List<Order>> getAllOrders();
	
	public List<Order> getOrderByOrderId(String orderId);
	
	public void addOrder(List<Order> o);
	
	public void updateOrderStatus(String orderId, String status);
	
	public void updateOrderDeliveryTime(String orderId, Time deliveryTime);
	
	public void updateOrderRating(List<Order> list);
	
	public void updateOrderRatingUsingList(List<Order> list, ArrayList<Integer> ratingList);
	
	public List<List<Order>> findAllByShopId(int shopId);
}
