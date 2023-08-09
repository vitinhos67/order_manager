package com.ordermanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.models.entitys.Item;
import com.ordermanager.services.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@PostMapping
	public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
		
		Item newItem = this.itemService.createItem(item);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		
		List<Item> itens = this.itemService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(itens);
	}
	
	
	
	
}
