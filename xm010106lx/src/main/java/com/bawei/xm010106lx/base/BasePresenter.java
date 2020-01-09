package com.bawei.xm010106lx.base;

/**
 * author: 斛万珺
 * data: 2020/1/6 14:14:20
 * function:
 */
public abstract class BasePresenter<V> {

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

