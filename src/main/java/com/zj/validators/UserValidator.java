package com.zj.validators;

import com.zj.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class UserValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "","Username is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Password is empty");
        if (user.getUserName().length()<5) {
            errors.rejectValue("name","", "Username length is less than 5");
        }
    }
}
