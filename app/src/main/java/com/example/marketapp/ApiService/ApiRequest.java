package com.example.marketapp.ApiService;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

public class ApiRequest<T> extends Request<T> {
    private static final String TAG = "ApiRequest";

    private Response.Listener<T> listener;
    private Type type;
    private Gson gson=new Gson();

    public ApiRequest(int method, String url, Response.Listener listener, @Nullable Response.ErrorListener errorListener , Type type) {
        super(method, url, errorListener);
        this.listener=listener;
        this.type=type;

        setRetryPolicy(new DefaultRetryPolicy(8000,3,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String string =new String(response.data,"UTF-8");
            T result =gson.fromJson(string,type);

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
