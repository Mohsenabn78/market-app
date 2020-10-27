package com.example.marketapp.Model;

import com.google.gson.annotations.SerializedName;

public class ProductModel {
    @SerializedName("id")
    private String id;
    @SerializedName("Title")
    private String title;
    @SerializedName("Description")
    private String description;
    @SerializedName("Prepricea")
    private String prePrice;
    @SerializedName("Price")
    private String Price;
   // @SerializedName("Url")
    private String imageUrl;

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(String prePrice) {
        this.prePrice = prePrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
