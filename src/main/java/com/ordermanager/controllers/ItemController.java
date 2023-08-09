package com.ordermanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public Item createItem(@Valid @RequestBody Item item) {
		return this.itemService.createItem(item);
	}
	
	
	
	
}
