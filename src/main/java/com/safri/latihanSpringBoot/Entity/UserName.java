package com.safri.latihanSpringBoot.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserName {

    @Size(min = 3, max = 50, message = "name between 3 - 50 character")
    private String Name;
    private String Address;

    @Email(message = "Invalid Email!")
    private String Email;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
