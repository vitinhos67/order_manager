package com.ordermanager.models.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ordermanager.models.entitys.Order;


public interface OrderRepository extends PagingAndSortingRepository<Order, Integer>, CrudRepository<Order, Integer> {

}
