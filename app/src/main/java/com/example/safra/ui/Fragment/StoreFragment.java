package com.example.safra.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.safra.R;
import com.example.safra.StoreAdapter;
import com.example.safra.models.Product;
import com.example.safra.ui.Activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreFragment extends Fragment {

    @BindView(R.id.rvStore)
    RecyclerView rvStore;

    @BindView(R.id.btnNewProduct)
    Button btnNewProduct;

    @BindView(R.id.btnClosePurchase)
    Button btnClosePurchase;

    StoreAdapter storeAdapter;

    private MainActivity main;

    public StoreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_store, container, false);

        main = (MainActivity) getActivity();

        rvStore = rootView.findViewById(R.id.rvStore);
        btnClosePurchase = rootView.findViewById(R.id.btnClosePurchase);

        ButterKnife.bind(main, rootView);
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Blusa Croche", "Tamanho M", "R$ 70, 00", 0));
        products.add(new Product("2", "Bermuda", "Tamanho G", "R$ 90, 00", 0));
        products.add(new Product("3", "Blusa Croche", "Tamanho M", "R$ 70, 00", 0));
        products.add(new Product("4", "Bermuda", "Tamanho G", "R$ 90, 00", 0));
        products.add(new Product("5", "Blusa Croche", "Tamanho M", "R$ 70, 00", 0));
        products.add(new Product("6", "Bermuda", "Tamanho G", "R$ 90, 00", 0));

        rvStore.setLayoutManager(new LinearLayoutManager(main));
        storeAdapter = new StoreAdapter(main, products);
        rvStore.setAdapter(storeAdapter);

        btnClosePurchase.setOnClickListener(v -> main.replaceFragment(new OrderFragment(storeAdapter.getProducts()), true));
        return rootView;
    }
}