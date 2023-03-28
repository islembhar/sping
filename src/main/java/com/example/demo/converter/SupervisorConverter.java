package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.RoleRequest;
import com.example.demo.dto.RoleResponse;
import com.example.demo.dto.SupervisorRequest;
import com.example.demo.dto.SupervisorResponse;
import com.example.demo.entities.Role;
import com.example.demo.entities.Supervisor;

@Component
public class SupervisorConverter {
	public SupervisorResponse entityToDto(Supervisor supervisor)
	{
		SupervisorResponse Cdto=new SupervisorResponse();
		
		Cdto.setNom_de_supervisor(supervisor.getNom_de_supervisor());
		
		
		Cdto.setUsers(supervisor.getUsers());
		Cdto.setPoste(supervisor.getPoste());
		
		return Cdto;
	}
	public List<SupervisorResponse> entityToDto(List<Supervisor> supervisor) {

		return supervisor.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	
	public Supervisor  DtoToEntity (SupervisorRequest supervisor)
	{
		Supervisor Edto=new Supervisor();
		
		

		Edto.setNom_de_supervisor(supervisor.getNom_de_supervisor());

		Edto.setUsers(supervisor.getUsers());
		Edto.setPoste(supervisor.getPoste());
		return Edto;
	}
	



}
