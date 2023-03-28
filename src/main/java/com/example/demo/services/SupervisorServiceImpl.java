package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.SupervisorConverter;
import com.example.demo.dto.SupervisorRequest;
import com.example.demo.dto.SupervisorResponse;
import com.example.demo.entities.Supervisor;
import com.example.demo.entities.Supervisor;
import com.example.demo.repository.SupervisorRepository;

@Service
public class SupervisorServiceImpl implements SupervisorService {
	@Autowired
	private SupervisorRepository repos;
	private ModelMapper mapper;
	@Autowired
	private SupervisorConverter converter;
	
	
	@Autowired
	public SupervisorServiceImpl(SupervisorRepository repos, ModelMapper mapper) {
		
		super();
		this.repos = repos;
		this.mapper = mapper;
	}
	
	public SupervisorResponse createSupervisor(SupervisorRequest request) {

		Supervisor supervisor = converter.DtoToEntity(request);
		// Client entity = mapper.map(request, Client.class);

		// saving users

		supervisor = repos.save(supervisor);

		return mapper.map(converter.entityToDto(supervisor), SupervisorResponse.class);
	}
	
	
	@Override
	public List<Supervisor> getAllSupervisor() {
		System.out.println("List<Supervisor>");
		
		return repos.findAll();
	}
	@Override
	public SupervisorResponse getSupervisorById(int supervisor_id) {
		Supervisor entity;
		Optional<Supervisor> opt = repos.findById(supervisor_id);
		if (opt.isPresent())
			entity = opt.get();
		else
			// Return 404
			return null;

		return converter.entityToDto(entity);
	}
	
	
//DELETE SUP BY ID
	@Override
	public String deleteSupervisorById(int supervisor_id) {
		Supervisor entity = new Supervisor();
		this.getSupervisorById(supervisor_id);
		repos.deleteById(supervisor_id);
		return ("superviseur number " + supervisor_id + " has been deleted ..");
	}

	// DELETE ALL SUP
	@Override
	public String deleteSupervisor() {
		Supervisor entity = new Supervisor();
		this.getAllSupervisor();
		repos.deleteAll();
		;
		return ("All Superviseur has been deleted..");
	}

	@Override
	public SupervisorResponse modifySupervisor(int supervisor_id, SupervisorRequest supervisor) {

		SupervisorResponse supervisorResponse = this.getSupervisorById(supervisor_id);

		if (supervisor.getNom_de_supervisor() != null) {
			supervisorResponse.setNom_de_supervisor(supervisor.getNom_de_supervisor());
		}

		if (supervisor.getUsers() != null) {
			supervisorResponse.setUsers(supervisor.getUsers());
		}

	
		if (supervisor.getPoste() != null) {
			supervisorResponse.setPoste(supervisor.getPoste());
		}
		Supervisor superviseur2 = mapper.map(supervisorResponse, Supervisor.class);
		repos.save(superviseur2);
		return supervisorResponse;

	}

}
