package com.example.demo.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.RoleRequest;
import com.example.demo.dto.RoleResponse;
import com.example.demo.dto.SupervisorResponse;
import com.example.demo.entities.Role;
import com.example.demo.services.RoleService;


@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	private RoleService service;
	
	
	@Autowired
	public RoleController(RoleService service) {
		
		super();
		this.service = service;
	}
	
	@PostMapping
	public RoleResponse createRole(@RequestBody RoleRequest role) {
		return service.createRole(role);
	}

	// DISPLAY ALL users
	@GetMapping
	public List<Role> getAll() {
		return service.getAllRole();
	}
	
	@GetMapping("/{roleId}")
	public RoleResponse getRoleById(@PathVariable("roleId") int roleId) {
		return service.getRoleById(roleId);
	}
	
	
	
	@PutMapping("/{roleId}")
	public RoleResponse update(@PathVariable("roleId") int roleId, @RequestBody RoleRequest role) {
		return service.modifyRole(roleId, role);
	}

	// DELETE user by ID
	@DeleteMapping("/{roleId}")
	public String deleteRoleById(@PathVariable("roleId") int roleId) {
		return service.deleteRoleById(roleId);
	}

	// DELETE ALL user
	@DeleteMapping()
	public String deleteRole() {
		return service.deleteRole();
	}


}
