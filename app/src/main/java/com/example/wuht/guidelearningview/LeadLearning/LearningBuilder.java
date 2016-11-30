package com.example.wuht.guidelearningview.LeadLearning;

import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuht on 2016/11/29.
 */

public class LearningBuilder {
    private Configuration mConfiguration;
    private boolean mBuilt = false;

    public LearningBuilder() {
        mConfiguration = new Configuration();
    }


    public LearningBuilder setTargetType(@TargetType int targetType) {
        mConfiguration.targetType = targetType;
        return this;
    }

    public LearningBuilder setTargetView(View... views) {
        //assert true : "fsdafsa";//貌似不行啊，只能在单元测试里使用吗
        Rect rect = new Rect();
        for (View v : views) {
            if (v == null) {
                throw new NullPointerException("TargetView is null");
            }
            v.getGlobalVisibleRect(rect);
            mConfiguration.targetRectList.add(new RectF(rect));
        }
        return this;
    }

    public LearningBuilder setPadding(int padding) {
        mConfiguration.padding = padding;
        return this;
    }

    public LearningBuilder setPaddingLeft(int paddingLeft) {
        mConfiguration.paddingLeft = paddingLeft;
        return this;
    }

    public LearningBuilder setPaddingRight(int paddingRight) {
        mConfiguration.paddingRight = paddingRight;
        return this;
    }

    public LearningBuilder setPaddingTop(int paddingTop) {
        mConfiguration.paddingTop = paddingTop;
        return this;
    }

    public LearningBuilder setPaddingBottom(int paddingBottom) {
        mConfiguration.paddingBottom = paddingBottom;
        return this;
    }

    public LearningBuilder setmTargetViewId(int mTargetViewId) {
        mConfiguration.mTargetViewId = mTargetViewId;
        return this;
    }

    public LearningBuilder setmCorner(int mCorner) {
        mConfiguration.mCorner = mCorner;
        return this;
    }

    public LearningBuilder setmFullingColorId(int mFullingColorId) {
        mConfiguration.mFullingColorId = mFullingColorId;
        return this;
    }

    public LearningBuilder setmAutoDismiss(boolean mAutoDismiss) {
        mConfiguration.mAutoDismiss = mAutoDismiss;
        return this;
    }

    public LearningBuilder setmEnterAnimationId(int mEnterAnimationId) {
        mConfiguration.mEnterAnimationId = mEnterAnimationId;
        return this;
    }

    public LearningBuilder setmExitAnimationId(int mExitAnimationId) {
        mConfiguration.mExitAnimationId = mExitAnimationId;
        return this;
    }

/*    public LearningBuilder addDirection(@LayoutRes int layoutId) {
        return addDirection(layoutId, DIRECTION_DOWN);
    }

    public LearningBuilder addDirection(@LayoutRes int layoutId, @Direction int direction) {
        mConfiguration.direction = direction;
        mConfiguration.directionViewId = layoutId;
        return this;
    }*/

    public LearningBuilder setDirectionViewId(@LayoutRes int... layoutId) {
        //mConfiguration.direction = direction;
        for (int id : layoutId) {
            mConfiguration.directionViewId.add(id);
        }
        return this;
    }

    public LearningBuilder setDirection(@Direction int... direction) {
        //mConfiguration.direction = direction;
        for (int d : direction) {
            mConfiguration.direction.add(d);
        }
        return this;
    }


    public LeadControl create() {
        LeadControl control = new LeadControl();
        control.setConfiguration(mConfiguration);
        return control;
    }


    public class Configuration {
        public int targetType = SHAPE_ROUND_RECT;
        public List<RectF> targetRectList = new ArrayList<>();
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
        public List<Integer> directionViewId = new ArrayList<>();
        public List<Integer> direction = new ArrayList<>();

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
