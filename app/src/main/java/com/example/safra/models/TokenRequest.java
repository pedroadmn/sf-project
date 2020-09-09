package com.example.safra.models;

import com.google.gson.annotations.SerializedName;

public class TokenRequest {
    final String grant_type;

    final String scope;

    public TokenRequest(String grantType, String scope) {
        this.grant_type = grantType;
        this.scope = scope;
    }
}
