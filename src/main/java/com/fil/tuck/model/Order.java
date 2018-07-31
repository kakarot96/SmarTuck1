package com.fil.tuck.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "Order")
public class Order {

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//for auto increment
    private int sNo;  
    
	@Column (length = 100)
	private String orderId;
	
	
	// write relation
	@Column (length = 100)
    private String aId;
	
	
	//	write relation
	@Column (length = 100)
    private String iNo;
    
	@Column
	private int qty;
	
	@Column
	private int price;
	
	@Column
	private Date orderDate;
	
	@Column
	private Time orderTime;
	
	@Column
	private Time deliveryTime;
	
	@Column (length = 100)
	private String status;
	
	@Column (precision = 1, scale = 2)
	private double rating;
	
	@Column (length = 500)
    private String remarks;
}
