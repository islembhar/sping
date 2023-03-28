package com.example.demo.dto;

import java.util.List;

import com.example.demo.entities.Poste;
import com.example.demo.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorRequest {
	
	private int supervisor_id;
	private String  Nom_de_supervisor; 
	 private List<Users> users;
	private Poste poste;
	
	

	public int getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public String getNom_de_supervisor() {
		return Nom_de_supervisor;
	}

	public void setNom_de_supervisor(String nom_de_supervisor) {
		this.Nom_de_supervisor = nom_de_supervisor;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}
		

}
