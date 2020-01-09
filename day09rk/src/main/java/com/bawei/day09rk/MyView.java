package com.bawei.day09rk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * author: 斛万珺
 * data: 2020/1/8 08:8:45
 * function:
 */
public class MyView extends View {
    private Paint paint;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);

        paint=new Paint();
        paint.setTextSize(20);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);
        canvas.drawRect(100,100,450,550,paint);
        canvas.drawCircle(300,300,200,paint);
        paint.setColor(Color.BLUE);
        canvas.drawLine(10,10,150,150,paint);

    }
}
