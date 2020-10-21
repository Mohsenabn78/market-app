package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.marketapp.ApiService.ApiService;
import com.example.marketapp.ApiService.GsonRequest;
import com.example.marketapp.Model.ProductModel;
import com.example.marketapp.View.CustomView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CustomView customView=new CustomView(this);
        customView.init();



        //init data

        Type type=new TypeToken<ArrayList<ProductModel>>(){}.getType();

        ApiService apiService=new ApiService(this);
        apiService.getProduct(0, "https://api.mockaroo.com/api/babff5c0?count=100&key=b3c2ba40", new Response.Listener<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(ArrayList<ProductModel> response) {
                Toast.makeText(MainActivity.this,"data recived",Toast.LENGTH_SHORT).show();
                customView.setupView(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"data not recived",Toast.LENGTH_SHORT).show();

            }
        },type);

    }
}