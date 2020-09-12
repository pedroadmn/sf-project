package com.example.safra.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.safra.ApiClient;
import com.example.safra.Constants;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.models.UserRequest;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.edtName)
    EditText edtName;

    @BindView(R.id.edtEmail)
    EditText edtEmail;

    @BindView(R.id.edtPhone)
    EditText edtPhone;

    @BindView(R.id.btnRegister)
    Button btnRegister;

    @BindView(R.id.txtLoginHere)
    TextView txtLoginHere;

    @BindView(R.id.registerProgressBar)
    ProgressBar progressBar;

    private ApiClient apiClient;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        ButterKnife.bind(this);

        txtLoginHere.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finishAffinity();
        });

        btnRegister.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            HashMap<String, String> headers = new HashMap<>();
            headers.put("Authorization",
                    String.format(Constants.HTTP_AUTHORIZATION_VALUE_PREFIX, sessionManager.fetchAuthToken()));
            apiClient.getInstance().createAccount(headers, new UserRequest(edtName.getText().toString().trim(), edtEmail.getText().toString().trim(), edtPhone.getText().toString().trim()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            () -> {
                                Toast.makeText(RegisterActivity.this, getString(R.string.registered_successfully), Toast.LENGTH_SHORT).show();
                                finish();
                                progressBar.setVisibility(View.INVISIBLE);
                            },
                            throwable -> {
                                Toast.makeText(RegisterActivity.this, getString(R.string.registered_unsuccessfully), Toast.LENGTH_SHORT).show();
                            });

        });
    }
}
