package com.bawei.huwangjun.base;

/**
 * author: 斛万珺
 * data: 2020/1/6 09:9:05
 * function:
 */
public abstract class BasePresenter<V> {
//P层封装
    protected V view;

    public void attach(V view){
        this.view=view;
    }

    public void detach(){
        view=null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
