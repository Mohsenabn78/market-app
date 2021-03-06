package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.marketapp.Adapter.ProductAdapter;
import com.example.marketapp.ApiService.ApiService;
import com.example.marketapp.Model.ProductModel;
import com.example.marketapp.View.CustomView;
import com.example.marketapp.View.ProductDetail;
import com.example.marketapp.View.Prouducts_Activity;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class MainActivity extends AppCompatActivity {
    private BannerSlider bannerSlider;
    private CustomView LatestCustomView;
    private CustomView PopularCustomView;
    private ProgressBar NewProductProgress;
    private ProgressBar PopProductProgress;
    private ArrayList<ProductModel>LastProductList=new ArrayList<>();
    private ArrayList<ProductModel>popProductList=new ArrayList<>();

    private ImageView TabLayoutCar;
    private ImageView TabLayoutBike;
    private ImageView TabLayoutMopo;



    private ProductAdapter.ItemClickListener listener=new ProductAdapter.ItemClickListener() {
        @Override
        public void ItemIdListener(ProductModel productModel) {
            Intent Itemintent=new Intent(MainActivity.this, ProductDetail.class);
            Itemintent.putExtra(ProductDetail.PRODUCT_ID,productModel);
            startActivity(Itemintent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        ProductRequest();

    }




    private void ProductRequest(){
        Type type=new TypeToken<ArrayList<ProductModel>>(){}.getType();

        //new product
        ApiService NewProduct=new ApiService(this);
        NewProduct.getProduct(0, "https://api.mockaroo.com/api/babff5c0?count=100&key=b3c2ba40", new Response.Listener<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(ArrayList<ProductModel> response) {
                Toast.makeText(MainActivity.this,"Fake Data Received From Server",Toast.LENGTH_SHORT).show();
                LatestCustomView.setupView(response,listener);
                LastProductList=response;
                NewProductProgress.setVisibility(View.GONE);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"data not Received from server",Toast.LENGTH_SHORT).show();


            }
        },type);

        //popular product
        final ApiService PopularProduct=new ApiService(this);
        PopularProduct.getProduct(0, "https://api.mockaroo.com/api/babff5c0?count=100&key=b3c2ba40", new Response.Listener<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(ArrayList<ProductModel> response) {
                PopularCustomView.setupView(response,listener);
                popProductList=response;
                PopProductProgress.setVisibility(View.GONE);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        },type);
    }

    private void setupView() {

        //set Basket


        //set TabLayout Category
        TabLayoutBike=findViewById(R.id.Tablayout_bike);
        TabLayoutCar=findViewById(R.id.Tablayout_car);
        TabLayoutMopo=findViewById(R.id.Tablayout_mopo);

        TabLayoutBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Server Category Not Found",Toast.LENGTH_SHORT).show();
            }
        });
        TabLayoutCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Server Category Not Found",Toast.LENGTH_SHORT).show();
            }
        });
        TabLayoutMopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Server Category Not Found",Toast.LENGTH_SHORT).show();
            }
        });

        //set Banner slider
        bannerSlider = findViewById(R.id.AM_bannerSlider);
        List<Banner> banners = new ArrayList<>();
        RemoteBanner banner1 = new RemoteBanner("https://blogmedia.dealerfire.com/wp-content/uploads/sites/988/2019/05/2020-Kia-Sportage-Burnished-Copper-side-view_o.jpg");
        RemoteBanner banner2 = new RemoteBanner("https://www.iihs.org/api/ratings/model-year-images/2801");
        RemoteBanner banner3 = new RemoteBanner("https://mc.webpcache.epapr.in/pro.php?size=large&in=https://mc.webpcache.epapr.in/mcms.php?size=large&in=https://mcmscache.epapr.in/post_images/website_300/post_14869981/thumb.jpg");
        banners.add(banner1);
        banners.add(banner2);
        banners.add(banner3);
        bannerSlider.setBanners(banners);


        //set ProgressBar
        NewProductProgress=findViewById(R.id.Am_newproduct_progress);
        PopProductProgress=findViewById(R.id.Am_popproduct_progress);

        //Init Custom View
        LatestCustomView = findViewById(R.id.AM_customView_latest);
        LatestCustomView.setTextView("New Product");
        LatestCustomView.viewAllOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lastIntent = new Intent(MainActivity.this, Prouducts_Activity.class);
                lastIntent.putExtra(Prouducts_Activity.Intent_Key, LastProductList);
                startActivity(lastIntent);

            }
        });


        PopularCustomView = findViewById(R.id.AM_customView_Popular);
        PopularCustomView.setTextView("Popular Product");
        PopularCustomView.viewAllOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent2 = new Intent(MainActivity.this, Prouducts_Activity.class);
                Intent2.putExtra(Prouducts_Activity.Intent_Key, popProductList);
                startActivity(Intent2);
            }
        });

    }
}