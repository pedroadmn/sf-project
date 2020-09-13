
package com.example.safra.models.sales;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalesRequest implements Serializable
{

    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    private final static long serialVersionUID = 1503278991124851365L;

    public SalesRequest(String accountId, List<Product> products) {
        this.accountId = accountId;
        this.products = products;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
