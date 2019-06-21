package com.elearning.program.validator;

import com.elearning.program.dto.UserDTO;
import com.elearning.program.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PassWordValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;

        if (StringUtils.isBlank(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "user", "Mat Khau chua duoc nhap, Vui Long Nhap Lai Mat Khau");
        } else if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "user", "Mat Khau Khong Khop, Nhap Lai");
        }
    }

}