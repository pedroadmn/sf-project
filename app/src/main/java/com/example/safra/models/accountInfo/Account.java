package com.example.safra.models.accountInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account
{

    @SerializedName("AccountId")
    @Expose
    private String accountId;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("Nickname")
    @Expose
    private String nickname;
    @SerializedName("Account")
    @Expose
    private Account_ account;
    private final static long serialVersionUID = -4823866239279993276L;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Account_ getAccount() {
        return account;
    }

    public void setAccount(Account_ account) {
        this.account = account;
    }

}
