package com.ordermanager.models.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ordermanager.models.entitys.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer>, CrudRepository<Item, Integer> {
	public List<Item> findAllByCategory(String category);

	public void save(Optional<Item> findItem);
}
