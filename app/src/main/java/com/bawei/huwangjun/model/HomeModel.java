package com.bawei.huwangjun.model;

import com.bawei.huwangjun.contract.IHomeContract;
import com.bawei.huwangjun.model.Bean.Bean;
import com.bawei.huwangjun.util.NetUtil;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * author: 斛万珺
 * data: 2020/1/6 09:9:37
 * function:
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(String keyword, final IModelCallback iModelCallback) {
        try {
            String encode = URLEncoder.encode(keyword, "UTF-8");
            NetUtil.getInstance().getJsonGet("http://blog.zhaoliang5156.cn/baweiapi/shopping?&kword="+encode, new NetUtil.MyCallback() {
                @Override
                public void onSuccess(String json) {
                    Bean bean = new Gson().fromJson(json, Bean.class);
                    iModelCallback.onHomeSuccess(bean);
                }

                @Override
                public void onError(Throwable throwable) {
                    iModelCallback.onHomeFailure(throwable);

                }
            });

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        }
}
