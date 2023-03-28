package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.RoleRequest;
import com.example.demo.dto.RoleResponse;
import com.example.demo.dto.UsersRequest;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entities.Role;
import com.example.demo.entities.Users;

public interface RoleService {
	RoleResponse createRole(RoleRequest entity);
	List<Role> getAllRole();
	RoleResponse getRoleById(int roleId);
	String  deleteRoleById(int roleId);
	String  deleteRole();
	RoleResponse modifyRole(int roleId, RoleRequest role);

}
