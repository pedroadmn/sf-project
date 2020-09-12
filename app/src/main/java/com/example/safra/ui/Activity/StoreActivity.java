package com.example.safra.ui.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safra.R;
import com.example.safra.StoreAdapter;
import com.example.safra.models.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mva3.adapter.MultiViewAdapter;

public class StoreActivity extends AppCompatActivity {

    @BindView(R.id.rvStore)
    RecyclerView rvStore;

    StoreAdapter storeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ButterKnife.bind(this);

        List<Product> products = new ArrayList<>();
        Product product1 = new Product("1", "Blusa Croche", "Tamanho M", "R$ 70, 00");
        Product product2 = new Product("2", "Bermuda", "Tamanho G", "R$ 90, 00");
        Product product3 = new Product("3", "Blusa Croche", "Tamanho M", "R$ 70, 00");
        Product product4 = new Product("4", "Bermuda", "Tamanho G", "R$ 90, 00");
        Product product5 = new Product("5", "Blusa Croche", "Tamanho M", "R$ 70, 00");
        Product product6 = new Product("6", "Bermuda", "Tamanho G", "R$ 90, 00");
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);

        rvStore.setLayoutManager(new LinearLayoutManager(this));
        storeAdapter = new StoreAdapter(this, products);
        rvStore.setAdapter(storeAdapter);
    }
}
