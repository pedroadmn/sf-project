package com.example.safra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safra.models.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Product> products;
    private String[] sContent;

    public StoreAdapter(Context context, List<Product> products){
        this.inflater = LayoutInflater.from(context);
        this.products = products;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_product_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Product product = products.get(i);
        viewHolder.productName.setText(product.getName());
        viewHolder.productDescription.setText(product.getDescription());
        viewHolder.productPrice.setText(product.getDescription());
//        GradientDrawable shape = new GradientDrawable();
//        shape.setShape(GradientDrawable.OVAL);
        // generate random color

//        Random r = new Random();
//        int red = r.nextInt(255 - 0 + i);
//        int green = r.nextInt(255 - i + 1);
//        int blue = r.nextInt(255 - 0 + (i+1));
//        shape.setColor(Color.rgb(red,green,blue));
//        viewHolder.circle.setBackground(shape);
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
