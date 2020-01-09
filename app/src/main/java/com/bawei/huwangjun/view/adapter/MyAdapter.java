package com.bawei.huwangjun.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.huwangjun.R;
import com.bawei.huwangjun.model.Bean.Bean;
import com.bawei.huwangjun.util.NetUtil;

import java.util.List;

/**
 * author: 斛万珺
 * data: 2020/1/6 10:10:16
 * function:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bean.DataBean> data;

    public MyAdapter(List<Bean.DataBean> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.item_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.text_name.setText(data.get(i).getGoods_name());
        String goods_thumb = data.get(i).getGoods_thumb();
        NetUtil.getInstance().getPhoto(goods_thumb,myViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text_name;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name=itemView.findViewById(R.id.text_name);
            img=itemView.findViewById(R.id.img);
        }
    }
}
