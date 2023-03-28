package com.example.demo.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Role {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RoleId;
	private String Name;
	private String Description;
	private Date CreateAt;
	private boolean isActive;
	
	 @OneToMany(mappedBy = "role")
	 @JsonIgnore
	    private Set<Users> users ;
	 
	 

	public Role(String name, String description, Date createAt, boolean isActive, Set<Users> users) {
		super();
		this.Name = name;
		this.Description = description;
		this.CreateAt = createAt;
		this.isActive = isActive;
		this.users = users;
	}
	
	public Role() {}

	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int roleId) {
		this.RoleId = roleId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public Date getCreateAt() {
		return CreateAt;
	}

	public void setCreateAt(Date createAt) {
		this.CreateAt = createAt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	 
	 
	 

}
