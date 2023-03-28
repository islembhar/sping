package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CongeRequest;
import com.example.demo.dto.CongeResponse;
import com.example.demo.dto.SupervisorResponse;
import com.example.demo.entities.Conge;
import com.example.demo.services.CongeService;

@RestController
@RequestMapping("/api/conge")
public class CongeController {
	
	
private CongeService service;
	
	
	@Autowired
	public CongeController(CongeService service) {
		
		super();
		this.service = service;
	}
	
	@PostMapping
	public CongeResponse createPoste(@RequestBody CongeRequest conge) {
		return service.createConge(conge);
	}

	// DISPLAY ALL users
	@GetMapping
	public List<Conge> getAll() {
		return service.getAllConge();
	}
	
	@GetMapping("/{Conge_Id}")
	public CongeResponse getCongeById(@PathVariable("Conge_Id") int Conge_Id) {
		return service.getCongeById(Conge_Id);
	}
	
	
	@PutMapping("/{Conge_Id}")
	public CongeResponse update(@PathVariable("Conge_Id") int Conge_Id, @RequestBody CongeRequest conge) {
		return service.modifyConge(Conge_Id, conge);
	}

	// DELETE user by ID
	@DeleteMapping("/{Conge_Id}")
	public String deleteCongeById(@PathVariable("Conge_Id") int Conge_Id) {
		return service.deleteCongeById(Conge_Id);
	}

	// DELETE ALL user
	@DeleteMapping()
	public String deleteConge() {
		return service.deleteConge();
	}



}
