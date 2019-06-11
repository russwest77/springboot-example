package com.wondersgroup.store.user.service;

import org.springframework.stereotype.Service;

import com.wondersgroup.store.user.bo.User;

public interface UserService {
	
	void findAllUsers();
	
	void insert(User user);

	User findUserById(String id);

}
