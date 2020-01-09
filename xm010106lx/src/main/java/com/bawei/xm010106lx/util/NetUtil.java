package com.bawei.xm010106lx.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.xm010106lx.App;
import com.bawei.xm010106lx.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Util;

import java.net.PortUnreachableException;
import java.util.Map;

/**
 * author: 斛万珺
 * data: 2020/1/6 15:15:04
 * function:
 */
public class NetUtil {

    private static NetUtil netUtil;
    private final RequestQueue requestQueue;

    private NetUtil(){
        requestQueue = Volley.newRequestQueue(App.app);
    }
    public static NetUtil getInstance(){
        if (netUtil==null){
            synchronized (NetUtil.class){
                if (netUtil==null){

                    netUtil=new NetUtil();
                }
            }
        }
        return netUtil;
    }

    public boolean getNet( ){

        ConnectivityManager manager=(ConnectivityManager) App.app.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }

    public void getJsonGet(final String httpUrl, final MyCallback myCallback){

        boolean util=getNet();
        if(!util){
            CacheUtil instance = CacheUtil.getInstance();
            String cache = instance.getCache(httpUrl);
            if(cache!=null){
                myCallback.onSuccess(cache);
            }
        }


        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CacheUtil cacheUtil = CacheUtil.getInstance();
                cacheUtil.saveCache(httpUrl,response);
                myCallback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                myCallback.onError(error);
            }
        });
        requestQueue.add(stringRequest);
    }

    public void getJsonPost(String httpUrl, final Map<String,String> map, final MyCallback myCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                myCallback.onError(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void getPhoto(String photoUrl, ImageView imageView) {
        Glide.with(imageView).load(photoUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25)))
                .into(imageView);
    }

    public interface MyCallback{

        void onSuccess(String json);
        void onError(Throwable throwable);
    }
}
