package com.bawei.xm0108lx;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * author: 斛万珺
 * data: 2020/1/8 10:10:05
 * function:
 */
public class PillarView extends View {
    private Paint paint;
    public PillarView(Context context) {
        super(context);
        init();
    }

    public PillarView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
        initAttr(context,attrs);
    }

    public PillarView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initAttr(context,attrs);
    }

    private void initAttr(Context context, AttributeSet attrs) {
        //属性
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.PillarView);

    }

    private void init() {
        //初始化画笔
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(20);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        canvas.translate(0,height);
        int perHeight=height/40;
        int perWidth=width/22;
        int left=0;
        int top=0;
        int right=0;
        int bottom=0;

        top=perHeight;
        right=perWidth;
        paint.setColor(Color.parseColor("#FF0000"));
        canvas.drawRect(left,-top,right,bottom ,paint);

        top=perHeight*7;
        right=perWidth*2;
        left=perWidth;
        paint.setColor(Color.RED);
        canvas.drawRect(left,-top,right,bottom ,paint);

        top=perHeight*15;
        right=perWidth*3;
        left=perWidth*2;
        paint.setColor(Color.GREEN);
        canvas.drawRect(left,-top,right,bottom ,paint);

        top=perHeight*18;
        right=perWidth*4;
        left=perWidth*3;
        paint.setColor(Color.parseColor("#CCFF00"));
        canvas.drawRect(left,-top,right,bottom ,paint);

        top=perHeight*22;
        right=perWidth*5;
        left=perWidth*4;
        paint.setColor(Color.parseColor("#FFF003"));
        canvas.drawRect(left,-top,right,bottom ,paint);

        top=perHeight*7;
        right=perWidth*6;
        left=perWidth*5;
        paint.setColor(Color.parseColor("#00FF0F"));
        canvas.drawRect(left,-top,right,bottom ,paint);



        top=perHeight*18;
        right=perWidth*7;
        left=perWidth*6;
        paint.setColor(Color.parseColor("#CCFF00"));
        canvas.drawRect(left,-top,right,bottom ,paint);

        top=perHeight*22;
        right=perWidth*8;
        left=perWidth*7;
        paint.setColor(Color.parseColor("#FFF003"));
        canvas.drawRect(left,-top,right,bottom ,paint);

        top=perHeight*7;
        right=perWidth*9;
        left=perWidth*8;
        paint.setColor(Color.parseColor("#00FF0F"));
        canvas.drawRect(left,-top,right,bottom ,paint);


    }
}
