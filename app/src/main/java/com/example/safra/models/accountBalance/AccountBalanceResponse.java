package com.example.safra.models.accountBalance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountBalanceResponse
{

    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("Links")
    @Expose
    private Links links;
    private final static long serialVersionUID = 5521311869606056615L;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
