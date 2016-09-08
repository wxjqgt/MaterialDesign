package com.weibo.recycleview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weibo.recycleview.R;
import com.weibo.recycleview.flexBox.TagAdapter;
import com.weibo.recycleview.flexBox.TagFlowLayout;

import butterknife.BindView;

public class Activity_FlexBox extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInflater = LayoutInflater.from(this);

        tagFlowLayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            protected View getView(ViewGroup parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv, parent, false);
                tv.setText(s);
                return tv;
            }

            @Override
            protected void onSelect(ViewGroup parent, View view, int position) {
                //view.setBackgroundResource(R.drawable.checked_bg);
            }

            @Override
            protected void onUnSelect(ViewGroup parent, View view, int position) {
                //view.setBackgroundResource(R.drawable.normal_bg);
            }

            //            @Override
//            protected boolean select(int position)
//            {
////                if (position == 0) return true;
//
//                return super.select(position);
//            }

        });

//        tagFlowLayout.setJustifyContent(FlexboxLayout.JUSTIFY_CONTENT_CENTER);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_flex_box;
    }


    @BindView(R.id.id_tagFlowLayout)
    TagFlowLayout tagFlowLayout;

    LayoutInflater mInflater;

    private String[] mVals = new String[]{
            "Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
            "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
            "Android", "Weclome Hello", "Button Text", "TextView"
    };

}
