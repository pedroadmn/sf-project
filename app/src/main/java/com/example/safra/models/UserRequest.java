package com.example.safra.models;

import com.google.gson.annotations.SerializedName;

public class UserRequest {
    @SerializedName("Name")
    private String name;

    @SerializedName("Email")
    private String email;

    @SerializedName("Phone")
    private String phone;

    public UserRequest(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
