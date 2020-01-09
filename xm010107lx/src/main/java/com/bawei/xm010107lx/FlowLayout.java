package com.bawei.xm010107lx;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: 斛万珺
 * data: 2020/1/7 11:11:23
 * function:
 */
public class FlowLayout extends ViewGroup {
    private int screenWid=0;
    private TextView textView;
    private int color;
    private int midSize;
    private float dimension1;
    private int dimension;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWid=displayMetrics.widthPixels;
        initAttr(context,attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context,attrs);
    }

    private void initAttr(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        color = typedArray.getColor(R.styleable.FlowLayout_text_color,0);


        TypedArray typedArray1 = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        dimension1 = typedArray1.getDimension(R.styleable.FlowLayout_text_size, 10);

        TypedArray typedArray2 = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        dimension = (int)typedArray2.getDimension(R.styleable.FlowLayout_text_space, 5);


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int wSpace=30;
        int hSpace=20;
        int left=wSpace;
        int top=hSpace;
        int right=0;
        int bottom=0;

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            child.measure(0,0);

            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();
            right=left+measuredWidth;

            if (right>screenWid){

                left=wSpace;
                top=bottom+ hSpace;
                right=left+measuredWidth;

            }
            bottom=top+measuredHeight;
            child.layout(left,top,right,bottom);
            left=right+wSpace;
        }


    }

    public void addTag(String tag){
        textView = new TextView(getContext());
        textView.setText(tag);
        textView.setTextColor(color);
        textView.setTextSize(dimension1);
        textView.setPadding(dimension,dimension,dimension,dimension);

        addView(textView);

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTagClickListener != null) {
                    onTagClickListener.OnTagClick(textView.getText().toString());
                }
            }
        });

       textView.setOnLongClickListener(new OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               if (onTagLongClickListener != null) {
                   onTagLongClickListener.OnTagLongClick(textView.getText().toString());
                   removeView(textView);
               }
           return true;
           }
       });
    }
    //设置标签点击事件

    OnTagClickListener onTagClickListener;

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.onTagClickListener = onTagClickListener;
    }

    public interface OnTagClickListener{
        void OnTagClick(String tag);
    }
    //设置长按点击
    OnTagLongClickListener onTagLongClickListener;

    public void setOnTagLongClickListener(OnTagLongClickListener onTagLongClickListener) {
        this.onTagLongClickListener = onTagLongClickListener;
    }

    public interface OnTagLongClickListener{

        void OnTagLongClick(String tag);
    }

}
