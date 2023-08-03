package com.ordermanager.models.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ordermanager.models.entitys.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer>, CrudRepository<Item, Integer> {

}
