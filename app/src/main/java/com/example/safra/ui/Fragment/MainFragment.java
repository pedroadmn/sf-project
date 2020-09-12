package com.example.safra.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.safra.R;
import com.example.safra.ui.Activity.MainActivity;


public class MainFragment extends Fragment {

    private MainActivity main;
    private TextView
        accountNumber,
        accountBalance;
    private Button btnStore;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        main = (MainActivity) getActivity();
        accountNumber = rootView.findViewById(R.id.lblAccount);
        accountBalance = rootView.findViewById(R.id.lblBalance);
        btnStore = rootView.findViewById(R.id.btnStore);
        accountNumber.setText(getString(R.string.account_number_text).replace("%", String.valueOf(main.user.getAccount().getNumber())));
        accountBalance.setText(getString(R.string.balanceMessage).replace("%", String.valueOf(main.user.getAccount().getBalance())));
        btnStore.setOnClickListener(view -> {
            main.replaceFragment(new StoreFragment(), true);
        });
        return rootView;
    }
}