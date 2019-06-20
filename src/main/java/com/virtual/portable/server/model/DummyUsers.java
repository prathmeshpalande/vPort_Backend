package com.virtual.portable.server.model;

import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;

public class DummyUsers implements InitializingBean {
    HashMap<String, User> users;

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        users = new HashMap<>();
        User user1 = new User(new Credentials("user1", "123"), null);
        User user2 = new User(new Credentials("user2", "456"), null);
        User user3 = new User(new Credentials("user3", "789"), null);
        User user4 = new User(new Credentials("user4", "123"), null);
        users.put("user1", user1);
        users.put("user2", user2);
        users.put("user3", user3);
        users.put("user4", user4);
    }
}
