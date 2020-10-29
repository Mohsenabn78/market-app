package com.example.marketapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//@ParcelablePlease
public class ProductModel implements Serializable {

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



    //parcelable

    /*

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
       // ProductModel.writeToParcel(this, dest, flags);
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.prePrice);
        dest.writeString(this.Price);
        dest.writeString(this.imageUrl);
    }



    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        public ProductModel createFromParcel(Parcel source) {
            ProductModel target = new ProductModel();
          //  ProductModel.readFromParcel(target, source);
            return target;
        }

        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };



     */
}



