package com.example.safra.models.accountBalance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditLine
{

    @SerializedName("Included")
    @Expose
    private Boolean included;
    @SerializedName("Amount")
    @Expose
    private Amount_ amount;
    @SerializedName("Type")
    @Expose
    private String type;
    private final static long serialVersionUID = 7483655601980717063L;

    public Boolean getIncluded() {
        return included;
    }

    public void setIncluded(Boolean included) {
        this.included = included;
    }

    public Amount_ getAmount() {
        return amount;
    }

    public void setAmount(Amount_ amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
