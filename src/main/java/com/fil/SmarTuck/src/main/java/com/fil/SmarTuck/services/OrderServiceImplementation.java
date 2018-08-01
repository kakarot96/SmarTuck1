package com.fil.SmarTuck.services;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.SmarTuck.models.ItemRepository;
import com.fil.SmarTuck.models.Order;
import com.fil.SmarTuck.models.OrderRepository;



@Service 
public class OrderServiceImplementation implements OrderService{

	@Autowired  
    private OrderRepository orderRepository;  
	private ItemRepository itemRepository;
	
	List<Order> orderRecords;
	List<Order> tempOrders;
	List<List<Order>> order;
	
	@Override
    public List<List<Order>> getAllOrders(){ 
		orderRecords = new ArrayList<>();
		tempOrders = new ArrayList<>();
		order = new ArrayList<>();
        orderRepository.findAll().forEach(o -> orderRecords.add(o));    //lambda expression
        for(int i = 0; i < orderRecords.size(); i++){
	       
        	if(i == orderRecords.size() - 1){
    			if(orderRecords.get(i).getOrderId().equals(orderRecords.get(i - 1).getOrderId())){
            		tempOrders.add(orderRecords.get(i));
            		order.add(tempOrders);
            	}
            	else{
            	    tempOrders = new ArrayList<>();
            	    tempOrders.add(orderRecords.get(i));
            	    order.add(tempOrders);
            	}
        	}
        	else{
        	
        		if(orderRecords.get(i).getOrderId().equals(orderRecords.get(i + 1).getOrderId())){
	        		tempOrders.add(orderRecords.get(i));
	        	}
	        	else{
	        		tempOrders.add(orderRecords.get(i));
	        		order.add(tempOrders);
	        		tempOrders = new ArrayList<>();
	        	}
        	}
        }
        return order;  
    }
    

	@Override
	public List<List<Order>> findAllByShopId(int shopId) {
		// TODO Auto-generated method stub
		List<List<Order>> allOrders = new ArrayList<>();
		allOrders = getAllOrders();
		
		List<List<Order>> shopAllOrders = new ArrayList<>();
		
		for(List<Order> order: allOrders){
			if(order.get(0).getiNo().getShopId().equals(shopId)){
				shopAllOrders.add(order);
			}
		}
		return shopAllOrders;
	}
	
	@Override
    public List<Order> getOrderByOrderId(String orderId){
		return orderRepository.findAllByOrderId(orderId);
//    	int j = 0;
//    	for(int i = 0; i < order.size(); i++){
//    		if(order.get(i).contains(orderId)){
//    			j = i;
//    			break;
//    		}
//    	}
//        return order.get(j);  
    }
    
	@Override
    public void addOrder(List<Order> o){  		//order can come in multiple rows
        orderRepository.saveAll(o);  
    }
    
	@Override
    public void updateOrderStatus(String orderId, String status){
		List<Order> list = orderRepository.findAllByOrderId(orderId);
		for(Order o: list){
			o.setStatus(status);
		}
    	orderRepository.saveAll(list);
    }

	@Override
	public void updateOrderDeliveryTime(String orderId, Time deliveryTime) {
		// TODO Auto-generated method stub
		List<Order> list = orderRepository.findAllByOrderId(orderId);
		for(Order o: list){
			o.setDeliveryTime(deliveryTime);
		}
    	orderRepository.saveAll(list);
	}

	@Override
	public void updateOrderRating(List<Order> list) {
		// TODO Auto-generated method stub
		orderRepository.saveAll(list);
	}

	@Override
	public void updateOrderRatingUsingList(List<Order> list, ArrayList<Integer> ratingList) {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++){
			list.get(i).setRating(ratingList.get(i));
		}
	}

    
//    public void deleteOrder(List<Order> o){		//order can come in multiple rows
//    	orderRepository.deleteAll(o);  
//    }  
	
}
