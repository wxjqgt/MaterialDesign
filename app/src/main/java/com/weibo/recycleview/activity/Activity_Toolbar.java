package com.weibo.recycleview.activity;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.weibo.recycleview.R;

import butterknife.BindView;

public class Activity_Toolbar extends BaseActivity {

    private void initData() {
        // 设置提示文本
        mTestTIL.setHint("请输入你的邮箱：");
        mTestET1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 10) {
                    // 设置错误提示
                    mTestTIL.setErrorEnabled(true);
                    mTestTIL.setError("邮箱名过长！");
                } else {
                    mTestTIL.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_toolbar;
    }

    @BindView(R.id.et_test1)
    EditText mTestET1;

    @BindView(R.id.til_test1)
    TextInputLayout mTestTIL;

}
