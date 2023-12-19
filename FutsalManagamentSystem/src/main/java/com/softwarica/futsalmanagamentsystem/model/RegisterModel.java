package com.softwarica.futsalmanagamentsystem.model;

public class RegisterModel {
    final public String username;
    final public String password;
    final public String name;
    final public String address;
    final public String phoneNumber;

    public RegisterModel(String username, String password, String name, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
