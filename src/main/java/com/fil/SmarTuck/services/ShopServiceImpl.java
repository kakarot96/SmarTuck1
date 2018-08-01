package com.fil.SmarTuck.services;


import java.util.List;  
import java.util.Optional;  
import java.util.ArrayList;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.fil.SmarTuck.models.Shop;  
@Service  
public class ShopServiceImpl implements ShopService {  
    @Autowired  
    private ShopRepository shopRepository;  
    public List<Shop> getAllShops(){  
        List<Shop> shop = new ArrayList<>();  
        shopRepository.findAll().forEach(s->shop.add(s));   // lambda expression
        return shop;   
    }  
    public Optional<Shop> getShopById(int id){  
        return shopRepository.findById(id);  
    }  
    public void addShop(Shop shop){  
        shopRepository.save(shop);  
    }  
    public void delete(int id){  
        shopRepository.deleteById(id);  
    }
	
}