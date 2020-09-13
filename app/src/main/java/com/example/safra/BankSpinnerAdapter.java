package com.example.safra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.safra.models.Bank;

public class BankSpinnerAdapter extends ArrayAdapter<Bank> {
    private List<Bank> mItems;

    public BankSpinnerAdapter(@NonNull Context context, @NonNull List<Bank> list) {
        super(context, 0, list);
        mItems = list;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, @Nullable View convertView,
                               @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.custom_spinner_bank_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(mItems.get(position).getName());
        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    static class ViewHolder {
        TextView tvName;

        public ViewHolder(View view) {
            tvName = view.findViewById(android.R.id.text1);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public int getItemIndex(String name) {
        int index = mItems.indexOf(name);
        if (index == -1) {
            index = mItems.indexOf(name.toLowerCase());
        }
        return index;
    }
}