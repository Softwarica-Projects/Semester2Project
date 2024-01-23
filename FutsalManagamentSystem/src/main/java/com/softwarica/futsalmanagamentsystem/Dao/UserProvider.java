package com.softwarica.futsalmanagamentsystem.Dao;

import com.softwarica.futsalmanagamentsystem.Model.User;

public class UserProvider {

    private static UserProvider userProvider;
    private User user;

    private UserProvider() {
    }

    public int getUserId() {
        return user.id;
    }

    public String  getName() {
        return user.name;
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
        return user.isAdmin;
    }
}
