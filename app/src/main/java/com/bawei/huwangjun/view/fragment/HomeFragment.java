package com.bawei.huwangjun.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.huwangjun.R;
import com.bawei.huwangjun.base.BaseFragment;
import com.bawei.huwangjun.base.BasePresenter;
import com.bawei.huwangjun.contract.IHomeContract;
import com.bawei.huwangjun.model.Bean.Bean;
import com.bawei.huwangjun.presenter.HomePresenter;
import com.bawei.huwangjun.view.adapter.MyAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {

private RecyclerView recy;
    @Override
    protected void initView(View inflate) {

        recy=inflate.findViewById(R.id.recy);
    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

       mPresenter.getHomeData("推荐");
    }

    @Override
    public void onHomeSuccess(Bean bean) {

        List<Bean.DataBean> data = bean.getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recy.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(data);
        recy.setAdapter(myAdapter);

    }

    @Override
    public void onHomeFailure(Throwable throwable) {


    }
}
