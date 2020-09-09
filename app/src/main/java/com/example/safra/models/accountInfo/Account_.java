package com.example.safra.models.accountInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account_
{

    @SerializedName("SchemeName")
    @Expose
    private String schemeName;
    @SerializedName("Identification")
    @Expose
    private String identification;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("SecondaryIdentification")
    @Expose
    private String secondaryIdentification;
    private final static long serialVersionUID = -4509284455254708089L;

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondaryIdentification() {
        return secondaryIdentification;
    }

    public void setSecondaryIdentification(String secondaryIdentification) {
        this.secondaryIdentification = secondaryIdentification;
    }

}
