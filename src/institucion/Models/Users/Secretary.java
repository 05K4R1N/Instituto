/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.Users;

import java.util.Date;


/**
 *
 * @author OscarT
 */
public class Secretary {
    private String firstName;
    private String lastName;
    private String address;
    private Date birthday;
    private int code;
    private String place_birth;
    private String photo;
    private String username;
    private String pass;
    private String sex;
    private int ci;

    public Secretary(String firstName, String lastName, String address, Date birthday, int code, String place_birth, String photo, String username, String pass, String sex, int ci) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.code = code;
        this.place_birth = place_birth;
        this.photo = photo;
        this.username = username;
        this.pass = pass;
        this.sex = sex;
        this.ci = ci;
    }
    
    public Secretary(){}
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPlace_birth() {
        return place_birth;
    }

    public void setPlace_birth(String place_birth) {
        this.place_birth = place_birth;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
