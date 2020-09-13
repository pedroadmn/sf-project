package com.example.safra;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AzureClient {

    private Context context;

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.AZURE_BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    private static ApiAzureService apiService;

    public AzureClient(Context context) {
        this.context = context;
    }

    public ApiAzureService getInstance() {
        if (apiService == null) {
            Retrofit retrofit = retrofitBuilder
                    //.client(okhttpClient(context))
                    .build();
            apiService = retrofit.create(ApiAzureService.class);
        }
        return apiService;
    }
}
