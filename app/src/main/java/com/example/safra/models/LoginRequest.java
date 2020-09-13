package com.example.safra.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("password")
    @Expose
    private String password;

    public LoginRequest(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
