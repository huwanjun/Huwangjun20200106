package com.bawei.huwangjun.contract;

import com.bawei.huwangjun.model.Bean.Bean;

/**
 * author: 斛万珺
 * data: 2020/1/6 09:9:40
 * function:
 */
public interface IHomeContract {
    //契约类

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
