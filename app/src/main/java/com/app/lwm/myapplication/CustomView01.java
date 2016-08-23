package com.app.lwm.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wm.liu on 2016/8/23 11:19
 */
public class CustomView01 extends View{

    private String mTxet;
    private int mColor;
    private Paint mPaint;

    public CustomView01(Context context) {
        super(context);
        initPaint();
    }
    public CustomView01(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomView01,
                0, 0);
        try {
            mTxet=ta.getString(R.styleable.CustomView01_mTxet);
            mColor=ta.getColor(R.styleable.CustomView01_mColor, Color.BLACK);
        }finally {
            ta.recycle();
        }
        initPaint();
    }
    public CustomView01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mColor);
        mPaint.setTextSize(100);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(mTxet,100, 100, mPaint);
    }
}
