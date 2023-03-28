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

import com.example.demo.dto.SupervisorRequest;
import com.example.demo.dto.SupervisorResponse;

import com.example.demo.entities.Supervisor;
import com.example.demo.services.SupervisorService;

@RestController
@RequestMapping("/api/supervisor")
public class SupervisorController {
	

	private SupervisorService service;
	
	@Autowired
	public SupervisorController(SupervisorService service) {
		
		super();
		this.service = service;
	}
	
	
	@PostMapping
	public SupervisorResponse createSupervisor(@RequestBody SupervisorRequest supervisor) {
		return service.createSupervisor(supervisor);
	}

	// DISPLAY ALL users
	@GetMapping
	public List<Supervisor> getAll() {
		return service.getAllSupervisor();
	}
	@GetMapping("/{supervisor_id}")
	public SupervisorResponse getSupervisorById(@PathVariable("supervisor_id") int supervisor_id) {
		return service.getSupervisorById(supervisor_id);
	}
	
	// Update user ???????
		@PutMapping("/{supervisor_id}")
		public SupervisorResponse update(@PathVariable("supervisor_id") int supervisor_id, @RequestBody SupervisorRequest supervisor) {
			return service.modifySupervisor(supervisor_id, supervisor);
		}

		// DELETE user by ID
		@DeleteMapping("/{supervisor_id}")
		public String deleteUserById(@PathVariable("supervisor_id") int supervisor_id) {
			return service.deleteSupervisorById(supervisor_id);
		}

		// DELETE ALL user
		@DeleteMapping()
		public String deleteSupervisor() {
			return service.deleteSupervisor();
		}


}
