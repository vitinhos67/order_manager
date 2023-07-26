package com.ordermanager.models.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ordermanager.models.entitys.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>, CrudRepository<User, Integer> {

}
