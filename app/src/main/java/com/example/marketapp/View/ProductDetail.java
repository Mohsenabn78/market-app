package com.example.marketapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marketapp.Model.ProductModel;
import com.example.marketapp.R;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class ProductDetail extends AppCompatActivity {
    public static final String PRODUCT_ID="product id";
    private ProductModel productModel;
    private TextView Title;
    private TextView ToolbarText;
    private TextView Desc;
    private TextView PrePrice;
    private TextView Price;
    private TextView userComment;
    private BannerSlider bannerSlider;
    private ImageView backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setUpView();

        Intent intent=getIntent();
        productModel= (ProductModel) intent.getSerializableExtra(PRODUCT_ID);


        Title.setText(productModel.getTitle());
        Desc.setText(productModel.getDescription());
        PrePrice.setText(productModel.getPrePrice());
        Price.setText(productModel.getPrice());
        ToolbarText.setText(productModel.getTitle());
        userComment.setText("A car is an item of footwear intended to protect and comfort the human foot. Shoes are also used as an item of decoration and fashion. The design of shoes has varied enormously through time and from culture to culture, with appearance originally being tied to function. Additionally, fashion has often dictated many design elements, such as whether shoes have very high heels or flat ones. Contemporary footwear in the 2010s varies widely in style, complexity and cost. Basic sandals may consist of only a thin sole and simple strap and be sold for a low cost. High fashion shoes made by famous designers may be made of expensive materials, use complex construction and sell for hundreds or even thousands of dollars a pair. Some shoes are designed for specific purposes, such as boots designed specifically for mountaineering or skiing");

    }



    private void setUpView() {

        Title=findViewById(R.id.PD_Title);
        Desc=findViewById(R.id.PD_Des);
        PrePrice=findViewById(R.id.PD_PrePrice);
        Price=findViewById(R.id.PD_Price);
        ToolbarText=findViewById(R.id.PD_TollbarText);
        userComment=findViewById(R.id.PD_UserComment);
        backButton=findViewById(R.id.PD_Backbutton);


        bannerSlider = findViewById(R.id.PD_Banner);
        List<Banner> banners = new ArrayList<>();
        RemoteBanner banner1 = new RemoteBanner("https://carmag.co.za/upload/articles/2020/03/837645339_5.jpg");
        RemoteBanner banner2 = new RemoteBanner("https://empirecityautoparts.com/wp-content/uploads/Alfa-Romeo_Tonale_red_hybrid-suv_desktop_720x404.jpg");
        RemoteBanner banner3 = new RemoteBanner("https://www.carmag.co.za/upload/articles/2020/03/837645339_1.jpg");
        banners.add(banner1);
        banners.add(banner2);
        banners.add(banner3);
        bannerSlider.setBanners(banners);



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


}