package com.fil.SmarTuck.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Shop")
public class Shop
{
	@Id
	private int shopId;
	
	@Column(name = "sName")
	private String sName;
	
	@Column
	private String location;
    
	@Column
	private String contact;
	
	@Column
	private int status;
	
	public Shop() {
		super();
	}
	
	public int getShopid() {
		return shopId;
	}
	
	public void setShopid(int shopId) {
		this.shopId = shopId;
	}
	
	public String getSname() {
		return sName;
	}
	
	public void setSname(String sName) {
		this.sName = sName;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", sName=" + sName + ", location=" + location + ", contact=" + contact
				+ ", status=" + status + "]";
	}
	

}
