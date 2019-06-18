package com.elearning.program.dto;

import javax.validation.constraints.NotBlank;

public class RoleDTO {
	private String roleId;
	 @NotBlank(message = "Role name chua duoc nhap")
	private String name;
	 @NotBlank(message = "Role description chua duoc nhap")
	private String description;

	public RoleDTO() {

	}

	public RoleDTO(String roleId, String name, String description) {
		this.roleId = roleId;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return roleId;
	}

	public void setId(String roleId) {
		this.roleId = roleId;
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
