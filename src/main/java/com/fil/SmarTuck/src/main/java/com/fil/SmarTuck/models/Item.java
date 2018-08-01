package com.fil.SmarTuck.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iNo;
	
	@ManyToOne
	@JoinColumn(name="shopId")
	private Shop shop; 
	
	@Column
	private String category;
	@Column
	private String itemName;
	@Column
	private int price;
	@Column
	private int quantity;
	@Column
	private int preperationTime;
	@Column
	private double rating;
	@Column
	private int itemrating_count;


	public Item() {
		super();
	}


	public Item(int iNo, Shop shop, String category, String itemName, int price, int quantity, int preperationTime,
			double rating, int itemrating_count) 
	{
		super();
		this.iNo = iNo;
		this.shop = shop;
		this.category = category;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.preperationTime = preperationTime;
		this.rating = rating;
		this.itemrating_count = itemrating_count;
	}


	public int getiNo() {
		return iNo;
	}


	public void setiNo(int iNo) {
		this.iNo = iNo;
	}


	public Shop getShop() {
		return shop;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPreperationTime() {
		return preperationTime;
	}


	public void setPreperationTime(int preperationTime) {
		this.preperationTime = preperationTime;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public int getItemrating_count() {
		return itemrating_count;
	}


	public void setItemrating_count(int itemrating_count) {
		this.itemrating_count = itemrating_count;
	}


	@Override
	public String toString() {
		return "Item [iNo=" + iNo + ", shop=" + shop + ", category=" + category + ", itemName=" + itemName + ", price="
				+ price + ", quantity=" + quantity + ", preperationTime=" + preperationTime + ", rating=" + rating
				+ ", itemrating_count=" + itemrating_count + "]";
	}



}
