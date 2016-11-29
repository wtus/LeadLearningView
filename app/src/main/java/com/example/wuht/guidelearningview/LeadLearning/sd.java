/*
package com.example.wuht.waveview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

*/
/**
 * Created by wuht on 2016/9/20.
 *//*

public class WaveView extends View {

    private int mWidth, mHeight;
    private Paint mWavePaint, mTextPaint, mCirclePaint;
    private int mWaveHeight;
    private Point pA, pD, pCenter;
    private Path mPath;
    private Rect mTextBound;

    private Bitmap mBitmap;
    private Canvas mBitmapCanvas;

    public WaveView(Context context) {
        this(context, null);
        init();
    }

    public WaveView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mWavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mWavePaint.setStyle(Paint.Style.FILL);
        mWavePaint.setColor(Color.LTGRAY);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(48);

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(Color.DKGRAY);


        pA = new Point(0, mHeight);
        pD = new Point(mWidth, mHeight);
        pCenter = new Point(mWidth / 2, mHeight / 2);

        mPath = new Path();

        mWaveHeight = mHeight;
        mTextBound = new Rect();

        mBitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
        mBitmapCanvas = new Canvas(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mWaveHeight -= 3;
        float persent = mWaveHeight / (float) mHeight;
        mBitmap.eraseColor(Color.parseColor("#00000000"));//不一定要
        mBitmapCanvas.drawCircle(mWidth / 2, mHeight / 2, mWidth/2, mCirclePaint);

        mWavePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        drawPath(mBitmapCanvas);
        mWavePaint.setXfermode(null);

        drawText(mBitmapCanvas, persent);
        if (mWaveHeight <= 0) {
            mWaveHeight = mHeight;
        }
        mBitmapCanvas.drawLine(0,mHeight/2,mWidth,mHeight/2,mCirclePaint);
        mBitmapCanvas.drawLine(mWidth/2,0,mWidth/2,mHeight,mCirclePaint);
        canvas.drawBitmap(mBitmap, 0, 0, null);
        invalidate();
    }

    private void drawText(Canvas canvas, float persent) {
        String str = (int) ((1 - persent) * 100) + "%";
        mTextPaint.getTextBounds(str, 0, str.length(), mTextBound);

        canvas.drawText(str, mWidth / 2 - mTextBound.width() / 2, mHeight / 2 + mTextBound.height() / 2, mTextPaint);
    }

    private void drawPath(Canvas canvas) {
        mPath.reset();

        mPath.moveTo(0, mHeight);
        mWavePaint.setStrokeWidth(7);
        mPath.lineTo(0, mWaveHeight);
        mPath.cubicTo(mWidth / 2 - mWidth / 4, mWaveHeight - mHeight / 4, mWidth / 2 + mWidth / 4, mWaveHeight + mHeight / 4, mWidth, mWaveHeight);
        mPath.lineTo(mWidth, mHeight);
        mPath.close();

        canvas.drawPath(mPath, mWavePaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }
}*/
