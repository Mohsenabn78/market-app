package com.example.marketapp.ApiService;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.marketapp.Model.ProductModel;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ApiService {
    private static final String TAG = "ApiService";
    private Context context;

    public ApiService(Context context){
        this.context=context;
    }


    public void getProduct(int Method, String Url, Response.Listener<ArrayList<ProductModel>> listener, Response.ErrorListener errorListener, Type type){

        GsonRequest<ArrayList<ProductModel>> gsonRequest=new GsonRequest(Method,Url,listener,errorListener,type);

        Volley.newRequestQueue(context).add(gsonRequest);

    }


}
