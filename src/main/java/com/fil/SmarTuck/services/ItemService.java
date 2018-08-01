package com.fil.SmarTuck.services;

import java.util.List;
import java.util.Optional;

import com.fil.SmarTuck.models.Item;

public interface ItemService {
	
	public List<Item> getAllItems();
	public Optional<Item> getItemById(int id);
	public void addItem(Item item);
	public void deleteItem(int id);
    public List<Item> getAllByShopId(int shopId);


}
