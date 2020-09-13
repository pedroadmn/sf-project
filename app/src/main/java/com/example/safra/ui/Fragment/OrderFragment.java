package com.example.safra.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.safra.AzureClient;
import com.example.safra.R;
import com.example.safra.SessionManager;
import com.example.safra.StoreAdapter;
import com.example.safra.Utils;
import com.example.safra.models.OrderAdapter;
import com.example.safra.models.Product;
import com.example.safra.models.sales.SalesRequest;
import com.example.safra.ui.Activity.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OrderFragment extends Fragment {

    @BindView(R.id.rvStore)
    RecyclerView rvStore;

    @BindView(R.id.txtTotal)
    TextView txtTotal;

    @BindView(R.id.btnFinishOrder)
    Button btnFinishOrder;

    @BindView(R.id.orderProgressBar)
    ProgressBar orderProgressBar;

    OrderAdapter orderAdapter;

    private MainActivity main;

    private List<Product> soldProducts;

    private List<com.example.safra.models.sales.Product> sales;

    private String accountNumber;

    private AzureClient azureClient;
    private SessionManager sessionManager;

    public OrderFragment(List<Product> products, String accountNumber) {
        this.soldProducts = products;
        this.accountNumber = accountNumber;
        this.sales = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_order, container, false);
        main = (MainActivity) getActivity();

        sessionManager = new SessionManager(main);
        azureClient = new AzureClient(main);

        txtTotal = rootView.findViewById(R.id.txtTotal);
        txtTotal.setText(String.format(getString(R.string.amount), getTotal()));

        btnFinishOrder = rootView.findViewById(R.id.btnFinishOrder);

        btnFinishOrder.setOnClickListener(v -> sendProductsInfo());

        orderProgressBar = rootView.findViewById(R.id.orderProgressBar);

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

    private void sendProductsInfo() {
        orderProgressBar.setVisibility(View.VISIBLE);
        SalesRequest salesRequest = new SalesRequest(this.accountNumber, getSalesList());
//        Map<String, String> header = Utils.getHeaders(main);
        azureClient.getInstance().sendSales(Utils.getHeaders(main), salesRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        linkToShare -> {
                            main.replaceFragment(new SellLinkFragment(linkToShare.getLink()), true);
                            orderProgressBar.setVisibility(View.INVISIBLE);
                        },
                        throwable -> {
                            orderProgressBar.setVisibility(View.INVISIBLE);
                        });
    }

    private List<com.example.safra.models.sales.Product> getSalesList() {
        for (Product product : soldProducts
             ) {
            sales.add(new com.example.safra.models.sales.Product(product.getId(), product.getQuantity()));
        }
        return sales;
    }

}