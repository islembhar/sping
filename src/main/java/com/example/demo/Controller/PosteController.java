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

import com.example.demo.dto.PosteRequest;
import com.example.demo.dto.PosteResponse;
import com.example.demo.dto.UsersRequest;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entities.Poste;
import com.example.demo.services.PosteService;

@RestController
@RequestMapping("/api/poste")
public class PosteController {
	
	private PosteService service;
	
	
	@Autowired
	public PosteController(PosteService service) {
		
		super();
		this.service = service;
	}
	
	@PostMapping
	public PosteResponse createPoste(@RequestBody PosteRequest poste) {
		return service.createPoste(poste);
	}

	// DISPLAY ALL users
	@GetMapping
	public List<Poste> getAll() {
		return service.getAllPoste();
	}
	
	@PutMapping("/{Id_Poste}")
	public PosteResponse update(@PathVariable("Id_Poste") int Id_Poste, @RequestBody PosteRequest poste) {
		return service.modifyPoste(Id_Poste, poste);
	}

	// DELETE user by ID
	@DeleteMapping("/{Id_Poste}")
	public String deleteUserById(@PathVariable("Id_Poste") int Id_Poste) {
		return service.deletePosteById(Id_Poste);
	}

	// DELETE ALL user
	@DeleteMapping()
	public String deleteUsers() {
		return service.deletePoste();
	}


}
