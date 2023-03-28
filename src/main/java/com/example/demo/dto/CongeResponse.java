package com.example.demo.dto;

import java.sql.Date;

import com.example.demo.entities.Status;
import com.example.demo.entities.TypeConge;
import com.example.demo.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CongeResponse {
	
	private int Conge_Id;
	private Date Date_de_debut;
	private Date Date_de_fin;

	private TypeConge conge;

	private Status status;

	private Users user;

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
