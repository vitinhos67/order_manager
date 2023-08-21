package com.ordermanager.services.Order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.common.errors.ItemNotFoundException;
import com.ordermanager.dtos.OrderDTO;
import com.ordermanager.models.entitys.Item;
import com.ordermanager.models.entitys.Order;
import com.ordermanager.models.repositorys.ItemRepository;
import com.ordermanager.models.repositorys.OrderRepository;
import com.ordermanager.services.user.UserService;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired ItemRepository itemRepository;
	
	@Autowired
	UserService userService;
	
	
    public Order create(OrderDTO order, Optional<Integer> idUser) throws Exception {
        
        List<Item> itensFromOrder = new ArrayList<>();
        
        
        if(!idUser.isPresent()) {
        	throw new ItemNotFoundException("Usuario nao encontrado");
        }
       

        
        for (Integer item : order.getItens()) {
            Item itemExists = itemRepository.findById(item).orElse(null);
            
     
            
            if (itemExists != null) {
            	itensFromOrder.add(itemExists);
            } else {
                throw new Exception("Item não encontrado com o ID: " + item);
            }
        }

        Order saveOrder = new Order(itensFromOrder, idUser.get());
        

        return orderRepository.save(saveOrder);
    }
    
    public List<Order> findAll() {
    	return (List<Order>) this.orderRepository.findAll();   
    }
    
    public Optional<Order> findById(Integer id) {
    	return this.orderRepository.findById(id);
    }
    
    public List<Order> findByDate(LocalDate date) {
    	
    	System.out.println(date);
  
    	List<Order> orders = this.orderRepository.findAllByDate(date);
    	return orders;
    }
    
    
    
	
}
