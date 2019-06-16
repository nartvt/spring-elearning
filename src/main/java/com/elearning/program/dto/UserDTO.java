package com.elearning.program.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class UserDTO {

	private String id;

	 @NotBlank(message = "Email chua duoc nhap")
	 @Email(message = "Email khong dung dinh dang")
	private String email;

	 @NotBlank(message = "Ho Ten chua duoc nhap")
	private String fullname;

	 @NotBlank(message = "Mat khau chua duoc nhap")
	 @Length(min = 6, max = 16, message = "Mat khau it nhat 6 ki tu va toi da 16 ki tu")
	private String password;

	private String personType;
	private String avatar;
	private String phone;
	private String address;
	private String website;
	private String facebook;
	private String passwordConfirm;
	
	private String roleId;
 
	public UserDTO() {
	}

	public UserDTO(String id, String email, String fullname, String password, String avatar, String phone, String address,
			String personType, String website, String facebook, String roleId) {
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.personType = personType;
		this.avatar = avatar;
		this.phone = phone;
		this.address = address;
		this.website = website;
		this.facebook = facebook;
		this.roleId = roleId;
	}

 
	public String getId() {
		return id;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
