package com.example.safra.models;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("accountBalance")
    private double balance = 0;

    @SerializedName("accountNumber")
    private String number;

    @SerializedName("accountAgency")
    private int agency = 0;

    @SerializedName("accountBankNumber")
    private int bankNumber = 0;

    @SerializedName("accountLimit")
    private double limit = 250;

    public Account(double balance, String number, int agency, int bankNumber, double limit) {
        this.balance = balance;
        this.number = number;
        this.agency = agency;
        this.bankNumber = bankNumber;
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }
}
