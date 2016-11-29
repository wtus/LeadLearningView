package com.example.wuht.guidelearningview.LeadLearning;

import android.graphics.Rect;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by wuht on 2016/11/29.
 */

public class LearningBuilder {
    private Configeration mConfigeration;
    private boolean mBuilt = false;

    public LearningBuilder() {
        mConfigeration = new Configeration();
    }


    public LearningBuilder setTargetType(@TargetType int targetType) {
        mConfigeration.targetType = targetType;
        return this;
    }

    public LearningBuilder setTargetView(View v) {
        //assert true : "fsdafsa";//貌似不行啊，只能在单元测试里使用吗
        if (v == null) {
            throw new NullPointerException("TargetView is null");
        }
        v.getGlobalVisibleRect(mConfigeration.targetRect);
        return this;
    }

    public LearningBuilder setPadding(int padding) {
        mConfigeration.padding = padding;
        return this;
    }

    public LearningBuilder setPaddingLeft(int paddingLeft) {
        mConfigeration.paddingLeft = paddingLeft;
        return this;
    }

    public LearningBuilder setPaddingRight(int paddingRight) {
        mConfigeration.paddingRight = paddingRight;
        return this;
    }

    public LearningBuilder setPaddingTop(int paddingTop) {
        mConfigeration.paddingTop = paddingTop;
        return this;
    }

    public LearningBuilder setPaddingBottom(int paddingBottom) {
        mConfigeration.paddingBottom = paddingBottom;
        return this;
    }

    public LearningBuilder setmTargetViewId(int mTargetViewId) {
        mConfigeration.mTargetViewId = mTargetViewId;
        return this;
    }

    public LearningBuilder setmCorner(int mCorner) {
        mConfigeration.mCorner = mCorner;
        return this;
    }

    public LearningBuilder setmFullingColorId(int mFullingColorId) {
        mConfigeration.mFullingColorId = mFullingColorId;
        return this;
    }

    public LearningBuilder setmAutoDismiss(boolean mAutoDismiss) {
        mConfigeration.mAutoDismiss = mAutoDismiss;
        return this;
    }

    public LearningBuilder setmEnterAnimationId(int mEnterAnimationId) {
        mConfigeration.mEnterAnimationId = mEnterAnimationId;
        return this;
    }

    public LearningBuilder setmExitAnimationId(int mExitAnimationId) {
        mConfigeration.mExitAnimationId = mExitAnimationId;
        return this;
    }

    public LearningBuilder addDirection(@LayoutRes int layoutId) {
        return addDirection(layoutId, DIRECTION_DOWN);
    }

    public LearningBuilder addDirection(@LayoutRes int layoutId, @Direction int direction) {
        mConfigeration.direction = direction;
        mConfigeration.directionViewId = layoutId;
        return this;
    }


    public LeadControl create() {
        LeadControl control = new LeadControl();
        control.setConfiguration(mConfigeration);
        return control;
    }


    public class Configeration {
        public int targetType;
        public Rect targetRect = new Rect();
        public int padding = 0;
        public int paddingLeft = 0;
        public int paddingRight = 0;
        public int paddingTop = 0;
        public int paddingBottom = 0;
        public int mTargetViewId = -1;//目标View 的Id
        public int mCorner = 10;
        public int mFullingColorId = android.R.color.black;
        public boolean mAutoDismiss = true;
        public int mEnterAnimationId = -1;
        public int mExitAnimationId = -1;
        public int directionViewId = -1;
        public int direction = -1;

    }

    @IntDef({SHAPE_ROUND_RECT, SHAPE_CIRCLE})
    public @interface TargetType {
    }

    @IntDef({DIRECTION_UP, DIRECTION_LEFT, DIRECTION_RIGHT, DIRECTION_DOWN})
    public @interface Direction {
    }

    public static final int SHAPE_ROUND_RECT = 0;
    public static final int SHAPE_CIRCLE = 1;

    public static final int DIRECTION_UP = 2;
    public static final int DIRECTION_LEFT = 3;
    public static final int DIRECTION_RIGHT = 4;
    public static final int DIRECTION_DOWN = 5;

}
