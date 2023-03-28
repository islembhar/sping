package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="Poste")

public class Poste {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Poste;
    
    private String Intitule_de_poste;
    private String Mission;
    private String Competence_Comportementales;
    private String Competence_technique;
    private boolean isActive;
    
    @OneToMany(mappedBy="poste",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Users> user;
    
    @OneToMany(mappedBy="poste",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Supervisor> supervisors;

	public int getId_Poste() {
		return Id_Poste;
	}

	public void setId_Poste(int id_Poste) {
		this.Id_Poste = id_Poste;
	}

	public String getIntitule_de_poste() {
		return Intitule_de_poste;
	}

	public void setIntitule_de_poste(String intitule_de_poste) {
		this.Intitule_de_poste = intitule_de_poste;
	}

	public String getMission() {
		return Mission;
	}

	public void setMission(String mission) {
		this.Mission = mission;
	}

	public String getCompetence_Comportementales() {
		return Competence_Comportementales;
	}

	public void setCompetence_Comportementales(String competence_Comportementales) {
		this.Competence_Comportementales = competence_Comportementales;
	}

	public String getCompetence_technique() {
		return Competence_technique;
	}

	public void setCompetence_technique(String competence_technique) {
		this.Competence_technique = competence_technique;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	public List<Supervisor> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(List<Supervisor> supervisors) {
		this.supervisors = supervisors;
	}
    
    
    
    

	/*public Poste(Long id_Poste, String intitule_de_poste, String mission, String competence_Comportementales,
			String competence_technique, boolean isActive, List<Users> user, List<supervisor> supervisors) {
		super();
		this.Id_Poste = id_Poste;
		this.Intitule_de_poste = intitule_de_poste;
		this.mission = mission;
		this.Competence_Comportementales = competence_Comportementales;
		this.Competence_technique = competence_technique;
		this.isActive = isActive;
		this.user = user;
		this.supervisors = supervisors;
	}*/
	


}
