package com.example.safra.models;

import com.google.gson.annotations.SerializedName;

public class TokenResponse {
    @SerializedName("access_token")
    private String access_token;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private String expiresIn;

    public TokenResponse(String access_token, String tokenType, String expiresIn) {
        this.access_token = access_token;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
}
