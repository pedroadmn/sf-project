package com.example.safra.ui.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.safra.ApiClient;
import com.example.safra.AzureClient;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.StoreAdapter;
import com.example.safra.Utils;
import com.example.safra.models.OauthClient;
import com.example.safra.models.Product;
import com.example.safra.ui.Activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class StoreFragment extends Fragment {

    @BindView(R.id.rvStore)
    RecyclerView rvStore;

    @BindView(R.id.btnNewProduct)
    Button btnNewProduct;

    @BindView(R.id.btnClosePurchase)
    Button btnClosePurchase;

    @BindView(R.id.storeProgressBar)
    ProgressBar storeProgressBar;

    StoreAdapter storeAdapter;

    private MainActivity main;

    private ApiClient apiClient;
    private AzureClient azureClient;
    private SessionManager sessionManager;

    private List<Product> products;

    private String accountNumber;

    public StoreFragment(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_store, container, false);

        main = (MainActivity) getActivity();

        rvStore = rootView.findViewById(R.id.rvStore);
        btnClosePurchase = rootView.findViewById(R.id.btnClosePurchase);
        storeProgressBar = rootView.findViewById(R.id.storeProgressBar);

        apiClient = new ApiClient(main);
        sessionManager = new SessionManager(main);
        azureClient = new AzureClient(main);

        products = new ArrayList<>();

        storeProgressBar.setVisibility(View.VISIBLE);

        azureClient.getInstance().getProducts(Utils.getHeaders(main), accountNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            products = response;
                            rvStore.setLayoutManager(new LinearLayoutManager(main));
                            storeAdapter = new StoreAdapter(main, products);
                            rvStore.setAdapter(storeAdapter);
                            storeProgressBar.setVisibility(View.INVISIBLE);
                        },
                        throwable -> {
                            storeProgressBar.setVisibility(View.INVISIBLE);
                        });


//        products.add(new Product("1", "Blusa Croche", "Tamanho M", "70.00", 0));
//        products.add(new Product("2", "Bermuda", "Tamanho G", "90.00", 0));
//        products.add(new Product("3", "Blusa Croche", "Tamanho M", "70.00", 0));
//        products.add(new Product("4", "Bermuda", "Tamanho G", "90.00", 0));
//        products.add(new Product("5", "Blusa Croche", "Tamanho M", "70.00", 0));
//        products.add(new Product("6", "Bermuda", "Tamanho G", "90.00", 0));

        btnClosePurchase.setOnClickListener(v -> main.replaceFragment(new OrderFragment(storeAdapter.getSoldProducts(), accountNumber), true));
        return rootView;
    }
}