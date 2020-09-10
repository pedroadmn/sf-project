package com.example.safra.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.safra.ApiClient;
import com.example.safra.R;
import com.example.safra.SessionManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ApiClient apiClient;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

//        apiClient.getInstance().getHealth()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        response -> {
//                            if (response.getStatusCode() == 200 && response.getUser() != null) {
//                                sessionManager.saveAuthToken(response.getAuthToken());
//                            } else {
//                                // Error logging in
//                            }
//                        },
//                        throwable -> {
//                            String b = "";
//                        });
    }
}