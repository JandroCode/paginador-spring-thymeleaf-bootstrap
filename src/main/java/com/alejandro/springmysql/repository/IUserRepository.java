package com.alejandro.springmysql.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.alejandro.springmysql.model.User;

@Repository("userrepository")
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {

}
