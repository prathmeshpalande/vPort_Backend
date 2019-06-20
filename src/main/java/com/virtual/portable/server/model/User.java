package com.virtual.portable.server.model;

public class User {

    private Credentials credentials;
    private String sessionKey;

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public User(Credentials credentials, String sessionKey) {
        this.credentials = credentials;
        this.sessionKey = sessionKey;
    }
}
