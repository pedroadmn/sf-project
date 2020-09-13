package com.example.safra.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.safra.R;
import com.example.safra.models.Transaction;
import com.example.safra.ui.Activity.MainActivity;

public class TransferFragment extends Fragment {

    private Button
        btnBack,
        btnConfirm;

    private EditText
        txtBank,
        txtAgency,
        txtNumber,
        txtDigit,
        txtAmount;

    private MainActivity main;

    public TransferFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_transfer, container, false);
        main = (MainActivity) getActivity();

        btnConfirm = rootView.findViewById(R.id.btnTransfer);
        btnBack = rootView.findViewById(R.id.btnBckTransfer);

        //txtBank = rootView.findViewById(R.id.TxtBankSelect);
        txtAgency = rootView.findViewById(R.id.txtAgencyIn);
        txtNumber = rootView.findViewById(R.id.txtAccountIn);
        txtDigit = rootView.findViewById(R.id.txtDigitIn);
        txtAmount = rootView.findViewById(R.id.txtValIn);

        btnConfirm.setOnClickListener(view -> {
            Transaction ted = new Transaction(
                txtNumber.getText().toString() + txtDigit.getText().toString(),
                Double.parseDouble(txtAmount.getText().toString()),
                "txtBank.getText().toString()",
                "",
                main.user
            );

            try {
                ted.makeTransaction();
            } catch (Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(view -> {
            main.kickReplaceFragment();
        });
        return rootView;
    }
}