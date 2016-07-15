package com.weibo.recycleview;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.weibo.recycleview.recyclerView.CommonAdapter;
import com.weibo.recycleview.recyclerView.HeaderdAndFooterWrapper;
import com.weibo.recycleview.recyclerView.OnRecyclerViewItemClickListener;
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
        headerandfooter.setLayoutManager(new GridLayoutManager(this, 2));
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
        TextView textView = new TextView(this);
        textView.setText("我是韦大帅");
        TextView textView1 = new TextView(this);
        textView1.setText("我是大帅哥");
        headerdAndFooterWrapper.addHearderView(textView);
        headerdAndFooterWrapper.addHearderView(textView1);
        headerandfooter.setAdapter(headerdAndFooterWrapper);

        headerandfooter.addOnItemTouchListener(new OnRecyclerViewItemClickListener(headerandfooter) {
            @Override
            public void OnItemClickLitener(RecyclerView.ViewHolder viewHolder) {
                Snackbar.make(headerandfooter, "OnItemClickLitener", Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void OnItemLongClickLitener(RecyclerView.ViewHolder viewHolder) {
                Snackbar.make(headerandfooter, "OnItemLongClickLitener", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
