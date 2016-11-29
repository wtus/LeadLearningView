package com.example.wuht.guidelearningview.LeadLearning;

import android.graphics.Rect;
import android.support.annotation.IntDef;
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


    public LearningBuilder setTargetType(int targetType) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.targetType = targetType;
        return this;

    }

    public LearningBuilder setTargetView(View v) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        } else if (v == null) {
            throw new NullPointerException("TargetView is null");
        }
        // assert false : "";//貌似不行啊
         v.getGlobalVisibleRect(mConfigeration.targetRect);
        return this;
    }

    public LearningBuilder setPadding(int padding) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.padding = padding;
        return this;
    }

    public LearningBuilder setPaddingLeft(int paddingLeft) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.paddingLeft = paddingLeft;
        return this;
    }

    public LearningBuilder setPaddingRight(int paddingRight) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.paddingRight = paddingRight;
        return this;
    }

    public LearningBuilder setPaddingTop(int paddingTop) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.paddingTop = paddingTop;
        return this;
    }

    public LearningBuilder setPaddingBottom(int paddingBottom) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.paddingBottom = paddingBottom;
        return this;
    }

    public LearningBuilder setmTargetViewId(int mTargetViewId) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.mTargetViewId = mTargetViewId;
        return this;
    }

    public LearningBuilder setmCorner(int mCorner) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.mCorner = mCorner;
        return this;
    }

    public LearningBuilder setmFullingColorId(int mFullingColorId) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.mFullingColorId = mFullingColorId;
        return this;
    }

    public LearningBuilder setmAutoDismiss(boolean mAutoDismiss) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.mAutoDismiss = mAutoDismiss;
        return this;
    }

    public LearningBuilder setmEnterAnimationId(int mEnterAnimationId) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.mEnterAnimationId = mEnterAnimationId;
        return this;
    }

    public LearningBuilder setmExitAnimationId(int mExitAnimationId) throws Exception {
        if (mBuilt) {
            throw new Exception("Already created. rebuild a new one.");
        }
        mConfigeration.mExitAnimationId = mExitAnimationId;
        return this;
    }

    public LeadControl create() {
        LeadControl control=new LeadControl();
        control.setConfiguration(mConfigeration);
        return control;
    }


    class Configeration {
        public int targetType;
        public Rect targetRect;
        public int padding = 0;
        public int paddingLeft = 0;
        public int paddingRight = 0;
        public int paddingTop = 0;
        public int paddingBottom = 0;
        public int mTargetViewId = -1;//目标View 的Id
        public int mCorner = 0;
        public int mFullingColorId = android.R.color.black;
        public boolean mAutoDismiss = true;
        public int mEnterAnimationId = -1;
        public int mExitAnimationId = -1;

    }

    @IntDef({SHAPE_ROUND_RECT, SHAPE_CIRCLE})
    public @interface RevealType {
    }

    public static final int SHAPE_ROUND_RECT = 0;
    public static final int SHAPE_CIRCLE = 0;
}
