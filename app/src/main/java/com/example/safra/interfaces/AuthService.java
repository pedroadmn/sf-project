package com.example.safra.interfaces;

import com.example.safra.Constants;
import com.example.safra.models.TokenResponse;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface AuthService {
    @FormUrlEncoded
    @POST(Constants.TOKEN)
    Observable<TokenResponse> getAuthToken(@HeaderMap Map<String, String> headers, @Field("grant_type") String grantType, @Field("scope") String scope);
}
