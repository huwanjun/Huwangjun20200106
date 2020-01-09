package com.bawei.xm010106lx.contract;

import com.bawei.xm010106lx.model.bean.Bean;

/**
 * author: 斛万珺
 * data: 2020/1/6 15:15:04
 * function:
 */
public interface IHomeContract {

    interface IView{
        void onHomeSuccess(Bean bean);
        void onHomeFailure(Throwable throwable);
    }

    interface IPresenter{

       void getHomeData(String keyword);

    }

    interface IModel{

        void getHomeData(String keyword,IModelCallback iModelCallback);
        interface IModelCallback{
            void onHomeSuccess(Bean bean);
            void onHomeFailure(Throwable throwable);
        }
    }
}
