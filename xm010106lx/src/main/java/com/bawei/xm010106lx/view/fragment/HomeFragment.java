package com.bawei.xm010106lx.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.xm010106lx.R;
import com.bawei.xm010106lx.base.BaseFragment;
import com.bawei.xm010106lx.contract.IHomeContract;
import com.bawei.xm010106lx.model.bean.Bean;
import com.bawei.xm010106lx.presenter.HomePresenter;

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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recy.setLayoutManager(gridLayoutManager);

        MyAdapter myAdapter = new MyAdapter(data);
        recy.setAdapter(myAdapter);
    }

    @Override
    public void onHomeFailure(Throwable throwable) {

    }
}
