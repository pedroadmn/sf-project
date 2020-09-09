package com.example.safra.models.accountBalance;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data
{

    @SerializedName("Balance")
    @Expose
    private List<Balance> balance = null;
    private final static long serialVersionUID = -3526183176773009L;

    public List<Balance> getBalance() {
        return balance;
    }

    public void setBalance(List<Balance> balance) {
        this.balance = balance;
    }

}
