package com.example.demo.dto;

import java.util.List;

import com.example.demo.entities.Users;
import com.example.demo.entities.Supervisor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosteRequest {
	
	
	 private int Id_Poste;
	    
	    private String Intitule_de_poste;
	    private String Mission;
	    private String Competence_Comportementales;
	    private String Competence_technique;
	    private boolean isActive;
	    private List<Users> user;
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
	    
	    

}
