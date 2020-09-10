package com.example.safra.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;

import com.example.safra.ApiClient;
import com.example.safra.Constants;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.Utils;
import com.example.safra.models.OauthClient;
import com.example.safra.models.accountInfo.AccountInfoResponse;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ApiClient apiClient;
    private OauthClient authClient;
    private SessionManager sessionManager;
    private AccountInfoResponse account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        authClient = new OauthClient(this);
        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        Map<String, String> headers = Utils.getTokenRequestHeaders(Constants.CLIENT_ID, Constants.SECRET);

        authClient.getInstance().getAuthToken(headers, "client_credentials", "urn:opc:resource:consumer::all")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            sessionManager.saveAuthToken(response.getAccess_token());
                            Intent intent = getIntent();


                            apiClient.getInstance().getAccountInfo(Utils.getHeaders(this), intent.getStringExtra("Account"))
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(
                                            accountResponse -> {
                                                account = accountResponse;
                                            },
                                            throwable -> {
                                            });
                        },
                        throwable -> {
                        });
    }
}