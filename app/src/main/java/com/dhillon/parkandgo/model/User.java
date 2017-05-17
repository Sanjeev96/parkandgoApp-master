package com.dhillon.parkandgo.model;


public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String cardnum;
    private String expirydate;
    private String securitycode;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getCardnum() {
        return cardnum;
    }
    public void setCardnum(String cardnum) {this.cardnum = cardnum;}

    public String getExpirydate() {
        return expirydate;
    }
    public void setExpirydate(String expirydate) {this.expirydate = expirydate;}

    public String getSecuritycode() {
        return securitycode;
    }
    public void setSecuritycode(String securitycode) {this.securitycode = securitycode;}

}


