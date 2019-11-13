package com.sparta.djc.beans;

import com.sparta.djc.components.User;
import com.sparta.djc.services.LoginService;
import com.sparta.djc.services.RegistrationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class userBean {
    @Inject
    private RegistrationService registrationService;
    @Inject
    private LoginService loginService;
    private User user = new User();


    public User getUser() {
        return user;
    }

    public String registerNewUser(){
        return registrationService.registerUser(user);
    }

    public String validateUser(){
        return loginService.validateUser(user);
    }

}
