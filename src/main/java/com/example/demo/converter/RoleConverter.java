package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.PosteRequest;
import com.example.demo.dto.PosteResponse;
import com.example.demo.dto.RoleRequest;
import com.example.demo.dto.RoleResponse;
import com.example.demo.entities.Poste;
import com.example.demo.entities.Role;

@Component
public class RoleConverter {
	
	public RoleResponse entityToDto(Role role)
	{
		RoleResponse Cdto=new RoleResponse();
		
		Cdto.setName(role.getName());
		Cdto.setDescription(role.getDescription());
		Cdto.setCreateAt(role.getCreateAt());
		Cdto.setActive(role.isActive());
		Cdto.setUsers(role.getUsers());
		
		return Cdto;
	}
	public List<RoleResponse> entityToDto(List<Role> role) {

		return role.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	
	public Role  DtoToEntity (RoleRequest role)
	{
		Role Edto=new Role();
		
		Edto.setName(role.getName());
		Edto.setDescription(role.getDescription());
		Edto.setCreateAt(role.getCreateAt());
		Edto.setActive(role.isActive());
		Edto.setUsers(role.getUsers());
		return Edto;
	}
	
	
	public Role  DtoToEntity (Role dto)
	{
             Role Edto=new Role();
		
		Edto.setName(dto.getName());
		Edto.setDescription(dto.getDescription());
		Edto.setCreateAt(dto.getCreateAt());
		Edto.setActive(dto.isActive());
		Edto.setUsers(dto.getUsers());
		return Edto;
	}
	


}
