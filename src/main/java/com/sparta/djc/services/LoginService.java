package com.sparta.djc.services;

import com.sparta.djc.components.User;

public class LoginService {


    public String validateUser(User user) {
        User attemptedAccount = (new userAccessor()).getUserDetails(user.getUserName());
        if(attemptedAccount==null){
            return "login";
        }

        if(attemptedAccount.getPassword().equals(user.getPassword())){
            user.setFirstName(attemptedAccount.getFirstName());
            user.setLastName(attemptedAccount.getLastName());
            return "welcome";
        }

        return "login";

    }
}
