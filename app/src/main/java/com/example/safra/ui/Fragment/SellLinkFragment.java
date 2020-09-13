package com.example.safra.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.safra.R;
import com.example.safra.StoreAdapter;
import com.example.safra.ui.Activity.MainActivity;

import butterknife.BindView;

public class SellLinkFragment extends Fragment {

    @BindView(R.id.btnShareLink)
    Button btnShareLink;

    @BindView(R.id.btnNewOrder)
    Button btnNewOrder;

    @BindView(R.id.ivSharedLink)
    ImageView ivSharedLink;

    @BindView(R.id.shareLinkProgressBar)
    ProgressBar shareLinkProgressBar;

    private MainActivity main;

    public SellLinkFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sell_link, container, false);

        main = (MainActivity) getActivity();

        btnShareLink = rootView.findViewById(R.id.btnShareLink);
        btnNewOrder = rootView.findViewById(R.id.btnNewOrder);
        ivSharedLink = rootView.findViewById(R.id.ivSharedLink);
        shareLinkProgressBar = rootView.findViewById(R.id.shareLinkProgressBar);

        return rootView;
    }
}