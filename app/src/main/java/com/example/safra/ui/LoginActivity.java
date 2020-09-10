package com.example.safra.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safra.ApiClient;
import com.example.safra.Constants;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.models.OauthClient;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {
    private SessionManager sessionManager;
    private OauthClient authClient;
    private ApiClient apiClient;

    @BindView(R.id.txtRegister)
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        authClient = new OauthClient(this);
        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        txtRegister.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));

        Map<String, String> headers = getTokenRequestHeaders1(Constants.CLIENT_ID, Constants.SECRET);

        authClient.getInstance().getAuthToken(headers, "client_credentials", "urn:opc:resource:consumer::all")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> sessionManager.saveAuthToken(response.getAccess_token()),
                        throwable -> {
                        });
    }

    private static Map<String, String> getTokenRequestHeaders1(String clientId, String clientSecret) {
        Map<String, String> headers = new HashMap<>();
        String base64Secret = "Basic "
                + (Base64.encodeToString((clientId
                + ":"
                + clientSecret).getBytes(), Base64.NO_WRAP));
        headers.put("Authorization", base64Secret);

        return headers;
    }
}
