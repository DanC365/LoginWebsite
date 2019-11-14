package com.sparta.djc.services;

import com.sparta.djc.components.User;

import javax.ejb.Stateless;
import javax.inject.Named;


@Named
@Stateless
public class RegistrationService {
    public String registerUser(User user) {
        if(!user.getPassword().isEmpty() && !user.getLastName().isEmpty() && !user.getFirstName().isEmpty() && !user.getUserName().isEmpty()){
            if((new userAccessor().addUserToDatabase(user))) {
                return "welcome";
            }
        }
        return "register";
    }
}
