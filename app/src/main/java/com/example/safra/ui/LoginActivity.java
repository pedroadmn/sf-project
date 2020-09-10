package com.example.safra.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safra.ApiClient;
import com.example.safra.Constants;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.Utils;
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

    @BindView(R.id.edtEmail)
    TextView edtEmail;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.loginProgressBar)
    ProgressBar loginProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        authClient = new OauthClient(this);
        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        btnLogin.setOnClickListener(v -> login());

        txtRegister.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));
    }

    private void login() {
        loginProgressBar.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Account", edtEmail.getText().toString().trim());
        startActivity(intent);
    }
}
