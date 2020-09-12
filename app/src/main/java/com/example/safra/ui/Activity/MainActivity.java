package com.example.safra.ui.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
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
import com.example.safra.interfaces.FragmentChangeListener;
import com.example.safra.models.Account;
import com.example.safra.models.OauthClient;
import com.example.safra.models.User;
import com.example.safra.models.accountBalance.AccountBalanceResponse;
import com.example.safra.models.accountInfo.AccountInfoResponse;
import com.example.safra.ui.Fragment.MainFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity
        extends AppCompatActivity
        implements FragmentChangeListener {

    private ApiClient apiClient;
    private OauthClient authClient;
    private SessionManager sessionManager;
    private AccountInfoResponse account;
    private AccountBalanceResponse accountBalance;
    private List<Fragment> backList = new ArrayList<>();
    private Fragment fragment;
    public User user;
    public Account userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userAccount = new Account(
                0,
                "115432",
                1,
                236,
                250
        );

        user = new User(
                String.valueOf(1),
                "teste",
                "da silva",
                "teste.dasilva@teste.com.br",
                userAccount
        );

        ButterKnife.bind(this);

        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        authClient = new OauthClient(this);
        apiClient = new ApiClient(this);
        sessionManager = new SessionManager(this);

        Map<String, String> headers = Utils.getTokenRequestHeaders(Constants.CLIENT_ID, Constants.SECRET);

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Disposable disposable = authClient.getInstance().getAuthToken(headers, "client_credentials", "urn:opc:resource:consumer::all")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            sessionManager.saveAuthToken(response.getAccess_token());
                            Intent intent = getIntent();

                            CompositeDisposable compositeDisposableIn = new CompositeDisposable();

                            Disposable disposableIn = apiClient.getInstance().getAccountBalances(Utils.getHeaders(this), intent.getStringExtra("Account"))
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(
                                            accountBalanceResponse -> {
                                                String accountNumber = String.format(getString(R.string.cc), accountBalanceResponse.getData().getBalance().get(0).getAccountId());
                                                String accountBalance = String.format(getString(R.string.balance), accountBalanceResponse.getData().getBalance().get(0).getAmount().getAmount());
                                                user.getAccount().setBalance(Double.parseDouble(accountBalance.substring(3)));
                                                user.getAccount().setNumber(accountNumber.substring(3));
                                            },
                                            throwable -> {
                                            });
                            compositeDisposableIn.add(disposableIn);
                        },
                        throwable -> {
                        });
        compositeDisposable.add(disposable);
        replaceFragment(new MainFragment(), true);
    }

    @Override
    public void replaceFragment(Fragment fragment, Boolean backStackable) {
        this.fragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, fragment, fragment.toString());
        if (backStackable) {
            backList.add(fragment);
        }
        fragmentTransaction.commit();
    }

    void kickReplaceFragment() {
        int index = backList.size() - 2;
        replaceFragment(backList.get(index), false);
        backList.remove(index + 1);
    }

    @Override
    public void onBackPressed() {
        if (backList.size() >= 1) {
            kickReplaceFragment();
        } else {
            confirmDialog();
        }
    }

    private void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Deseja realmente sair?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }
}