package com.example.safra.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safra.R;
import com.example.safra.StoreAdapter;
import com.example.safra.models.Product;

import java.util.ArrayList;
import java.util.List;

public class StoreFragment extends Fragment {

    public StoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_store, container, false);
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Blusa Croche", "Tamanho M", "R$ 70, 00"));
        products.add(new Product("2", "Bermuda", "Tamanho G", "R$ 90, 00"));
        products.add(new Product("3", "Blusa Croche", "Tamanho M", "R$ 70, 00"));
        products.add(new Product("4", "Bermuda", "Tamanho G", "R$ 90, 00"));
        products.add(new Product("5", "Blusa Croche", "Tamanho M", "R$ 70, 00"));
        products.add(new Product("6", "Bermuda", "Tamanho G", "R$ 90, 00"));

        /*rvStore.setLayoutManager(new LinearLayoutManager(this));
        storeAdapter = new StoreAdapter(this, products);
        rvStore.setAdapter(storeAdapter);*/
        return rootView;
    }
}