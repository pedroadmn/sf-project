package com.example.safra.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safra.R;
import com.example.safra.ui.Fragment.OrderFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Product> soldProducts;
    private OrderFragment orderFragment;

    public OrderAdapter(Context context, List<Product> products, OrderFragment fragment) {
        this.inflater = LayoutInflater.from(context);
        this.soldProducts = products;
        this.orderFragment = fragment;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_purchase_item, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (soldProducts.get(i).getQuantity() != 0) {
            viewHolder.productName.setText(soldProducts.get(i).getName());
            viewHolder.productQuantity.setText(String.format(viewHolder.itemView.getContext().getString(R.string.product_quantity), String.valueOf(soldProducts.get(i).getQuantity())));
            viewHolder.productPrice.setText(String.format(viewHolder.itemView.getContext().getString(R.string.price), String.valueOf(Double.parseDouble(soldProducts.get(i).getPrice()) * soldProducts.get(i).getQuantity())));
            viewHolder.addProduct.setOnClickListener(v -> {
                soldProducts.get(i).setQuantity(soldProducts.get(i).getQuantity() + 1);
                this.notifyDataSetChanged();
                this.orderFragment.getTotal(soldProducts);
            });

            viewHolder.removeProduct.setOnClickListener(v -> {
                soldProducts.get(i).setQuantity(soldProducts.get(i).getQuantity() - 1);
                this.notifyDataSetChanged();
                this.orderFragment.getTotal(soldProducts);
            });
        }
    }

    @Override
    public int getItemCount() {
        return soldProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.product_name)
        TextView productName;

        @BindView(R.id.product_quantity)
        TextView productQuantity;

        @BindView(R.id.product_price)
        TextView productPrice;

        @BindView(R.id.add_product)
        ImageView addProduct;

        @BindView(R.id.remove_product)
        ImageView removeProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent i = new Intent(v.getContext(),Details.class);
//                    // send story title and contents through recyclerview to detail activity
//                    i.putExtra("titleOfStory",sTitles[getAdapterPosition()]);
//                    i.putExtra("contentOfStory",sContent[getAdapterPosition()]);
//                    v.getContext().startActivity(i);
                }
            });
        }
    }

}
