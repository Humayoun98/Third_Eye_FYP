package com.example.thirdeye;

public class userData {
    private String userName;
    private String email;
    private String number;
    private String gender;
    private String password;

    public userData() {
    }

    public userData(String userName, String email, String number, String gender, String password) {
        this.userName = userName;
        this.email = email;
        this.number = number;
        this.gender = gender;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
