package com.example.safra.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

    @BindView(R.id.txtTotal)
    TextView txtTotal;

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


        txtTotal = rootView.findViewById(R.id.txtTotal);
        txtTotal.setText(String.format(getString(R.string.amount), getTotal()));

        rvStore = rootView.findViewById(R.id.rvStore);

        rvStore.setLayoutManager(new LinearLayoutManager(main));
        orderAdapter = new OrderAdapter(main, soldProducts);
        rvStore.setAdapter(orderAdapter);
        return rootView;
    }

    private String getTotal() {
        double total = 0;
        for (Product product : soldProducts) {
            total += product.getQuantity() * Double.parseDouble(product.getPrice());
        }
        return String.valueOf(total);
    }
}