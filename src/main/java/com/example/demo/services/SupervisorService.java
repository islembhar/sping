package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.SupervisorRequest;
import com.example.demo.dto.SupervisorResponse;

import com.example.demo.entities.Supervisor;

public interface SupervisorService {
	SupervisorResponse createSupervisor(SupervisorRequest  entity);
	List<Supervisor> getAllSupervisor();
	SupervisorResponse getSupervisorById(int supervisor_id);
	String  deleteSupervisorById(int supervisor_id);
	String  deleteSupervisor();
	SupervisorResponse modifySupervisor(int supervisor_id, SupervisorRequest supervisor);

}
