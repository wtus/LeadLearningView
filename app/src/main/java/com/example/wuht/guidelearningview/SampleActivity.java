package com.example.wuht.guidelearningview;

import com.example.wuht.guidelearningview.LeadLearning.LearningBuilder;

public class SampleActivity extends BaseActivity {


    @Override
    protected void initLeadView() {
        LearningBuilder builder = new LearningBuilder();
        builder.setmCorner(11)
                .setPadding(7)
                .setTargetView(mIvA1)
                .setDirectionViewId(R.layout.v_arrow)
                .setDirection(LearningBuilder.DIRECTION_DOWN)
        ;
        builder.create().show(this);

    }
}
