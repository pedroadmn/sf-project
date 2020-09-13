package com.example.safra;

import com.example.safra.models.Product;
import com.example.safra.models.accountInfo.AccountInfoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;

import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiAzureService {
    @GET(Constants.PRODUCTS)
    Observable<ArrayList<Product>> getProducts(@HeaderMap Map<String, String> headers, @Query("showInactives") boolean showInactives);
}
