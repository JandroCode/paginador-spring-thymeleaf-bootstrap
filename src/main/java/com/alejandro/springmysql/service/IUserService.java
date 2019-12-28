package com.alejandro.springmysql.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alejandro.springmysql.model.User;

public interface IUserService {
	public Page<User> listAllUsers(Pageable pageable);

}
