/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.Users;

import java.util.Date;

/**
 *
 * @author master
 */
public class Teacher {
    private String first_name;
    private String last_name;
    private String address;
    private Date birthday;
    private String place_birth;
	private String photo;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
    
}
