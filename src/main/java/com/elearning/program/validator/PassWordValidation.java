package com.elearning.program.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.elearning.program.entity.User;

@Component
public class PassWordValidation implements  Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;		
		
		if(StringUtils.isBlank(user.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm","user","Mat Khau chua duoc nhap, Vui Long Nhap Lai Mat Khau");
		}else if(!user.getPasswordConfirm().equals(user.getPassword())){
			errors.rejectValue("passwordConfirm","user","Mat Khau Khong Khop, Nhap Lai");
		}
	}
	
}