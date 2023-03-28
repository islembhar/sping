package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@Getter
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String Nom;
	private String Prenom;
	private String telephone;
	private String Mot_de_passe;
	private Date CreatedAt;
	private Boolean status;
	private String Numero_de_securite;
	
	
	@ManyToOne
	@JoinColumn(name="supervisor_id")
	private Supervisor supervisors;
	
	@ManyToOne
	@JoinColumn(name = "Id_Poste")
	
	private Poste poste;
	
	
	
	@OneToMany(mappedBy="user")
	 @JsonIgnore
	private List<Conge> conge;
	
	
	
	
	@ManyToOne
	@JoinColumn(name ="RoleId", referencedColumnName = "RoleId")
	private Role role;
	
	public Users() {}

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
		this.Mot_de_passe = mot_de_passe;
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
		this.Numero_de_securite = numero_de_securite;
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
