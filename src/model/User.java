package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    private String user;
    private String password;
    private int numberPhone;
    private String address;
    private String nameUser;
    private String emailUser;
    private int ageUse;


    public User(String user, String password, int numberPhone, String address, String nameUser, String emailUser, int ageUse) {
        this.user = user;
        this.password = password;
        this.numberPhone = numberPhone;
        this.address = address;
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.ageUse = ageUse;
    }
    public User(String user,String password,String emailUser,String nameUser){
        this.user = user;
        this.emailUser = emailUser;
        this.nameUser = nameUser;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public int getAgeUse() {
        return ageUse;
    }

    public void setAgeUse(int ageUse) {
        this.ageUse = ageUse;
    }

    @Override
    public String toString() {
        return "model.User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", numberPhone=" + numberPhone +
                ", address='" + address + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", ageUse=" + ageUse +
                '}';
    }
}
