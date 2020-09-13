
package com.example.safra.models.sales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SalesResponse implements Serializable
{
    @SerializedName("url")
    @Expose
    private String link;

    public SalesResponse(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
