package com.example.safra.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.safra.ApiClient;
import com.example.safra.Constants;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.Utils;
import com.example.safra.models.OauthClient;
import com.example.safra.models.accountBalance.AccountBalanceResponse;
import com.example.safra.models.accountInfo.AccountInfoResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ApiClient apiClient;
    private OauthClient authClient;
    private SessionManager sessionManager;
    private AccountInfoResponse account;
    private AccountBalanceResponse accountBalance;
    private List<Fragment> backList;

    @BindView(R.id.lblAccount)
    TextView lblAccount;

    @BindView(R.id.lblBalance)
    TextView lblBalance;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        authClient = new OauthClient(this);
        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        Map<String, String> headers = Utils.getTokenRequestHeaders(Constants.CLIENT_ID, Constants.SECRET);

        progressBar.setVisibility(View.GONE);

        authClient.getInstance().getAuthToken(headers, "client_credentials", "urn:opc:resource:consumer::all")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            sessionManager.saveAuthToken(response.getAccess_token());
                            Intent intent = getIntent();

                            apiClient.getInstance().getAccountBalances(Utils.getHeaders(this), intent.getStringExtra("Account"))
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(
                                            accountBalanceResponse -> {
                                                String accountNumber = String.format(getString(R.string.cc), accountBalanceResponse.getData().getBalance().get(0).getAccountId());
                                                String accountBalance = String.format(getString(R.string.balance), accountBalanceResponse.getData().getBalance().get(0).getAmount().getAmount());
                                                lblBalance.setText(accountBalance);
                                                lblAccount.setText(accountNumber);
                                                lblAccount.setVisibility(View.VISIBLE);
                                                lblBalance.setVisibility(View.VISIBLE);
                                                progressBar.setVisibility(View.INVISIBLE);
                                            },
                                            throwable -> {
                                            });
                        },
                        throwable -> {
                        });
    }
}