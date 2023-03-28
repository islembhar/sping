package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.example.demo.converter.UsersConverter;


import com.example.demo.dto.UsersRequest;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entities.Users;
import com.example.demo.repository.UserRepository;


@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UserRepository repos;
	private ModelMapper mapper;
	@Autowired
	private UsersConverter converter;
	
	
	@Autowired
	public UsersServiceImpl(UserRepository repos, ModelMapper mapper) {
		
		super();
		this.repos = repos;
		this.mapper = mapper;
	}
	
	public UsersResponse createUsers(UsersRequest request) {

		Users user = converter.DtoToEntity(request);
		// Client entity = mapper.map(request, Client.class);

		// saving users

		user = repos.save(user);

		return mapper.map(converter.entityToDto(user), UsersResponse.class);
	}
	
	
	@Override
	public List<Users> getAllUsers() {
		System.out.println("List<Users>");
		
		return repos.findAll();
	}
	
	
	@Override
	public UsersResponse getUserById(int user_id) {
		Users entity;
		Optional<Users> opt = repos.findById(user_id);
		if (opt.isPresent())
			entity = opt.get();
		else
			// Return 404
			return null;

		return converter.entityToDto(entity);
	}
	
	
//DELETE CLIENT BY ID
	@Override
	public String deleteUserById(int user_id) {
		Users entity = new Users();
		this.getUserById(user_id);
		repos.deleteById(user_id);
		return ("User number " + user_id + " has been deleted ..");
	}

	// DELETE ALL CLIENTs
	@Override
	public String deleteUsers() {
		Users entity = new Users();
		this.getAllUsers();
		repos.deleteAll();
		;
		return ("All Users has been deleted..");
	}

	@Override
	public UsersResponse modifyUser(int user_id, UsersRequest user) {

		UsersResponse userResponse = this.getUserById(user_id);

		if (user.getNom() != null) {
			userResponse.setNom(user.getNom());
		}

		if (user.getPrenom() != null) {
			userResponse.setPrenom(user.getPrenom());
		}

		if (user.getTelephone() != null) {
			userResponse.setTelephone(user.getTelephone());
		}

		if (user.getMot_de_passe() != null) {
			userResponse.setMot_de_passe(user.getMot_de_passe());
		}

		if (user.getCreatedAt() != null) {
			userResponse.setCreatedAt(user.getCreatedAt());
		}
		if (user.getStatus() != null) {
			userResponse.setStatus(user.getStatus());
		}

		if (user.getNumero_de_securite() != null) {
			userResponse.setNumero_de_securite(user.getNumero_de_securite());
		}

		if (user.getSupervisors() != null) {
			userResponse.setSupervisors(user.getSupervisors());
		}
		
		if (user.getPoste() != null) {
			userResponse.setPoste(user.getPoste());
		}

		if (user.getConge() != null) {
			userResponse.setConge(user.getConge());
		}

		if (user.getRole() != null) {
			userResponse.setRole(user.getRole());
		}
		

		Users user2 = mapper.map(userResponse, Users.class);
		repos.save(user2);
		return userResponse;

	}


}
	
