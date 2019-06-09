package com.elearning.program.entity;

import javax.validation.constraints.NotBlank;

public class Role {
  
  @NotBlank(message = "Role Id chua duoc nhap")
  private String id;
  
  @NotBlank(message = "Role name chua duoc nhap")
  private String name;
  
  @NotBlank(message = "Role description chua duoc nhap")
  private String description;
  
  public Role() {
    
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
