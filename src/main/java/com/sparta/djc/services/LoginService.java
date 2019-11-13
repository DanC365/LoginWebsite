package com.sparta.djc.services;

import com.sparta.djc.components.User;

public class LoginService {


    public String validateUser(User user) {
        if(user.getUserName().equals("DanC365") && user.getPassword().equals("Password123")){
            user.setFirstName("Daniel");
            user.setLastName("Curtis");
            return "welcome";
        }else if(user.getUserName().equals("MagicMikePL") && user.getPassword().equals("Poland123")){
            user.setFirstName("Michal");
            user.setLastName("Nowak");
            return "welcome";
        }
        user.setPassword("");
        return "login";
    }
}
