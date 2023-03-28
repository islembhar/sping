package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UsersRequest;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entities.Users;


@Component
public class UsersConverter {
	
	public UsersResponse entityToDto(Users user)
	{
		UsersResponse Cdto=new UsersResponse();
		Cdto.setUser_id(user.getUser_id());
		Cdto.setNom(user.getNom());
		Cdto.setPrenom(user.getPrenom());
		Cdto.setTelephone(user.getTelephone());
		Cdto.setMot_de_passe(user.getMot_de_passe());
		Cdto.setCreatedAt(user.getCreatedAt());
		
		Cdto.setConge(user.getConge());
		
		
		Cdto.setStatus(user.getStatus());
		Cdto.setNumero_de_securite(user.getNumero_de_securite());
		Cdto.setSupervisors(user.getSupervisors());
		Cdto.setPoste(user.getPoste());
		Cdto.setRole(user.getRole());
		return Cdto;
	}
	
	public List<UsersResponse> entityToDto(List<Users> user) {

		return user.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	
	public Users  DtoToEntity (UsersRequest user)
	{
		Users Edto=new Users();
		
		Edto.setNom(user.getNom());
		Edto.setPrenom(user.getPrenom());
		Edto.setTelephone(user.getTelephone());
		Edto.setMot_de_passe(user.getMot_de_passe());
		Edto.setCreatedAt(user.getCreatedAt());
		Edto.setStatus(user.getStatus());
		
		
		Edto.setConge(user.getConge());
		

		Edto.setNumero_de_securite(user.getNumero_de_securite());
		Edto.setSupervisors(user.getSupervisors());
		Edto.setPoste(user.getPoste());
		Edto.setRole(user.getRole());
		return Edto;
	}
	

	
	
	

}

