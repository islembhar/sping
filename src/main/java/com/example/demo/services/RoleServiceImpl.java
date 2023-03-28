package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.RoleConverter;
import com.example.demo.dto.RoleRequest;
import com.example.demo.dto.RoleResponse;
import com.example.demo.entities.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository repos;
	private ModelMapper mapper;
	@Autowired
	private RoleConverter converter;
	
	
	@Autowired
	public RoleServiceImpl(RoleRepository repos, ModelMapper mapper) {
		
		super();
		this.repos = repos;
		this.mapper = mapper;
	}
	
	public RoleResponse createRole(RoleRequest request) {

		Role role = converter.DtoToEntity(request);
		// Client entity = mapper.map(request, Client.class);

		// saving role

		role = repos.save(role);

		return mapper.map(converter.entityToDto(role), RoleResponse.class);
	}
	
	
	@Override
	public List<Role> getAllRole() {
		System.out.println("List<Role>");
		
		return repos.findAll();
	}
	
	
	@Override
	public RoleResponse getRoleById(int roleId) {
		Role entity;
		Optional<Role> opt = repos.findById(roleId);
		if (opt.isPresent())
			entity = opt.get();
		else
			// Return 404
			return null;

		return converter.entityToDto(entity);
	}
	
	
//DELETE CLIENT BY ID
	@Override
	public String deleteRoleById(int roleId) {
		Role entity = new Role();
		this.getRoleById(roleId);
		repos.deleteById(roleId);
		return ("Role number " + roleId + " has been deleted ..");
	}

	// DELETE ALL CLIENTs
	@Override
	public String deleteRole() {
		Role entity = new Role();
		this.getAllRole();
		repos.deleteAll();
		;
		return ("All role has been deleted..");
	}

	@Override
	public RoleResponse modifyRole(int roleId, RoleRequest role) {

		RoleResponse roleResponse = this.getRoleById(roleId);

		if (role.getName() != null) {
			roleResponse.setName(role.getName());
		}

		if (role.getDescription() != null) {
			roleResponse.setDescription(role.getDescription());
		}

		if (role.getCreateAt() != null) {
			roleResponse.setCreateAt(role.getCreateAt());
		}

		if (role.isActive() != false) {
			roleResponse.setActive(role.isActive());
		}

		if (role.getUsers() != null) {
			roleResponse.setUsers(role.getUsers());
		}


		Role role2 = mapper.map(roleResponse, Role.class);
		repos.save(role2);
		return roleResponse;

	}


	

}
