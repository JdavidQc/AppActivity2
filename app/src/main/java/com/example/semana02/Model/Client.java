package com.example.semana02.Model;


import androidx.annotation.NonNull;

public class Client {

    private String Name;
    private String Gmail;
    private String Phone;
    private String Date;
    private int Category;



    public Client() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "\nName: " + getName() +
                "\nGmail:" + getGmail() +
                "\nPhone: " + getPhone() +
                "\nDate: " + getDate() +
                "\nCategory: " + getCategory();
    }
}
