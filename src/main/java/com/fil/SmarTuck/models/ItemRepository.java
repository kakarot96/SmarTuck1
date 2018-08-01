package com.fil.SmarTuck.services;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fil.SmarTuck.models.Item;
import com.fil.SmarTuck.models.Shop; 
public interface ItemRepository extends CrudRepository<Item,Integer> 
{
  List<Item>findAllByShopId(int shopId);
}
