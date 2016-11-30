package com.example.wuht.guidelearningview.LeadLearning;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuht on 2016/11/29.
 */

public class LeadView extends ViewGroup {
    private Paint mBgPaint, mTargetPaint;
    private Bitmap mBitmap;
    private Canvas mBitmapCanvas;
    private RectF mTargetRect;
    private int mTargetType = LearningBuilder.SHAPE_ROUND_RECT;
    private int mCorner;
    private List<Integer> mDirectionList;
    private int mDirection = 5;
    private Rect mDirectionRect = new Rect();
    private List<RectF> mTargetRectList = new ArrayList<>();
    private int mIndex = 0;

    public LeadView(Context context) {
        super(context);
        setWillNotDraw(false);
        mBgPaint = new Paint();
        mTargetPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        initPaint(mBgPaint, Color.BLACK);
        initPaint(mTargetPaint, Color.TRANSPARENT);

        mBgPaint.setAlpha((int) (255 * 0.8f));
        mTargetPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));

        Point size = getPixel(context);
        mBitmap = Bitmap.createBitmap(size.x, size.y, Bitmap.Config.ARGB_8888);
        mBitmapCanvas = new Canvas(mBitmap);
    }

    @NonNull
    private Point getPixel(Context context) {
        Point size = new Point();
        size.x = context.getResources().getDisplayMetrics().widthPixels;
        size.y = context.getResources().getDisplayMetrics().heightPixels;
        return size;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        View child;
        for (int i = 0; i < getChildCount(); i++) {
            child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
        setMeasuredDimension(w, h);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        View child;
        for (int j = 0; j < getChildCount(); j++) {
            child = getChildAt(j);
            if (child.getVisibility() == GONE) {
                continue;
            }
            try {
                mDirection = mDirectionList.get(j);
            } catch (Exception e) {
                mDirection = 5;
            }
            switch (mDirection) {
                case LearningBuilder.DIRECTION_DOWN:
                    mDirectionRect.top = (int) mTargetRectList.get(j).bottom;
                    mDirectionRect.bottom = child.getMeasuredHeight() + mDirectionRect.top;

                    mDirectionRect.left = (int) (mTargetRectList.get(j).width() / 2 - child.getMeasuredWidth() / 2);
                    mDirectionRect.right = mDirectionRect.left + child.getMeasuredWidth();
                    mDirectionRect.offset((int) mTargetRectList.get(j).left, 0);
                    break;
                case LearningBuilder.DIRECTION_UP:
                    mDirectionRect.bottom = (int) mTargetRectList.get(j).top;
                    mDirectionRect.top = mDirectionRect.bottom - child.getMeasuredHeight();

                    mDirectionRect.left = (int) (mTargetRectList.get(j).width() / 2 - child.getMeasuredWidth() / 2);
                    mDirectionRect.right = mDirectionRect.left + child.getMeasuredWidth();
                    mDirectionRect.offset((int) mTargetRectList.get(j).left, 0);
                    break;
                case LearningBuilder.DIRECTION_LEFT:
                    mDirectionRect.right = (int) mTargetRectList.get(j).left;
                    mDirectionRect.left = mDirectionRect.right - child.getMeasuredWidth();

                    mDirectionRect.top = (int) (mTargetRectList.get(j).height() / 2 - child.getMeasuredHeight() / 2);
                    mDirectionRect.bottom = mDirectionRect.top + child.getMeasuredHeight();
                    mDirectionRect.offset(0, (int) mTargetRect.top);
                    break;
                case LearningBuilder.DIRECTION_RIGHT:
                    mDirectionRect.left = (int) mTargetRectList.get(j).right;
                    mDirectionRect.right = mDirectionRect.left + child.getMeasuredWidth();

                    mDirectionRect.top = (int) (mTargetRectList.get(j).height() / 2 - child.getMeasuredHeight() / 2);
                    mDirectionRect.bottom = mDirectionRect.top + child.getMeasuredHeight();
                    mDirectionRect.offset(0, (int) mTargetRect.top);
                    break;
            }
            child.layout(mDirectionRect.left, mDirectionRect.top, mDirectionRect.right, mDirectionRect.bottom);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        //super.dispatchDraw(canvas);
        final long drawingTime = getDrawingTime();//要这个干啥勒
        View child = getChildAt(mIndex);
        if (null != child) {
            drawChild(canvas, child, drawingTime);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBitmap.eraseColor(mBgPaint.getColor());
        mTargetPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        switch (mTargetType) {
            case LearningBuilder.SHAPE_CIRCLE:
                mBitmapCanvas.drawCircle(mTargetRect.centerX(), mTargetRect.centerY(), Math.max(mTargetRect.width(), mTargetRect.height()) / 2, mTargetPaint);
                break;
            case LearningBuilder.SHAPE_ROUND_RECT:
                mBitmapCanvas.drawRoundRect(mTargetRect, mCorner, mCorner, mTargetPaint);
                break;
        }
        mTargetPaint.setXfermode(null);
        canvas.drawBitmap(mBitmap, 0, 0, null);
    }

    private void initPaint(Paint paint, int color) {
        paint.setColor(color);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
    }


    public void setTargetType(int targetType) {
        mTargetType = targetType;
    }

    public void setTargetRect(List<RectF> rectList) {
        mTargetRectList = rectList;
        mTargetRect = rectList.get(0);
//        mTargetRect = new RectF(rect);
    }

    public void setCorner(int corner) {
        mCorner = corner;
    }


    public void setDirectionList(List<Integer> directionList) {
        mDirectionList = directionList;
        if (mDirectionList.size() == 0) {
            mDirection = 5;
        }
    }

    public void setNextChildIndex() {
        if (mIndex < 0 || mIndex >= getChildCount()) {
            return;
        }
        mIndex++;
        if (mIndex < mTargetRectList.size() && mIndex >= 0) {
            mTargetRect = mTargetRectList.get(mIndex);
        }
        if (mIndex < mDirectionList.size() && mIndex >= 0) {
            mDirection = mDirectionList.get(mIndex);
        } else {
            mDirection = 5;
        }
        invalidate();
    }
}
