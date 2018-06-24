package com.zj.controller;

import com.zj.entity.User;
import com.zj.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController extends BaseController{
    @Autowired
    private UserValidator userValidator;
    @RequestMapping("/login")
    public String login(){
        logger.info("进入登录方法");
        return "login";
    }
    @RequestMapping(value="save", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
        logger.info("save方法");
        if(result.hasErrors()) {
            return "user";
        }
        System.out.println("Name:"+ user.getUserName());
        model.addAttribute("msg", "Welcome to My World!");
        return "success";
    }
}
