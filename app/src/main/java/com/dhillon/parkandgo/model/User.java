package com.dhillon.parkandgo.model;


public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private boolean cardnum;
    private boolean expirydate;
    private boolean securitycode;

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


    public boolean getCardnum() {
        return cardnum;
    }
    public void setCardnum(boolean cardnum) {this.cardnum = cardnum;}

    public boolean getExpirydate() {
        return expirydate;
    }
    public void setExpirydate(boolean expirydate) {this.expirydate = expirydate;}

    public boolean getSecuritycode() {
        return securitycode;
    }
    public void setSecuritycode(boolean securitycode) {this.securitycode = securitycode;}

}


