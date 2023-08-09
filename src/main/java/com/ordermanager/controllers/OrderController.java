package com.ordermanager.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.dtos.OrderDTO;
import com.ordermanager.models.entitys.Order;
import com.ordermanager.services.OrderService;




@RestController
@RequestMapping(path = "/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO order) throws Exception {
		
	       Order newOrder = this.orderService.create(order);
	       	return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
		

    }
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findOrders() {
	
		List<Order> listOrders = (List<Order>) this.orderService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listOrders);
		
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Order>> findById(@PathVariable int id) {
		Optional<Order> order = this.orderService.findById(id);	
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	
	
	
}
