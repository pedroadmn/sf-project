package com.example.safra;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private Context context;

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.SAFRA_BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    private static ApiSafraService apiService;

    public ApiClient(Context context) {
        this.context = context;
    }

    public ApiSafraService getInstance() {
        if (apiService == null) {
            Retrofit retrofit = retrofitBuilder
                    //.client(okhttpClient(context))
                    .build();
            apiService = retrofit.create(ApiSafraService.class);
        }
        return apiService;
    }
}
