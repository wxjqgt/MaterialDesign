package com.weibo.recycleview.activity;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weibo.recycleview.R;
import com.weibo.recycleview.recyclerView.CommonAdapter;
import com.weibo.recycleview.recyclerView.ItemCallback;
import com.weibo.recycleview.recyclerView.OnRecyclerViewItemClickListener;
import com.weibo.recycleview.recyclerView.ViewHolder;
import com.weibo.recycleview.snackBar.SnackBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class Activity_BottomSheet extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.stateCrol)
    public void onclick(View view){
        switch (view.getId()){
            case R.id.stateCrol:
                intro();
                break;
            default:
                break;
        }
    }

    private void intro(){
       /* BottomSheetBehavior behavior = BottomSheetBehavior.from(scrollView);
        if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }else {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }*/

        RecyclerView recyclerView = new RecyclerView(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        recyclerView.setLayoutParams(layoutParams);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<String> datas = new ArrayList<>();
        for (int i = 0;i < 50; i++){
            datas.add("item" + i);
        }
        CommonAdapter commonAdapter = new CommonAdapter<String>(this,R.layout.tv,datas) {
            @Override
            public void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv,s);
            }
        };
        recyclerView.setAdapter(commonAdapter);

        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(recyclerView);
        dialog.show();
        recyclerView.addOnItemTouchListener(new OnRecyclerViewItemClickListener(recyclerView) {
            @Override
            public void OnItemClickLitener(RecyclerView.ViewHolder viewHolder) {
                SnackBarUtil.ShortSnackbar(stateCrol,datas.get(viewHolder.getAdapterPosition()),SnackBarUtil.Alert);
                dialog.dismiss();
            }

            @Override
            public void OnItemLongClickLitener(RecyclerView.ViewHolder viewHolder) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bottom_sheet;
    }

    @BindView(R.id.stateCrol)
    Button stateCrol;

    @BindView(R.id.scroll)
    NestedScrollView scrollView;

}
