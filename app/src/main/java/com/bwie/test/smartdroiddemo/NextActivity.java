package com.bwie.test.smartdroiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.test.smartdroiddemo.adapters.MyNextAdapter;
import com.bwie.test.smartdroiddemo.beans.CheckBean;

import java.util.ArrayList;

public class NextActivity extends AppCompatActivity {


    private RecyclerView next_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        ArrayList<CheckBean> checkBean = intent.getParcelableArrayListExtra("checkBean");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        next_recycler.setLayoutManager(manager);
        MyNextAdapter adapter = new MyNextAdapter(checkBean,this);
        next_recycler.setAdapter(adapter);
    }

    private void initView() {

        next_recycler = (RecyclerView) findViewById(R.id.next_recycler);
    }
}
