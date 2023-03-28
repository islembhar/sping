package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.UsersRequest;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entities.Users;

public interface UsersService {
	
	
	UsersResponse createUsers(UsersRequest entity);
	List<Users> getAllUsers();
	UsersResponse getUserById(int user_id);
	String  deleteUserById(int user_id);
	String  deleteUsers();
	UsersResponse modifyUser(int user_id, UsersRequest user);

}
