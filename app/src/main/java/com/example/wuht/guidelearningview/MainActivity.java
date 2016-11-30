package com.example.wuht.guidelearningview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.wuht.guidelearningview.LeadLearning.LearningBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_test;
    private RelativeLayout activity_main;
    private Button btn_test1;
    private Button btn_test2;
    private Button btn_test3;
    private Button btn_test4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLearningView();
    }

    private void initLearningView() {
        LearningBuilder builder = new LearningBuilder();
    }

    private void initView() {
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_test1 = (Button) findViewById(R.id.btn_test1);
        btn_test.setOnClickListener(this);
        btn_test1.setOnClickListener(this);
        btn_test2 = (Button) findViewById(R.id.btn_test2);
        btn_test2.setOnClickListener(this);
        btn_test3 = (Button) findViewById(R.id.btn_test3);
        btn_test3.setOnClickListener(this);
        btn_test4 = (Button) findViewById(R.id.btn_test4);
        btn_test4.setOnClickListener(this);
        
        btn_test3.setVisibility(View.GONE);
        btn_test4.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                startActivity(new Intent(MainActivity.this, SampleActivity.class));
                break;
            case R.id.btn_test1:
                startActivity(new Intent(MainActivity.this, Sample1Activity.class));
                break;
            case R.id.btn_test2:
                startActivity(new Intent(MainActivity.this, Sample2Activity.class));
                break;
            case R.id.btn_test3:
                break;
            case R.id.btn_test4:
                break;
        }
    }
}
