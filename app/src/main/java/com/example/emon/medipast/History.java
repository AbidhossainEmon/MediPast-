package com.example.emon.medipast;

public class History {
    private String name,details,appointment,image;
    private int id;


    public History(String name, String details, String date,String image) {
        this.name = name;
        this.details = details;
        this.appointment = date;
        this.image=image;

    }

    public History(String name, String details, String appointment,String image, int id) {
        this.name = name;
        this.details = details;
        this.appointment = appointment;
        this.image=image;
        this.id = id;
    }

    public String getImage() {
        return image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
