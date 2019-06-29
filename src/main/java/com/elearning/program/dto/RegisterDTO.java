package com.elearning.program.dto;

public class RegisterDTO {
  private String email;

  private String fullname;

  private String password;

  private String personType;
  private String passwordConfirm;
  
  public RegisterDTO() {
    
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getFullname() {
    return fullname;
  }
  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPersonType() {
    return personType;
  }
  public void setPersonType(String personType) {
    this.personType = personType;
  }
  public String getPasswordConfirm() {
    return passwordConfirm;
  }
  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }
}
