package com.example.safra.ui.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safra.R;
import com.example.safra.models.Transaction;
import com.example.safra.ui.Activity.MainActivity;

import java.util.Objects;

public class TransferFragment extends Fragment {

    private Button
        btnBack,
        btnConfirm;

    private EditText
        txtAgency,
        txtNumber,
        txtDigit,
        txtAmount;
    private TextView txtBank;

    protected class Bank{
        public final String name;
        public final int number;

        Bank(String name, int number){
            this.name = name;
            this.number = number;
        }

        public boolean isSet(){return (name.isEmpty() && number == 0);}
    }

    protected Bank bank;

    private MainActivity main;

    public TransferFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_transfer, container, false);
        main = (MainActivity) getActivity();

        btnConfirm = rootView.findViewById(R.id.btnTransfer);
        btnBack = rootView.findViewById(R.id.btnBckTransfer);

        txtBank = rootView.findViewById(R.id.TxtBankSelect);
        txtAgency = rootView.findViewById(R.id.txtAgencyIn);
        txtNumber = rootView.findViewById(R.id.txtAccountIn);
        txtDigit = rootView.findViewById(R.id.txtDigitIn);
        txtAmount = rootView.findViewById(R.id.txtValIn);

        btnConfirm.setOnClickListener(view -> {
            if(
                    !txtAgency.getText().toString().isEmpty() &&
                    !txtNumber.getText().toString().isEmpty() &&
                    !txtDigit.getText().toString().isEmpty() &&
                    !txtAmount.getText().toString().isEmpty()
            ) {
                Transaction ted = new Transaction(
                        txtNumber.getText().toString() + txtDigit.getText().toString(),
                        Double.parseDouble(txtAmount.getText().toString()),
                        "txtBank.getText().toString()",
                        "",
                        main.user
                );

                try {
                    ted.makeTransaction();

                    final Dialog dial = new Dialog(Objects.requireNonNull(getActivity()), android.R.style.Theme_Black_NoTitleBar);
                    dial.setContentView(R.layout.popup_transfer);
                    Objects.requireNonNull(dial.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
                    dial.setCancelable(true);
                    dial.show();

                    main.kickReplaceFragment();

                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(getActivity(), "Todos os campos devem ser preenchidos", Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(view -> {
            main.kickReplaceFragment();
        });
        return rootView;
    }
}