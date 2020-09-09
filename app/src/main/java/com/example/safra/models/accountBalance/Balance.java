package com.example.safra.models.accountBalance;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Balance
{

    @SerializedName("AccountId")
    @Expose
    private String accountId;
    @SerializedName("Amount")
    @Expose
    private Amount amount;
    @SerializedName("CreditDebitIndicator")
    @Expose
    private String creditDebitIndicator;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("DateTime")
    @Expose
    private String dateTime;
    @SerializedName("CreditLine")
    @Expose
    private List<CreditLine> creditLine = null;
    private final static long serialVersionUID = -8609606063293368084L;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public void setCreditDebitIndicator(String creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<CreditLine> getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(List<CreditLine> creditLine) {
        this.creditLine = creditLine;
    }

}
