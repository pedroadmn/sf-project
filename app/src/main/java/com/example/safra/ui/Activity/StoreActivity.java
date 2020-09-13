package com.example.safra.ui.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safra.R;
import com.example.safra.StoreAdapter;
import com.example.safra.models.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        products.add(new Product(1, "Blusa Croche", "Tamanho M", "R$ 70, 00", 0));
        products.add(new Product(2, "Bermuda", "Tamanho G", "R$ 90, 00", 0));
        products.add(new Product(3, "Blusa Croche", "Tamanho M", "R$ 70, 00", 0));
        products.add(new Product(4, "Bermuda", "Tamanho G", "R$ 90, 00", 0));
        products.add(new Product(5, "Blusa Croche", "Tamanho M", "R$ 70, 00", 0));
        products.add(new Product(6, "Bermuda", "Tamanho G", "R$ 90, 00", 0));

        rvStore.setLayoutManager(new LinearLayoutManager(this));
        storeAdapter = new StoreAdapter(this, products);
        rvStore.setAdapter(storeAdapter);
    }
}
