package com.example.demo.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Conge {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Conge_Id;
	private Date Date_de_debut;
	private Date Date_de_fin;
	

	
	public Conge(Date date_de_debut, Date date_de_fin, TypeConge conge, Status status, Users user) {
		super();
		this.Date_de_debut = date_de_debut;
		this.Date_de_fin = date_de_fin;
		
		this.conge = conge;
		this.status = status;
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	private TypeConge conge;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id")
	    private Users user;
	 
	 public Conge() {}

	public int getConge_Id() {
		return Conge_Id;
	}

	public void setConge_Id(int conge_Id) {
		this.Conge_Id = conge_Id;
	}

	public Date getDate_de_debut() {
		return Date_de_debut;
	}

	public void setDate_de_debut(Date date_de_debut) {
		this.Date_de_debut = date_de_debut;
	}

	public Date getDate_de_fin() {
		return Date_de_fin;
	}

	public void setDate_de_fin(Date date_de_fin) {
		this.Date_de_fin = date_de_fin;
	}

	public TypeConge getConge() {
		return conge;
	}

	public void setConge(TypeConge conge) {
		this.conge = conge;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	 
	 
	 

}
