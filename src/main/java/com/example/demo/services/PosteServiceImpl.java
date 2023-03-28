package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.PosteConverter;
import com.example.demo.dto.PosteRequest;
import com.example.demo.dto.PosteResponse;

import com.example.demo.entities.Poste;
import com.example.demo.repository.PostRepository;

@Service
public class PosteServiceImpl implements PosteService{
	

	@Autowired
	private PostRepository repos;
	private ModelMapper mapper;
	@Autowired
	private PosteConverter converter;
	
	public PosteServiceImpl(PostRepository repos, ModelMapper mapper) {
		super();
		this.repos = repos;
		this.mapper = mapper;
	}
	public PosteResponse createPoste(PosteRequest request) {

		Poste poste = converter.DtoToEntity(request);
		

		poste = repos.save(poste);

		return mapper.map(converter.entityToDto(poste), PosteResponse.class);
	}
	
	@Override
	public List<Poste> getAllPoste() {
		
		return repos.findAll();
	}
	
	
	@Override
	public PosteResponse getPosteById(int user_id) {
		Poste entity;
		Optional<Poste> opt = repos.findById(user_id);
		if (opt.isPresent())
			entity = opt.get();
		else
			// Return 404
			return null;

		return converter.entityToDto(entity);
	}
	
	
//DELETE CLIENT BY ID
	@Override
	public String deletePosteById(int Id_Poste) {
		Poste entity = new Poste();
		this.getPosteById(Id_Poste);
		repos.deleteById(Id_Poste);
		return ("User number " + Id_Poste + " has been deleted ..");
	}

	// DELETE ALL CLIENTs
	@Override
	public String deletePoste() {
		Poste entity = new Poste();
		this.getAllPoste();
		repos.deleteAll();
		;
		return ("All Postes has been deleted..");
	}

	@Override
	public PosteResponse modifyPoste(int Id_Poste, PosteRequest poste) {

		PosteResponse posteResponse = this.getPosteById(Id_Poste);

		if (poste.getId_Poste() != 0) {
			posteResponse.setId_Poste(poste.getId_Poste());
		}

		if (poste.getIntitule_de_poste() != null) {
			posteResponse.setIntitule_de_poste(poste.getIntitule_de_poste());
		}

		if (poste.getMission() != null) {
			posteResponse.setMission(poste.getMission());
		}

		if (poste.getCompetence_Comportementales() != null) {
			posteResponse.setCompetence_Comportementales(poste.getCompetence_Comportementales());
		}

		if (poste.getCompetence_technique() != null) {
			posteResponse.setCompetence_technique(poste.getCompetence_technique());
		}
		

		if (poste.isActive() != false) {
			posteResponse.setActive(poste.isActive());
		}

		if (poste.getUser() != null) {
			posteResponse.setUser(poste.getUser());
		}
		
		if (poste.getSupervisors() != null) {
			posteResponse.setSupervisors(poste.getSupervisors());
		}

		
		

		Poste poste2 = mapper.map(posteResponse, Poste.class);
		repos.save(poste2);
		return posteResponse;

	}

	

	
	

}
