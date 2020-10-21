package com.example.marketapp.ApiService;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.example.marketapp.Model.ProductModel;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

public class GsonRequest<T> extends Request<T> {
    private static final String TAG = "ApiRequest";

    private Response.Listener<T> listener;
    private Type type;
    private Gson gson=new Gson();

    public GsonRequest(int method, String url, Response.Listener<T> listener, @Nullable Response.ErrorListener errorListener , Type type) {
        super(method, url, errorListener);
        this.listener=listener;
        this.type=type;

        setRetryPolicy(new DefaultRetryPolicy(5000,4,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String response_string =new String(response.data,"UTF-8");
            T result =gson.fromJson(response_string,type);

            return Response.success(result,null);

        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "parseNetworkResponse: "+e);

            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
