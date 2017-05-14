package com.bwie.test.smartdroiddemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.test.smartdroiddemo.R;

/**
 * Created by tianjieyu on 2017/5/13.
 */

public class Item_2_ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView1;
    ImageView imageView2;
    TextView textView;

    public Item_2_ViewHolder(View itemView) {
        super(itemView);
        imageView1 = (ImageView) itemView.findViewById(R.id.item2_image1);
        imageView2 = (ImageView) itemView.findViewById(R.id.item2_image2);
        textView = (TextView) itemView.findViewById(R.id.item2_text);
    }
}
