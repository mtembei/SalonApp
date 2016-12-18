package com.patrickmukiira.salonapp;

/**
 * Created by mutembei on 10/25/2016.
 */

public class Categories {
    private String name, phone_number, hair, massage, others, time;

    public Categories(String name, String phone_number, String hair, String massage, String others, String time) {
        this.setName(name);
        this.setPhone_number(phone_number);
        this.setHair(hair);
        this.setMassage(massage);
        this.setOthers(others);
        this.setTime(time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}