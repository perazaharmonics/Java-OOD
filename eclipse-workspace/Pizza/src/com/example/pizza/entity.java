package com.example.pizza;

import java.util.ArrayList;

public class entity {
    // Class Attributes
    private String Name;
    private String Address;
    private String Phone;
    private String Email;
    private int JobID;

    // Class default constructor
    public entity() {
        Name = "";
        Address = "";
        Phone = "";
        Email = "";
    }

    // Class overloaded constructor
    public entity(String name, String address, String phone, String email, int jobID) {
        Name = name;
        Address = address;
        Phone = phone;
        Email = email;
        JobID = jobID;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setID(int jobID) {
        if (jobID == 0) {
            JobID = 0;
            Name = "";
            Address = "";
            Phone = "";
            Email = "";
        } else if (jobID > 0 && jobID < 9) {
            JobID = jobID;
            Phone = "";
            Email = "";
        } else {
            System.out.print("\n Person not part of the entity. ");
        }
    }

    public int getID() {
        return JobID;
    }

    // Class copy constructor
    public entity(entity e) {
        Name = e.Name;
        Address = e.Address;
        Phone = e.Phone;
        Email = e.Email;
        JobID = e.JobID;
    }
}
