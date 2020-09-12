package com.example.safra.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safra.ApiClient;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.models.OauthClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private SessionManager sessionManager;
    private OauthClient authClient;
    private ApiClient apiClient;

    @BindView(R.id.txtRegister)
    TextView txtRegister;

    @BindView(R.id.edtEmail)
    EditText edtConta;

    @BindView(R.id.edtPassword)
    EditText edtPassword;

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

        btnLogin.setOnClickListener(v -> {
            loginProgressBar.setVisibility(View.VISIBLE);
            if (validLogin(edtConta.getText().toString(), edtPassword.getText().toString())) {
                login();
            }
        });

        txtRegister.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));
    }

    Boolean validLogin(String email, String pass){
        //Validate the credential to see if it is valid or not.
        //Case it's valid, the method should return TRUE.
        //Otherwise, a FALSE should be returned
        return true;
    }

    private void login() {
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            loginProgressBar.setVisibility(View.GONE);
            startActivity(new Intent(this, MainActivity.class).putExtra("Account", edtConta.getText().toString().trim()));
            finish();
        }, 2000);
    }
}
