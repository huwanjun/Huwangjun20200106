package com.bawei.xm010106lx.util;

import android.content.SharedPreferences;

import com.bawei.xm010106lx.App;

/**
 * author: 斛万珺
 * data: 2020/1/6 18:18:15
 * function:
 */
public class CacheUtil {

    private static CacheUtil cacheUtil;
    private CacheUtil() {

    }

    public static CacheUtil getInstance() {
        if(cacheUtil==null){
            cacheUtil=new CacheUtil();
        }
        return cacheUtil;
    }
    //存
    public void saveCache(String url,String json){
        SharedPreferences sharedPreferences =  App.app.getSharedPreferences("sp_name", App.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(url,json);
        edit.commit();
    }
    //取
    public String getCache(String url){
        SharedPreferences sharedPreferences=App.app.getSharedPreferences("sp_name",App.MODE_PRIVATE);
        String url1 = sharedPreferences.getString("url", "");
        return url1;
    }
}
