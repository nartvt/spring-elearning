package com.elearning.program.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @NotBlank(message = "Role Id chua duoc nhap")
	@Id
	private String id;
	private String name;
	private String description;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private Set<User> users;

	// @NotBlank(message = "Role name chua duoc nhap")

	// @NotBlank(message = "Role description chua duoc nhap")


	public Role() {

	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
