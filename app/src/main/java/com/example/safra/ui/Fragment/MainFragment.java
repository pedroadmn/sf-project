package com.example.safra.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safra.R;
import com.example.safra.interfaces.UpdateBalance;
import com.example.safra.ui.Activity.MainActivity;


public class MainFragment
        extends Fragment{

    private MainActivity main;
    private TextView
        accountBalance,
        welcome;
    private Button
            btnStore,
            btnExit,
            btnProfile;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        main = (MainActivity) getActivity();

        accountBalance = rootView.findViewById(R.id.lblBalance);
        welcome = rootView.findViewById(R.id.lblMyName);
        btnStore = rootView.findViewById(R.id.btnStore);
        btnExit = rootView.findViewById(R.id.btnExit);
        btnProfile = rootView.findViewById(R.id.btnProfile);

        welcome.setText(getString(R.string.name_placeholder_account).replace("%1", "o").replace("%2", main.user.getFirstName()));
        accountBalance.setText(getString(R.string.balanceMessage).replace("%", String.valueOf(main.user.getAccount().getBalance())));

        btnStore.setOnClickListener(view -> {
            main.replaceFragment(new StoreFragment(), true);
        });

        btnExit.setOnClickListener(view -> {
            main.confirmDialog();
        });

        btnProfile.setOnClickListener(view -> {
            Toast.makeText(getActivity(),"Not yet implemented", Toast.LENGTH_LONG).show();
            main.replaceFragment(new ProfileFragment(), true);
        });

        return rootView;
    }

    public void updateBalance(){
        accountBalance.setText(getString(R.string.balanceMessage).replace("%", String.valueOf(main.user.getAccount().getBalance())));
    }
}