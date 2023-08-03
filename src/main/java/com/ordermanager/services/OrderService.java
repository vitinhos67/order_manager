package com.ordermanager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.models.entitys.Item;
import com.ordermanager.models.entitys.Order;
import com.ordermanager.models.entitys.OrderDTO;
import com.ordermanager.models.repositorys.ItemRepository;
import com.ordermanager.models.repositorys.OrderRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired ItemRepository itemRepository;
	
	
	
    public Order create(OrderDTO order) throws Exception {
        // Validação dos itens existentes no banco de dados
        List<Item> itensFromOrder = new ArrayList<>();
        
        for (Integer item : order.getItens()) {
            Item itemExists = itemRepository.findById(item).orElse(null);
            
            
            if (itemExists != null) {
            	itensFromOrder.add(itemExists);
            } else {
                // Item não encontrado
                throw new Exception("Item não encontrado com o ID: " + item);
            }
        }

        Order saveOrder = new Order(itensFromOrder);
        
        // Salva o Pedido
        return orderRepository.save(saveOrder);
    }
	
}
