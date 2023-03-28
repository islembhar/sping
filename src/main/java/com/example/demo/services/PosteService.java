package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.PosteRequest;
import com.example.demo.dto.PosteResponse;

import com.example.demo.entities.Poste;

public interface PosteService {
	
	PosteResponse createPoste(PosteRequest entity);
	List<Poste> getAllPoste();
	PosteResponse getPosteById(int Id_Poste);
	String  deletePosteById(int Id_Poste);
	String  deletePoste();
	PosteResponse modifyPoste(int Id_Poste, PosteRequest poste);

}
