package com.example.wuht.guidelearningview;

import com.example.wuht.guidelearningview.LeadLearning.LearningBuilder;

public class Sample2Activity extends BaseActivity {


    @Override
    protected void initLeadView() {
        LearningBuilder builder = new LearningBuilder();
        builder.setmCorner(11)
                .setPadding(7)
                .setTargetView(mIvA1, mBtnA1)
                .setTargetType(LearningBuilder.SHAPE_ROUND_RECT)
                .setDirectionViewId(R.layout.v_sample_right, R.layout.v_sample_down)
                .setDirection(LearningBuilder.DIRECTION_RIGHT, LearningBuilder.DIRECTION_DOWN)
        ;
        builder.create().show(this);
    }
}
