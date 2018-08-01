package com.fil.SmarTuck.services;

import java.util.List;
import java.util.Optional;

import com.fil.SmarTuck.models.Shop;

public interface ShopService {

	public List<Shop> getAllShops();
	public Optional<Shop> getShopById(int id);
	public void addShop(Shop shop);
	public void delete(int id);
	
}
  