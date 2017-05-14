package com.bwie.test.smartdroiddemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.test.smartdroiddemo.R;
import com.bwie.test.smartdroiddemo.beans.CheckBean;

import java.util.ArrayList;

/**
 * Created by tianjieyu on 2017/5/12.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<CheckBean> list;
    private Context context;

    public MyAdapter(ArrayList<CheckBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.checkBox.setFocusable(false);
        holder.itemView.setFocusable(true);
        Glide.with(context).load(list.get(position).getImgs()).crossFade().into(holder.imageView);
        holder.textView.setText(list.get(position).getText());
        holder.checkBox.setChecked(list.get(position).isFlag());
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView, position); // 2
                    holder.checkBox.setChecked(list.get(position).isFlag());
                    notifyDataSetChanged();
                }
            });
        }
        //长按判断
        if (mOnItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView, position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox;
        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }

    private OnItemClickListener mOnItemClickListener;
    //长按
    private OnItemLongClickListener mOnItemLongClickListener;

    //点击
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    //长按
    public void setmOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    //点击监听接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    //长按监听接口
    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

}
