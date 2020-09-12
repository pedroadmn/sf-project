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
import com.example.safra.models.OrderAdapter;
import com.example.safra.models.Product;
import com.example.safra.ui.Activity.MainActivity;

import java.util.List;

import butterknife.BindView;

public class OrderFragment extends Fragment {

    @BindView(R.id.rvStore)
    RecyclerView rvStore;

    OrderAdapter orderAdapter;

    private MainActivity main;

    private List<Product> soldProducts;

    public OrderFragment(List<Product> products) {
        this.soldProducts = products;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_order, container, false);
        main = (MainActivity) getActivity();

        rvStore = rootView.findViewById(R.id.rvStore);

//        ButterKnife.bind(main, rootView);
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("1", "Blusa Croche", "Tamanho M", "R$ 70, 00"));
//        products.add(new Product("2", "Bermuda", "Tamanho G", "R$ 90, 00"));
//        products.add(new Product("3", "Blusa Croche", "Tamanho M", "R$ 70, 00"));
//        products.add(new Product("4", "Bermuda", "Tamanho G", "R$ 90, 00"));
//        products.add(new Product("5", "Blusa Croche", "Tamanho M", "R$ 70, 00"));
//        products.add(new Product("6", "Bermuda", "Tamanho G", "R$ 90, 00"));

        rvStore.setLayoutManager(new LinearLayoutManager(main));
        orderAdapter = new OrderAdapter(main, soldProducts);
        rvStore.setAdapter(orderAdapter);
        return rootView;
    }
}