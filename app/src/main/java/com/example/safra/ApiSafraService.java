package com.example.safra;

import com.example.safra.models.HealthResponse;
import com.example.safra.models.TokenResponse;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface ApiSafraService {
    @GET(Constants.HEALTH_SUFFIX)
    Observable<HealthResponse> getHealth();
}
