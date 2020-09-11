package com.example.safra.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safra.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import mva3.adapter.MultiViewAdapter;

public class StoreActivity extends AppCompatActivity {

    @BindView(R.id.rvRecyclerView)
    RecyclerView rvRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ButterKnife.bind(this);
    }
}
