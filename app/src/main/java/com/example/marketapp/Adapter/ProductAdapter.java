package com.example.marketapp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketapp.Model.ProductModel;
import com.example.marketapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private Context context;
    private ArrayList<ProductModel> productModelArrayList1;

    public ProductAdapter(Context context,ArrayList<ProductModel>productModelArrayList){
        this.context=context;
        this.productModelArrayList1=productModelArrayList;

    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_sample,parent,false);
        return new  ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {

        holder.ItemBind(productModelArrayList1.get(position));
    }

    @Override
    public int getItemCount() {
        return productModelArrayList1.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView Title;
        private TextView description;
        private TextView PrePrice;
        private TextView Price;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.IS_ImageView);
            Title=itemView.findViewById(R.id.IS_Title);
            description= itemView.findViewById(R.id.IS_Des);
            PrePrice= itemView.findViewById(R.id.IS_PrePrice);
            Price= itemView.findViewById(R.id.IS_Price);
        }
        public void ItemBind(ProductModel model){
            Title.setText(model.getTitle());
            description.setText(model.getDescription());
            PrePrice.setText(model.getPrePrice());
            Price.setText(model.getPrice());
            Picasso.with(context).load(Uri.parse(model.getImageUrl())).into(imageView);

        }
    }
}
