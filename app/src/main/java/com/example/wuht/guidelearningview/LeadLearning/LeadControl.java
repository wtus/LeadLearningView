package com.example.wuht.guidelearningview.LeadLearning;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wuht on 2016/11/29.
 */

public class LeadControl implements View.OnClickListener {
    private LeadView mLeadView;
    private LearningBuilder.Configuration mConfiguration;
    private int performCount=1;

    public LeadControl() {
    }

    void setConfiguration(LearningBuilder.Configuration configuration) {
        mConfiguration = configuration;
    }


    public void show(Activity activity) {
        if (null == mLeadView && null != mConfiguration) {
            createLeadView(activity);
        }

        if (null == mLeadView.getParent()) {//防止重复
            ViewGroup vp = (ViewGroup) activity.getWindow().getDecorView();
            vp.addView(mLeadView);
            // TODO: 2016/11/30  进入动画
        }

        mLeadView.setOnClickListener(this);
    }

    public void dismiss(Activity activity) {
        if (null == mLeadView) {
            return;
        }
        if (mLeadView.getParent() == null) {
            return;
        }
        // TODO: 2016/11/30 退出动画
        try {
            ViewGroup vp = (ViewGroup) activity.getWindow().getDecorView();
            vp.removeView(mLeadView);
        } catch (Exception e) {
            Log.d("LeadControl", "e:" + e);
        }
    }

    private void createLeadView(Context context) {
        mLeadView = new LeadView(context);
        mLeadView.setTargetType(mConfiguration.targetType);
        mLeadView.setTargetRect(computeRect(mConfiguration.targetRectList));
        mLeadView.setCorner(mConfiguration.mCorner);
        mLeadView.setDirectionList(mConfiguration.direction);
        for (int i = 0; i < mConfiguration.directionViewId.size(); i++) {
            mLeadView.addView(View.inflate(context, mConfiguration.directionViewId.get(i), null));
        }
    }

    private List<RectF> computeRect(List<RectF> rectList) {//设置了 padding  其他局部设置无效，一般就有个padding 就行了，特殊需求就别嫌麻烦
        for (RectF rect : rectList) {
            if (mConfiguration.padding != 0) {
                rect.left -= mConfiguration.padding;
                rect.right += mConfiguration.padding;
                rect.bottom += mConfiguration.padding;
                rect.top -= mConfiguration.padding;
            } else {
                rect.left -= mConfiguration.paddingLeft;
                rect.right += mConfiguration.paddingRight;
                rect.bottom += mConfiguration.paddingBottom;
                rect.top -= mConfiguration.paddingTop;
            }
        }
        return rectList;
    }

    @Override
    public void onClick(View v) {
        if (performCount < mConfiguration.targetRectList.size()) {
            mLeadView.setNextChildIndex();
            performCount++;
        } else {
            dismiss((Activity) v.getContext());
        }
        //dismiss((Activity) v.getContext());
    }
}
