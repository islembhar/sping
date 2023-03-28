package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.PosteRequest;
import com.example.demo.dto.PosteResponse;
import com.example.demo.dto.UsersRequest;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entities.Poste;
import com.example.demo.entities.Users;

@Component
public class PosteConverter {
	
	public PosteResponse entityToDto(Poste poste)
	{
		PosteResponse Cdto=new PosteResponse();
		
		Cdto.setId_Poste(poste.getId_Poste());
		Cdto.setIntitule_de_poste(poste.getIntitule_de_poste());
		Cdto.setMission(poste.getMission());
		Cdto.setCompetence_Comportementales(poste.getCompetence_Comportementales());
		Cdto.setCompetence_technique(poste.getCompetence_technique());
		Cdto.setActive(poste.isActive());
		Cdto.setUser(poste.getUser());
		Cdto.setSupervisors(poste.getSupervisors());
		return Cdto;
	}
	public List<PosteResponse> entityToDto(List<Poste> poste) {

		return poste.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	
	public Poste  DtoToEntity (PosteRequest poste)
	{
		Poste Edto=new Poste();
		
		Edto.setId_Poste(poste.getId_Poste());
		Edto.setIntitule_de_poste(poste.getIntitule_de_poste());
		Edto.setMission(poste.getMission());
		Edto.setCompetence_Comportementales(poste.getCompetence_Comportementales());
		Edto.setCompetence_technique(poste.getCompetence_technique());
		Edto.setActive(poste.isActive());
		Edto.setUser(poste.getUser());
		Edto.setSupervisors(poste.getSupervisors());
		return Edto;
	}
	
	public Poste  DtoToEntity (Poste dto)
	{
		Poste Edto=new Poste();
		
		Edto.setId_Poste(dto.getId_Poste());
		Edto.setIntitule_de_poste(dto.getIntitule_de_poste());
		Edto.setMission(dto.getMission());
		Edto.setCompetence_Comportementales(dto.getCompetence_Comportementales());
		Edto.setCompetence_technique(dto.getCompetence_technique());
		Edto.setActive(dto.isActive());
		Edto.setUser(dto.getUser());
		Edto.setSupervisors(dto.getSupervisors());
		
		return Edto;
	}

}
