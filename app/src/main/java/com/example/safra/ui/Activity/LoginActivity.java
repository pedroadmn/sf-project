package com.example.safra.ui.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.safra.ApiClient;
import com.example.safra.AzureClient;
import com.example.safra.Constants;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.models.LoginRequest;
import com.example.safra.models.OauthClient;
import com.example.safra.models.UserRequest;
import com.example.safra.tools.HTTPRequest;
import com.example.safra.tools.JsonResponse;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {
    private SessionManager sessionManager;
    private OauthClient authClient;
    private AzureClient apiClient;
    private final int requestTimeout = 5000;

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
        apiClient = new AzureClient(this);
        sessionManager = new SessionManager(this);

        btnLogin.setOnClickListener(v -> {
            loginProgressBar.setVisibility(View.VISIBLE);
            login(edtConta.getText().toString(), edtPassword.getText().toString());
        });

        txtRegister.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));
    }

    private void login(String account, String pass){

        HashMap<String, String> headers = new HashMap<>();
        Disposable disposable = apiClient.getInstance().login(new LoginRequest(account, pass))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            loginProgressBar.setVisibility(View.GONE);
                            startActivity(new Intent(this, MainActivity.class).putExtra("Account", account));
                            finish();
                        },
                        throwable -> {
                            loginProgressBar.setVisibility(View.GONE);
                            Toast.makeText(this, getString(R.string.login_unsuccessfully), Toast.LENGTH_SHORT).show();
                        });


    }
}
