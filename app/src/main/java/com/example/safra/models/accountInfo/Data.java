package com.example.safra.models.accountInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data
{

    @SerializedName("Account")
    @Expose
    private List<Account> account = null;
    private final static long serialVersionUID = -2707117969858799851L;

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

}
