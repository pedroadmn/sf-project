package com.example.safra.models;

import android.content.Context;

import com.example.safra.AuthService;
import com.example.safra.AuthenticationInterceptor;
import com.example.safra.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class OauthClient {

    private Context context;

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_AUTH_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    private static AuthService apiService;

    public OauthClient(Context context) {
        this.context = context;
    }

    public AuthService getInstance() {
        if (apiService == null) {
            Retrofit retrofit = retrofitBuilder
                    //.client(okhttpClient(context))
                    .build();
            apiService = retrofit.create(AuthService.class);
        }
        return apiService;
    }

    /**
     * Initialize OkhttpClient with our interceptor
     */
    public OkHttpClient okhttpClient(Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(context))
                .build();
    }
}
