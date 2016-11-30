package com.example.wuht.guidelearningview;

import com.example.wuht.guidelearningview.LeadLearning.LearningBuilder;

public class Sample1Activity extends BaseActivity {


    @Override
    protected void initLeadView() {
        LearningBuilder builder = new LearningBuilder();
        builder.setTargetView(mIvA2)
                .setTargetType(LearningBuilder.SHAPE_CIRCLE)
                .setPadding(15)
                .setDirection(LearningBuilder.DIRECTION_UP)
                .setDirectionViewId(R.layout.v_sample_up);
        builder.create().show(this);

    }
}
