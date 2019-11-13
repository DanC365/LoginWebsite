package com.sparta.djc.services;

import com.sparta.djc.components.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.HashSet;
import java.util.Set;


@Named
@Stateless
public class RegistrationService {
    public String registerUser(User user) {
        Set<String> userNames = new HashSet<>();
        userNames.add("DanC365");
        userNames.add("MagicMikePL");

        if(!user.getPassword().isEmpty() && !user.getLastName().isEmpty() && !user.getFirstName().isEmpty() && !user.getUserName().isEmpty()){
            if(userNames.add(user.getUserName())){
                return "welcome";
            }else{
                user.setUserName("");
            }
        }

        return "register";
    }
}
