package com.example.marketapp.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketapp.Adapter.ProductAdapter;
import com.example.marketapp.Model.ProductModel;
import com.example.marketapp.R;

import java.util.ArrayList;

import static com.example.marketapp.R.layout.custom_view;

//this class is a custom view for main activity

public class CustomView extends LinearLayout {

    private RecyclerView recyclerView;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init(){
        View view= LayoutInflater.from(getContext()).inflate(custom_view,this,true);
        recyclerView= view.findViewById(R.id.CV_RecyclerView);

    }

    public void setupView(ArrayList<ProductModel>productModelArrayList){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        ProductAdapter productAdapter=new ProductAdapter(getContext(),productModelArrayList);
        recyclerView.setAdapter(productAdapter);
    }


    /*
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

     */



}

