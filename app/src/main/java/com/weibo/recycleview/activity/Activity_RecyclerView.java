package com.weibo.recycleview.activity;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.TextView;

import com.weibo.recycleview.R;
import com.weibo.recycleview.recyclerView.CommonAdapter;
import com.weibo.recycleview.recyclerView.HeaderdAndFooterWrapper;
import com.weibo.recycleview.recyclerView.ItemCallback;
import com.weibo.recycleview.recyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Activity_RecyclerView extends AppCompatActivity {

    private Unbinder unbinder;

    @BindView(R.id.headerandfooter)
    RecyclerView headerandfooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        initRe();
    }

    private void initRe() {
        headerandfooter.setLayoutManager(new LinearLayoutManager(this));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(String.valueOf(i));
        }
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(this, R.layout.layout, list) {
            @Override
            public void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.text, s);
            }
        };
        HeaderdAndFooterWrapper headerdAndFooterWrapper = new HeaderdAndFooterWrapper(commonAdapter);
        TextView textView1 = new TextView(this);
        textView1.setText("我是大帅哥");
        headerdAndFooterWrapper.addHearderView(textView1);
        headerandfooter.setAdapter(headerdAndFooterWrapper);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemCallback(list));
        itemTouchHelper.attachToRecyclerView(headerandfooter);

        //用于过滤掉不想要的长按开始拖拽事件
        //itemTouchHelper.startDrag(holder);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
