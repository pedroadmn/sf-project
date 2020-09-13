package com.example.safra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safra.models.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Product> products;
    private List<Product> soldProducts;

    public StoreAdapter(Context context, List<Product> products){
        this.inflater = LayoutInflater.from(context);
        this.products = products;
        this.soldProducts = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_product_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Product product = this.products.get(i);
        viewHolder.productName.setText(product.getName());
        viewHolder.productDescription.setText(product.getDescription());
        viewHolder.productPrice.setText(String.format(viewHolder.itemView.getContext().getString(R.string.price), product.getPrice()));
        viewHolder.btnSell.setOnClickListener(view -> {
            int qty = this.products.get(i).getQuantity();
            this.products.get(i).setQuantity(qty + 1);
        });
    }

    public List<Product> getSoldProducts() {
        for (Product product : products) {
            if (product.getQuantity() != 0)
            this.soldProducts.add(product);
        }
        return this.soldProducts;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.product_name)
        TextView productName;

        @BindView(R.id.product_description)
        TextView productDescription;

        @BindView(R.id.product_price)
        TextView productPrice;

        @BindView(R.id.product_image)
        ImageView productImage;

        @BindView(R.id.btnSell)
        Button btnSell;

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
