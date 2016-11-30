package com.example.wuht.guidelearningview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by wuht on 2016/11/30.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected ImageView mIvA1;
    protected ImageView mIvA2;
    protected ImageView mIvA3;
    protected Button mBtnA1;
    protected RelativeLayout mActivityMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        initLeadView();
    }

    protected abstract void initLeadView();

    private void initView() {
        mIvA1 = (ImageView) findViewById(R.id.iv_A1);
        mIvA2 = (ImageView) findViewById(R.id.iv_A2);
        mIvA3 = (ImageView) findViewById(R.id.iv_A3);
        mBtnA1 = (Button) findViewById(R.id.btn_A1);
        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);

        mBtnA1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_A1:

                break;
        }
    }
}
