package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.CongeConverter;
import com.example.demo.dto.CongeRequest;
import com.example.demo.dto.CongeResponse;

import com.example.demo.entities.Conge;
import com.example.demo.repository.CongeRepository;

@Service
public class CongeServiceImpl implements CongeService {
	
	@Autowired
	private CongeRepository repos;
	private ModelMapper mapper;
	@Autowired
	private CongeConverter converter;
	
	public CongeServiceImpl(CongeRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}
	public CongeResponse createConge(CongeRequest request) {

		Conge conge = converter.DtoToEntity(request);
		

		conge = repos.save(conge);

		return mapper.map(converter.entityToDto(conge), CongeResponse.class);
	}
	
	@Override
	public List<Conge> getAllConge() {
		
		return repos.findAll();
	}
	
	
	@Override
	public CongeResponse getCongeById(int Conge_Id) {
		Conge entity;
		Optional<Conge> opt = repos.findById(Conge_Id);
		if (opt.isPresent())
			entity = opt.get();
		else
			// Return 404
			return null;

		return converter.entityToDto(entity);
	}
	
	
//DELETE CLIENT BY ID
	@Override
	public String deleteCongeById(int Conge_Id) {
		Conge entity = new Conge();
		this.getCongeById(Conge_Id);
		repos.deleteById(Conge_Id);
		return ("Conge number " + Conge_Id + " has been deleted ..");
	}

	// DELETE ALL CLIENTs
	@Override
	public String deleteConge() {
		Conge entity = new Conge();
		this.getAllConge();
		repos.deleteAll();
		;
		return ("All Conge has been deleted..");
	}

	@Override
	public CongeResponse modifyConge(int Conge_Id, CongeRequest conge) {

		CongeResponse congeResponse = this.getCongeById(Conge_Id);

		if (conge.getConge_Id() != 0) {
			congeResponse.setConge_Id(conge.getConge_Id());
		}

		if (conge.getDate_de_debut() != null) {
			congeResponse.setDate_de_debut(conge.getDate_de_debut());
		}

		if (conge.getDate_de_fin() != null) {
			congeResponse.setDate_de_fin(conge.getDate_de_fin());
		}

		if (conge.getConge() != null) {
			congeResponse.setConge(conge.getConge());
		}

		if (conge.getStatus() != null) {
			congeResponse.setStatus(conge.getStatus());
		}
		

		if (conge.getUser() != null) {
			congeResponse.setUser(conge.getUser());
		}

		
		
		

		Conge conge2 = mapper.map(congeResponse, Conge.class);
		repos.save(conge2);
		return congeResponse;

	}

	

	
	


}
