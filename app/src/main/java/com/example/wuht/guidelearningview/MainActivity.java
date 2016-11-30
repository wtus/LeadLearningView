package com.example.wuht.guidelearningview;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                LearningBuilder builder = new LearningBuilder();
                builder.setTargetView(v, btn_test1)
                        .setTargetType(LearningBuilder.SHAPE_ROUND_RECT)
                        .setDirectionViewId(R.layout.v_arrow, R.layout.v_arrow)
                        .setDirection(LearningBuilder.DIRECTION_DOWN, LearningBuilder.DIRECTION_UP)
                        .setPadding(10);
                builder.create().show(this);
                break;
        }
    }
}
