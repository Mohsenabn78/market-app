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
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class MainActivity extends AppCompatActivity {
    private BannerSlider bannerSlider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //set Banner slider
        bannerSlider=(BannerSlider)findViewById(R.id.AM_bannerSlider);
        List<Banner> banners=new ArrayList<>();
        RemoteBanner banner1=new RemoteBanner("https://dkstatics-public.digikala.com/digikala-adservice-banners/1287439213fd42314f0e8bec0a88906139d593be_1602680546.jpg?x-oss-process=image/quality,q_80");
        RemoteBanner banner2=new RemoteBanner("https://dkstatics-public.digikala.com/digikala-adservice-banners/1e47655ba9d2e8e2b7cd139e9f0e1a60d5096f3e_1602687760.jpg?x-oss-process=image/quality,q_80");
        RemoteBanner banner3=new RemoteBanner("https://dkstatics-public.digikala.com/digikala-adservice-banners/b9c90e4ecc98271ddbfdad00e0b6e15f3969b721_1602678992.jpg?x-oss-process=image/quality,q_80");
        banners.add(banner1);
        banners.add(banner2);
        banners.add(banner3);
        bannerSlider.setBanners(banners);


        final CustomView customView=new CustomView(this);




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