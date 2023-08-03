package com.ordermanager.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ordermanager.models.entitys.Order;
import com.ordermanager.models.entitys.OrderDTO;
import com.ordermanager.services.OrderService;




@RestController
@RequestMapping(path = "/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO order ) throws Exception {
		
	       Order novoPedido = this.orderService.create(order);
	       	return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
		

    }
	
	
	
}
