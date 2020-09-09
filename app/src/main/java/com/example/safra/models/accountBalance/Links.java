package com.example.safra.models.accountBalance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links
{

    @SerializedName("Self")
    @Expose
    private String self;
    private final static long serialVersionUID = -7093269641990698452L;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

}
