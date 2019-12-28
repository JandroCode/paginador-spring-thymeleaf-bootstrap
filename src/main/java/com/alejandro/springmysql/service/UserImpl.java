package com.alejandro.springmysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alejandro.springmysql.model.User;
import com.alejandro.springmysql.repository.IUserRepository;

@Service("userservice")
public class UserImpl implements IUserService {
	
	@Autowired
	@Qualifier("userrepository")
	private IUserRepository userRepo;

	@Override
	public Page<User> listAllUsers(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	

}
