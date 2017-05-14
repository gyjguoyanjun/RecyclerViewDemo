package com.bwie.test.smartdroiddemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bwie.test.smartdroiddemo.R;
import com.bwie.test.smartdroiddemo.beans.CheckBean;

import java.util.ArrayList;

/**
 * Created by tianjieyu on 2017/5/13.
 */

public class MyNextAdapter extends RecyclerView.Adapter {
    private ArrayList<CheckBean> list;
    private Context context;

    public MyNextAdapter(ArrayList<CheckBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_3_layout, parent,false);
                holder = new Item_3_ViewHolder(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_2_layout, parent,false);
                holder = new Item_2_ViewHolder(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_4_layout, parent,false);
                holder = new Item_4_ViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        int i = position%3;
        switch (i){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case 0:
                Item_3_ViewHolder holder1 = (Item_3_ViewHolder)holder;
                Glide.with(context).load(list.get(position).getImgs()).into(holder1.imageView);
                holder1.textView.setText(list.get(position).getText());
                break;
            case 1:
                Item_2_ViewHolder holder2 = (Item_2_ViewHolder)holder;
                Glide.with(context).load(list.get(position).getImgs()).into(holder2.imageView2);
                holder2.textView.setText(list.get(position).getText());
                Glide.with(context).load(list.get(position).getImgs()).into(holder2.imageView1);

                break;
            case 2:
                Item_4_ViewHolder holder3 = (Item_4_ViewHolder)holder;
                Glide.with(context).load(list.get(position).getImgs()).into(holder3.imageView);
                holder3.textView.setText(list.get(position).getText());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
