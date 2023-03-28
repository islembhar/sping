package com.example.demo.dto;

import java.sql.Date;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.entities.Users;

public class RoleRequest {
	private int RoleId;
	
	private String Name;
	private String Description;
	private Date CreateAt;
	private boolean isActive;
	
	    private Set<Users> users ;
	
		public int getRoleId() {
			return RoleId;
		}

		public void setRoleId(int roleId) {
			RoleId = roleId;
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
