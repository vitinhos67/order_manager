package com.ordermanager.services.Item;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.common.errors.ItemNotFoundException;
import com.ordermanager.models.entitys.Item;
import com.ordermanager.models.repositorys.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	
	public Item createItem(Item item) {
		return this.itemRepository.save(item);
	}
	
	public Optional<Item> findById(int id) {
		return this.itemRepository.findById(id);
	}
	
	public List<Item> findAll() {
		return (List<Item>) this.itemRepository.findAll();
	}
	
	public List<Item> findAllByCategory(String category) {
		return this.itemRepository.findAllByCategory(category);
	}
	
	public Optional<Item> changeItemStatus(int id, ItemStatus status) throws Exception {
		
		Optional<Item> findItem = this.findById(id);
		
		if(!findItem.isPresent()) {
			throw new ItemNotFoundException("Item are Null!");
		}
		
		findItem.get().setStatus(status);
		
		this.itemRepository.save(findItem.get());
		return findItem;
		
	}
	


	
	
	
}
