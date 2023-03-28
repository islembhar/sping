package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UsersRequest;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UsersService service;
	
	@Autowired
	public UsersController(UsersService service) {
		
		super();
		this.service = service;
	}
	
	
	@PostMapping
	public UsersResponse createUsers(@RequestBody UsersRequest user) {
		return service.createUsers(user);
	}

	// DISPLAY ALL users
	@GetMapping
	public List<Users> getAll() {
		return service.getAllUsers();
	}
	@GetMapping("/{user_id}")
	public UsersResponse getUsersById(@PathVariable("user_id") int user_id) {
		return service.getUserById(user_id);
	}
	
	// Update user ???????
		@PutMapping("/{user_id}")
		public UsersResponse update(@PathVariable("user_id") int user_id, @RequestBody UsersRequest user) {
			return service.modifyUser(user_id, user);
		}

		// DELETE user by ID
		@DeleteMapping("/{user_id}")
		public String deleteUserById(@PathVariable("user_id") int user_id) {
			return service.deleteUserById(user_id);
		}

		// DELETE ALL user
		@DeleteMapping()
		public String deleteUsers() {
			return service.deleteUsers();
		}
		
		

}
