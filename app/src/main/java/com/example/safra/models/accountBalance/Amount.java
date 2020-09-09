package com.example.safra.models.accountBalance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount
{

    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("Currency")
    @Expose
    private String currency;
    private final static long serialVersionUID = 2386296619745682019L;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
