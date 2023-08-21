package com.ordermanager.models.repositorys;

import java.util.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ordermanager.models.entitys.Order;


public interface OrderRepository extends PagingAndSortingRepository<Order, Integer>, CrudRepository<Order, Integer> {
    List<Order> findAllByCreatedAt(Date createdAt);
}
