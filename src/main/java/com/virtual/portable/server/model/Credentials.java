package com.virtual.portable.server.model;

public class Credentials {
    String userName;
    String password;

    public String getUserName() {
        return userName;
    }

    public Credentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
