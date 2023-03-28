package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CongeRequest;
import com.example.demo.dto.CongeResponse;
import com.example.demo.dto.PosteRequest;
import com.example.demo.dto.PosteResponse;
import com.example.demo.entities.Conge;
import com.example.demo.entities.Poste;

@Component
public class CongeConverter {
	
	public CongeResponse entityToDto(Conge conge)
	{
		CongeResponse Cdto=new CongeResponse();
		
		Cdto.setConge_Id(conge.getConge_Id());
		Cdto.setDate_de_debut(conge.getDate_de_debut());
		Cdto.setDate_de_fin(conge.getDate_de_fin());
		Cdto.setConge(conge.getConge());
		Cdto.setStatus(conge.getStatus());
		
		
		Cdto.setUser(conge.getUser());	
		return Cdto;
	}
	public List<CongeResponse> entityToDto(List<Conge> conge) {

		return conge.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	
	public Conge  DtoToEntity (CongeRequest conge)
	{
		Conge Edto=new Conge();
		Edto.setConge_Id(conge.getConge_Id());
		Edto.setDate_de_debut(conge.getDate_de_debut());
		Edto.setDate_de_fin(conge.getDate_de_fin());
		Edto.setConge(conge.getConge());
		Edto.setStatus(conge.getStatus());
		
		
		Edto.setUser(conge.getUser());
		
		return Edto;
	}
	
	public Conge  DtoToEntity (Conge dto)
	{
		Conge Edto=new Conge();
		
		Edto.setConge_Id(dto.getConge_Id());
		Edto.setDate_de_debut(dto.getDate_de_debut());
		Edto.setDate_de_fin(dto.getDate_de_fin());
		Edto.setConge(dto.getConge());
		Edto.setStatus(dto.getStatus());
		
		Edto.setUser(dto.getUser());
		
		
		return Edto;
	}
	


}
