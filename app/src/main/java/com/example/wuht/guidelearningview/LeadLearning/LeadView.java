package com.example.wuht.guidelearningview.LeadLearning;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.ViewGroup;

/**
 * Created by wuht on 2016/11/29.
 */

public class LeadView extends ViewGroup {
    private Paint mBgPaint, mTargetPaint;

    public LeadView(Context context) {
        super(context);
        setWillNotDraw(false);
        mBgPaint = new Paint();
        mTargetPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        initPaint(mBgPaint, Color.BLACK);
        initPaint(mTargetPaint, Color.TRANSPARENT);

        mBgPaint.setAlpha((int) (255 * 0.8f));
        mTargetPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(mBgPaint.getColor());
        canvas.drawCircle(0,0,1001,mTargetPaint);
    }

    private void initPaint(Paint paint, int color) {
        paint.setColor(color);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
    }
}
