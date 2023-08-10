package com.ordermanager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.models.entitys.Item;
import com.ordermanager.services.Item.ItemService;
import com.ordermanager.services.Item.ItemStatus;

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
	
	@GetMapping(path = "/category")
	public ResponseEntity<List<Item>> findAllByCategory(@RequestParam(name="category") String category) {
		List<Item> itensFound = this.itemService.findAllByCategory(category);
		return ResponseEntity.status(HttpStatus.OK).body(itensFound);
	}
	
	
	@PutMapping
	public ResponseEntity<Optional<Item>> changeItemStatus(
			@RequestParam("id") int id,
			@RequestParam("status") ItemStatus status) 
			throws Exception {
		
		Optional<Item> item = this.itemService.changeItemStatus(id, status);
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(item);
		
	}
	
	

	
	
	
}
