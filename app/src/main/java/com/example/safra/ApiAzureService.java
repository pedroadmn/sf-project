package com.example.safra;

import com.example.safra.models.LoginRequest;
import com.example.safra.models.LoginResponse;
import com.example.safra.models.Product;
import com.example.safra.models.sales.SalesRequest;
import com.example.safra.models.sales.SalesResponse;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiAzureService {
    @GET(Constants.PRODUCTS)
    Observable<ArrayList<Product>> getProducts(@HeaderMap Map<String, String> headers, @Path("account") String accountId);

    @POST(Constants.SALES)
    Observable<SalesResponse> sendSales(@HeaderMap Map<String, String> headers, @Body SalesRequest salesRequest);

    @POST(Constants.LOGIN)
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);
}
