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
        List<Item> itensDoPedido = new ArrayList<>();
        
        for (Integer item : order.getItens()) {
            Item itemExistente = itemRepository.findById(item).orElse(null);
            
            
            if (itemExistente != null) {
            	itensDoPedido.add(itemExistente);
            } else {
                // Item não encontrado, você pode tratar o erro aqui
                throw new Exception("Item não encontrado com o ID: " + item);
            }
        }

        Order saveOrder = new Order(itensDoPedido);
        
        // Salva o Pedido
        return orderRepository.save(saveOrder);
    }
	
}
