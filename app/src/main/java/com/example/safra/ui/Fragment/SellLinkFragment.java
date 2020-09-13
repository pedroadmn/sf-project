package com.example.safra.ui.Fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

    @BindView(R.id.sharedLink)
    TextView sharedLink;

    private MainActivity main;

    private String linkToShare;

    public SellLinkFragment(String linkToShare) {
        this.linkToShare = linkToShare;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sell_link, container, false);

        main = (MainActivity) getActivity();

        btnShareLink = rootView.findViewById(R.id.btnShareLink);
        btnNewOrder = rootView.findViewById(R.id.btnNewOrder);
        ivSharedLink = rootView.findViewById(R.id.ivSharedLink);

        ivSharedLink.setOnClickListener(v -> copyText());

        sharedLink = rootView.findViewById(R.id.sharedLink);
        shareLinkProgressBar = rootView.findViewById(R.id.shareLinkProgressBar);

        btnShareLink.setOnClickListener(v -> shareLink(linkToShare));

        sharedLink.setText(linkToShare);

        return rootView;
    }

    private void copyText() {
        ClipboardManager manager = (ClipboardManager) main.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("text", sharedLink.getText());
        manager.setPrimaryClip(clipData);
        Toast.makeText(main, "Link copiado", Toast.LENGTH_SHORT).show();
    }

    private void shareLink(String link){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, link);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

}