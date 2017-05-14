package com.bwie.test.smartdroiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.test.smartdroiddemo.adapters.MyAdapter;
import com.bwie.test.smartdroiddemo.beans.CheckBean;
import com.bwie.test.smartdroiddemo.beans.JsonBean;
import com.bwie.test.smartdroiddemo.utils.OkUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text_1;
    private TextView text_2;
    private RecyclerView recycler;
    private Button button;
    private ArrayList<CheckBean> list;
public static final String url = "http://result.eolinker.com/X39jyd7dd8d690677289995f22d9d77fafd75839e51385e?uri=tt";
    private TextView text_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {

        list = new ArrayList<>();

        OkUtils.getEnqueue(url, null, new OkUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(result, JsonBean.class);
                List<JsonBean.ResultBean.DataBean> data = jsonBean.result.data;
                for (int i=0;i<data.size();i++){

                    list.add(new CheckBean(data.get(i).title,data.get(i).thumbnail_pic_s, false));

                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });



        LinearLayoutManager ma = new LinearLayoutManager(this);
        recycler.setLayoutManager(ma);
        final MyAdapter adapter = new MyAdapter(list,this);
        recycler.setAdapter(adapter);
        adapter.setmOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                list.get(position).setFlag(!list.get(position).isFlag());

            }
        });
        text_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i< list.size(); i++){
                    list.get(i).setFlag(true);
                }
                adapter.notifyDataSetChanged();
            }
        });
        text_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i< list.size(); i++){
                    list.get(i).setFlag(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
        text_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<list.size();i++){
                    if(list.get(i).isFlag()==true){
                        list.get(i).setFlag(false);
                    }else{
                        list.get(i).setFlag(true);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        text_1 = (TextView) findViewById(R.id.text_1);
        text_2 = (TextView) findViewById(R.id.text_2);
        text_3 = (TextView) findViewById(R.id.text_3);
        recycler = (RecyclerView) findViewById(R.id.recycler);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                ArrayList<CheckBean> checkBeen = new ArrayList<>();
                for (int i= 0;i<list.size();i++){
                    if (list.get(i).isFlag()==true){
                        checkBeen.add(list.get(i));
                    }
                }
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                intent.putParcelableArrayListExtra("checkBean",checkBeen);
                startActivity(intent);
                break;
        }
    }
}
