package com.fil.SmarTuck.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fil.SmarTuck.models.Item;
import com.fil.SmarTuck.models.Shop;

@Service

public class ItemServiceImpl implements ItemService{
	@Autowired 
	private ItemRepository itemRepository;

	public List<Item> getAllItems() {
		
		
		List<Item> itemList=new ArrayList<Item>();
		itemRepository.findAll().forEach(i->itemList.add(i));
		return itemList;
			
	}

	public Optional<Item> getItemById(int id) {

		return itemRepository.findById(id);
	}

	public void addItem(Item item) {

		itemRepository.save(item);
		
	}

	public void deleteItem(int id) {
		
		itemRepository.deleteById(id);
	}

	@Override
	public List<Item> getAllByShopId(int shopId) {
		List<Item> itemList=new ArrayList<Item>();
		itemRepository.findAllByShopId(shopId).forEach(i->itemList.add(i));
		
		return itemList;
	}

	
}
