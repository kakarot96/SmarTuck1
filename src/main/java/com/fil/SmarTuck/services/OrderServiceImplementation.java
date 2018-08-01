package com.fil.SmarTuck.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.SmarTuck.models.Order;
import com.fil.SmarTuck.models.OrderRepository;



@Service 
public class OrderServiceImplementation implements OrderService{

	@Autowired  
    private OrderRepository orderRepository;  
	
	List<Order> orderRecords = new ArrayList<>();
	List<Order> tempOrders = new ArrayList<>();
	List<List<Order>> order = new ArrayList<>();
	
    public List<List<Order>> getAllOrder(){        
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
    
    public List<Order> getOrder(String orderId){
    	int j = 0;
    	for(int i = 0; i < order.size(); i++){
    		if(order.get(i).contains(orderId)){
    			j = i;
    			break;
    		}
    	}
        return order.get(j);  
    }
    
    
    public void addOrder(List<Order> o){  		//order can come in multiple rows
        orderRepository.saveAll(o);  
    }
    
    
    
    public void updateOrder(String orderId, String status){
    	
    }
    
//    public void deleteOrder(List<Order> o){		//order can come in multiple rows
//    	orderRepository.deleteAll(o);  
//    }  
	
}
