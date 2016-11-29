package com.example.wuht.guidelearningview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.wuht.guidelearningview.LeadLearning.LeadView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_test;
    private RelativeLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_test = (Button) findViewById(R.id.btn_test);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);

        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
              //  ViewGroup vp = (ViewGroup) findViewById(android.R.id.content);
                ViewGroup vp = (ViewGroup) this.getWindow().getDecorView();//这个直接全屏了啊
                vp.addView(new LeadView(this));
                break;
        }
    }
}
