package com.fenchtose.footerloaderadapterdemo;

/**
 * Created by elanicdroid on 28/10/15.
 */
public class User {

    private long id;
    private String username;

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
