package com.example.safra;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private SessionManager sessionManager;

    public AuthenticationInterceptor(Context context) {
        sessionManager = new SessionManager(context);
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();

        requestBuilder.addHeader("Authorization", "Bearer " + sessionManager.fetchAuthToken());

        return chain.proceed(requestBuilder.build());
    }
}
