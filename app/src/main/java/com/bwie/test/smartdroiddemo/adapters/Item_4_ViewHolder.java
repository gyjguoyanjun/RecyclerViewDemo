package com.bwie.test.smartdroiddemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.test.smartdroiddemo.R;

/**
 * Created by tianjieyu on 2017/5/13.
 */

public class Item_4_ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public Item_4_ViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.item4_image);
        textView = (TextView) itemView.findViewById(R.id.item4_text);
    }
}
