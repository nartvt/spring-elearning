package com.elearning.program.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "roles")
public class Role {

  /**
   *
   */
  // @NotBlank(message = "Role Id chua duoc nhap")
  @Id
  private String roleId;
  private String name;
  private String description;

  @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
  private Set<User> users;

  // @NotBlank(message = "Role name chua duoc nhap")

  // @NotBlank(message = "Role description chua duoc nhap")

  public Role() {

  }

  public Role(String roleId, String name, String description) {
    this.roleId = roleId;
    this.name = name;
    this.description = description;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public String getRoleId() {
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
