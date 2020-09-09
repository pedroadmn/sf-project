package com.example.safra.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("auth_token")
    private String authToken;

    @SerializedName("user")
    private User user;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
