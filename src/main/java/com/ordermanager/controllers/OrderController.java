package com.ordermanager.controllers;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.dtos.OrderDTO;
import com.ordermanager.models.entitys.Order;
import com.ordermanager.services.Order.OrderService;





@RestController
@RequestMapping(path = "/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Order> createOrder
    (@RequestBody OrderDTO order,
    @RequestParam(name = "idUser", required = false)  int idUser) 
    		throws Exception {
			       Order newOrder = this.orderService.create(order, idUser);
			       	return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);

    }
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findOrders() {
	
		List<Order> listOrders = (List<Order>) this.orderService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listOrders);
		
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> findById(@PathVariable int id) {
		Order order = this.orderService.findById(id);	
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@RequestMapping(path = "/date", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findByDate(
			 @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
			{
		
		
		List<Order> orders = this.orderService.findByDate(date);
		
		return ResponseEntity.status(HttpStatus.OK).body(orders);
		
	}
	
	

	
	
}
