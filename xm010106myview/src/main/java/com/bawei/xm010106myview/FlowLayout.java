package com.bawei.xm010106myview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * author: 斛万珺
 * data: 2020/1/6 15:15:46
 * function:
 */
public class FlowLayout extends ViewGroup {
     int screenWid=0;
    private ImageView img;
    private EditText edit_search;
    private TextView text_sou;

    public FlowLayout(Context context) {
        super(context);
    }


    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWid=displayMetrics.widthPixels;
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

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
                top=bottom+hSpace;
                right=left+measuredWidth;
            }

            bottom=top+measuredHeight;
            child.layout(left,top,right, bottom);
            left=right+wSpace;
        }


    }

    public void addTag(String tag){

      final   TextView textView = new TextView(getContext());
        textView.setText(tag);
        textView.setTextColor(Color.RED);
        addView(textView);

        ObjectAnimator translationX = ObjectAnimator.ofFloat(textView, "translationX", screenWid, getLeft());
        translationX.setDuration(1500);
        translationX.start();
        textView.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {


               ObjectAnimator scaleX = ObjectAnimator.ofFloat(textView, "scaleX", 2);
               ObjectAnimator scaleY = ObjectAnimator.ofFloat(textView, "scaleY", 2);

               ObjectAnimator rotationX = ObjectAnimator.ofFloat(textView, "rotationX", 360);
               ObjectAnimator rotationY = ObjectAnimator.ofFloat(textView, "rotationY", 360);

               ObjectAnimator alpha = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0.2f);


               AnimatorSet set=new AnimatorSet();
               set.setDuration(3000);
               set.play(scaleX).after(scaleY).with(rotationX).with(rotationY).after(alpha);
               set.start();
           }
       });


        }




    OnTagClickListener onTagClickListener;

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.onTagClickListener = onTagClickListener;
    }

    public interface OnTagClickListener{

        void OnTagClick(String tag);
    }

}
