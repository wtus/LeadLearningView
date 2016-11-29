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
    private int mDirection;
    private Rect mDirectionRect = new Rect();

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
            switch (mDirection) {
                case LearningBuilder.DIRECTION_DOWN:
                    mDirectionRect.top = (int) mTargetRect.bottom;
                    mDirectionRect.bottom = child.getMeasuredHeight() + mDirectionRect.top;

                    mDirectionRect.left = (int) (mTargetRect.width() / 2 - mDirectionRect.left / 2);
                    mDirectionRect.right = mDirectionRect.left + child.getMeasuredWidth();
                    mDirectionRect.offset((int) mTargetRect.left, 0);
                    break;
                case LearningBuilder.DIRECTION_UP:

                    break;
                case LearningBuilder.DIRECTION_LEFT:

                    break;
                case LearningBuilder.DIRECTION_RIGHT:

                    break;
            }
            child.layout(mDirectionRect.left, mDirectionRect.top, mDirectionRect.right, mDirectionRect.bottom);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        //super.dispatchDraw(canvas);
        final long drawingTime = getDrawingTime();//要这个干啥勒
        View child;
        for (int i = 0; i < getChildCount(); i++) {
            child = getChildAt(i);
            if (null != child) {
                drawChild(canvas, child, drawingTime);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBitmapCanvas.drawColor(mBgPaint.getColor());
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

    public void setTargetRect(Rect rect) {
        mTargetRect = new RectF(rect);
    }

    public void setCorner(int corner) {
        mCorner = corner;
    }

    public void setDirection(int direction) {
        mDirection = direction;
    }
}
