package com.example.wuht.guidelearningview.LeadLearning;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wuht on 2016/11/29.
 */

public class LeadControl {
    private LeadView mLeadView;
    private LearningBuilder.Configeration mConfiguration;
    public LeadControl() {
    }

    void setConfiguration(LearningBuilder.Configeration configeration) {
        mConfiguration = configeration;
    }

    public void show(Activity activity) {
        if (null == mLeadView && null != mConfiguration) {
            createLeadView(activity);
        }

        if (null == mLeadView.getParent()) {//防止重复
            ViewGroup vp = (ViewGroup) activity.getWindow().getDecorView();
            vp.addView(mLeadView);
            //动画
        }

    }

    private void createLeadView(Context context) {
        mLeadView = new LeadView(context);
        mLeadView.setTargetType(mConfiguration.targetType);
        mLeadView.setTargetRect(computeRect(mConfiguration.targetRect));
        mLeadView.setCorner(mConfiguration.mCorner);
        mLeadView.setDirection(mConfiguration.direction);
        mLeadView.addView(View.inflate(context, mConfiguration.directionViewId, null));
    }

    private Rect computeRect(Rect rect) {//设置了 padding  其他局部设置无效，一般就有个padding 就行了，特殊需求就别嫌麻烦
        if (mConfiguration.padding != 0) {
            rect.left -= mConfiguration.padding;
            rect.right += mConfiguration.padding;
            rect.bottom += mConfiguration.padding;
            rect.top -= mConfiguration.padding;
            return rect;
        }
        rect.left -= mConfiguration.paddingLeft;
        rect.right += mConfiguration.paddingRight;
        rect.bottom += mConfiguration.paddingBottom;
        rect.top -= mConfiguration.paddingTop;
        return rect;
    }

}
