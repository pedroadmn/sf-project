package com.example.safra.models;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("accountBalance")
    private double balance = 0;

    @SerializedName("accountNumber")
    private int number = 0;

    @SerializedName("accountAgency")
    private int agency = 0;

    @SerializedName("accountBankNumber")
    private int bankNumber = 0;

    public Account(double balance, int number, int agency, int bankNumber) {
        this.balance = balance;
        this.number = number;
        this.agency = agency;
        this.bankNumber = bankNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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
