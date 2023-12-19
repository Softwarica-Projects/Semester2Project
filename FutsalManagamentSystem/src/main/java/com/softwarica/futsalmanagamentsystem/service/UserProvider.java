package com.softwarica.futsalmanagamentsystem.service;

import com.softwarica.futsalmanagamentsystem.model.User;

public class UserProvider {
    private static UserProvider userProvider;
    public User user;

    private UserProvider() {
    }

    public static UserProvider getInstance() {
        if (userProvider == null) {
            userProvider = new UserProvider();
        }
        return userProvider;
    }



    public boolean isAdmin(){
        return false;
        // return user.isAdmin;
    }
}
