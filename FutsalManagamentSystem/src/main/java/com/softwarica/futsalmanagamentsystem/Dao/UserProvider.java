package com.softwarica.futsalmanagamentsystem.Dao;

import com.softwarica.futsalmanagamentsystem.Model.User;

public class UserProvider {

    private static UserProvider userProvider;
    private User user;

    private UserProvider() {
    }

    public int getUserId() {
        return 3;
//        return user.id;
    }

    public String  getName() {
        return "system";
//        return user.name;
    }

    public static UserProvider getInstance() {
        if (userProvider == null) {
            userProvider = new UserProvider();
        }
        return userProvider;
    }

    public void initializeUser(User user) {
        this.user = user;
    }

    public boolean isAdmin() {
        return false;
//        return user.isAdmin;
        // return user.isAdmin;
    }
}
