package com.bawei.xm010106lx.presenter;

import com.bawei.xm010106lx.base.BasePresenter;
import com.bawei.xm010106lx.contract.IHomeContract;
import com.bawei.xm010106lx.model.HomeModel;
import com.bawei.xm010106lx.model.bean.Bean;

/**
 * author: 斛万珺
 * data: 2020/1/6 15:15:27
 * function:
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData(String keyword) {
        homeModel.getHomeData(keyword, new IHomeContract.IModel.IModelCallback() {
            @Override
            public void onHomeSuccess(Bean bean) {
                view.onHomeSuccess(bean);
            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                view.onHomeFailure(throwable);

            }
        });

    }
}
