package com.example.emon.medipast;

public class person {
            private int  id;

            private String name;
            private String details;

           private String appointment;
           private String phoneNumber;
           private String email;

    public person(int id, String name, String details, String appointment, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.appointment = appointment;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public person(String name, String details, String appointment, String phoneNumber, String email) {
        this.name = name;
        this.details = details;
        this.appointment = appointment;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
