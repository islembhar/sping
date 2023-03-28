package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Supervisor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supervisor_id;
	private String  Nom_de_supervisor;
	
	
	  @OneToMany(mappedBy = "supervisors", cascade = CascadeType.ALL)
	  @JsonIgnore
	    private List<Users> users;
	  
		@ManyToOne
		private Poste poste;
		
		
		
		
		

		public Supervisor(String nom_de_supervisor, List<Users> users, Poste poste) {
			super();
			this.Nom_de_supervisor = nom_de_supervisor;
			this.users = users;
			this.poste = poste;
		}
		
		public Supervisor() {}
		
		

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
