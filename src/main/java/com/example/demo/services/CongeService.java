package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.CongeRequest;
import com.example.demo.dto.CongeResponse;
import com.example.demo.entities.Conge;



public interface CongeService {
	CongeResponse createConge(CongeRequest entity);
	List<Conge> getAllConge();
	CongeResponse getCongeById(int Conge_Id);
	String  deleteCongeById(int Conge_Id);
	String  deleteConge();
	CongeResponse modifyConge(int Conge_Id, CongeRequest conge);

}
