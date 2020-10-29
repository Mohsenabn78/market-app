package com.example.marketapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.marketapp.Adapter.ProductAdapter;
import com.example.marketapp.MainActivity;
import com.example.marketapp.Model.ProductModel;
import com.example.marketapp.R;

import java.util.ArrayList;

public class Prouducts_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ProductModel>IntentGetModel;
    private ImageView imageView;

    public static final String Intent_Key="ProductList";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prouducts_);

        imageView=findViewById(R.id.AP_Backbutton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        final Intent intent =getIntent();
        IntentGetModel= (ArrayList<ProductModel>) intent.getSerializableExtra(Intent_Key);

        //IntentGetModel =intent.getParcelableExtra(Intent_Key);

        recyclerView=findViewById(R.id.AP_recycler);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        ProductAdapter productAdapter=new ProductAdapter(this, IntentGetModel, new ProductAdapter.ItemClickListener() {
            @Override
            public void ItemIdListener(ProductModel productModel) {
                
                Intent intent2=new Intent(Prouducts_Activity.this,ProductDetail.class);
                intent2.putExtra(ProductDetail.PRODUCT_ID,productModel);
                startActivity(intent2);
            }
        });

        recyclerView.setAdapter(productAdapter);



    }
}