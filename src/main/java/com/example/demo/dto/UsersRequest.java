package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Conge;
import com.example.demo.entities.Poste;
import com.example.demo.entities.Role;
import com.example.demo.entities.Supervisor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequest {
	
	private int user_id;
	
	private String Nom ;

	private String Prenom;

	
	private String telephone;
	
	private String Mot_de_passe;
	
	private Date CreatedAt;
	
   private Boolean status;
	
	
	private String Numero_de_securite;
	
	private Supervisor supervisors;
	
	private Poste poste;
	
	private List<Conge> conge;
	
	
	private Role role;


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		this.Nom = nom;
	}


	public String getPrenom() {
		return Prenom;
	}


	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getMot_de_passe() {
		return Mot_de_passe;
	}


	public void setMot_de_passe(String mot_de_passe) {
		Mot_de_passe = mot_de_passe;
	}


	public Date getCreatedAt() {
		return CreatedAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.CreatedAt = createdAt;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getNumero_de_securite() {
		return Numero_de_securite;
	}


	public void setNumero_de_securite(String numero_de_securite) {
		Numero_de_securite = numero_de_securite;
	}


	public Supervisor getSupervisors() {
		return supervisors;
	}


	public void setSupervisors(Supervisor supervisors) {
		this.supervisors = supervisors;
	}


	public Poste getPoste() {
		return poste;
	}


	public void setPoste(Poste poste) {
		this.poste = poste;
	}


	public List<Conge> getConge() {
		return conge;
	}


	public void setConge(List<Conge> conge) {
		this.conge = conge;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	


}
