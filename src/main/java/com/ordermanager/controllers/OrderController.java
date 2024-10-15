package com.ordermanager.controllers;

import com.ordermanager.dtos.OrderDTO;
import com.ordermanager.models.entitys.Order;
import com.ordermanager.services.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO order,
            @RequestParam(name = "idUser", required = false) int idUser)
            throws Exception {
        Order newOrder = this.orderService.create(order, idUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);

    }

    @GetMapping
    @Cacheable(value = "orders")
    public ResponseEntity<List<Order>> findOrders() {
        List<Order> listOrders = (List<Order>) this.orderService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listOrders);

    }

    @GetMapping(path = "/{id}")
    @Cacheable(value = "orders")
    public ResponseEntity<Order> findById(@PathVariable int id) {
        Order order = this.orderService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @GetMapping(path = "/date")
    @Cacheable(value = "orders-date")
    public ResponseEntity<List<Order>> findByDate(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        List<Order> orders = this.orderService.findByDate(date);
        return ResponseEntity.status(HttpStatus.OK).body(orders);

    }

}
