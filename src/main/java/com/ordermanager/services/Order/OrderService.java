package com.ordermanager.services.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.dtos.OrderDTO;
import com.ordermanager.models.entitys.Item;
import com.ordermanager.models.entitys.Order;

import com.ordermanager.models.repositorys.OrderRepository;
import com.ordermanager.services.Item.ItemService;
import com.ordermanager.services.user.UserService;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired ItemService itemService;
	
	@Autowired
	UserService userService;
	
	
    public Order create(OrderDTO order, Integer idUser) throws Exception {
        
        List<Item> itensFromOrder = new ArrayList<>();
        
        userService.findUserById(idUser);
        
                
        for (Integer item : order.getItens()) {
            Item itemExists = itemService.findById(item);
            
            if (itemExists != null) {
            	itensFromOrder.add(itemExists);
            } else {
                throw new Exception("Item não encontrado com o ID: " + item);
            }
        }

        Order saveOrder = new Order(itensFromOrder, idUser);
        

        return orderRepository.save(saveOrder);
    }
    
    public List<Order> findAll() {
    	return (List<Order>) this.orderRepository.findAll();   
    }
    
    public Optional<Order> findById(Integer id) {
    	return this.orderRepository.findById(id);
    }
    
    public List<Order> findByDate(LocalDate date) {
    	
    	List<Order> orders = this.orderRepository.findAllByDate(date);
    	return orders;
    }
    
    
    
	
}
