/*
 * Author Tran Ngoc Hoi
 * Xtel Company
 * 16/1/2020
 *
 */
package com.xtel.model;

public class User {
    private String name;
    private String message;
    private String userTarget;

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getUserTarget() {
        return userTarget;
    }

    public User(String name, String message, String userTarget) {
        this.name = name;
        this.message = message;
        this.userTarget = userTarget;
    }
}
