package com.example.safra.models;

import com.google.gson.annotations.SerializedName;

public class HealthResponse {
    @SerializedName("message")
    private int message;

    @SerializedName("code")
    private String code;

    public HealthResponse(int message, String code) {
        this.message = message;
        this.code = code;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
