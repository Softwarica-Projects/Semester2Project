package com.softwarica.futsalmanagamentsystem.Dao;

import com.softwarica.futsalmanagamentsystem.Model.User;

public class UserProvider {
    private static UserProvider userProvider;
    private User user;

    private UserProvider() {
    }

    public int getUserId(){
        return user.id;
    }
    public static UserProvider getInstance() {
        if (userProvider == null) {
            userProvider = new UserProvider();
        }
        return userProvider;
    }

    public void initializeUser(User user)
    {
        this.user=user;
    }


    public boolean isAdmin(){
        return user.isAdmin;
        // return user.isAdmin;
    }
}
