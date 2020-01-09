package com.bawei.huwangjun.presenter;

import com.bawei.huwangjun.base.BasePresenter;
import com.bawei.huwangjun.contract.IHomeContract;
import com.bawei.huwangjun.model.Bean.Bean;
import com.bawei.huwangjun.model.HomeModel;

/**
 * author: 斛万珺
 * data: 2020/1/6 09:9:37
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
