package com.example.safra.models;

import com.google.gson.annotations.SerializedName;

public class Bank {
    @SerializedName("name")
    private String name;

    @SerializedName("code")
    private String code;

    public Bank(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
