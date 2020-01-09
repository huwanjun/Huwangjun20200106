package com.bawei.xm010106myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * author: 斛万珺
 * data: 2020/1/6 17:17:52
 * function:
 */
public class MyNumberView extends LinearLayout {

    private View inflate;
    private Button mainMinus;
    private TextView mainTv;
    private Button mainAdd;
    onNumberListener listener;
    public MyNumberView(Context context) {
        super(context);
        init(context);
    }

    public MyNumberView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyNumberView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate = LayoutInflater.from(context).inflate(R.layout.view_number, this, true);
        initView();
        initListener();
    }

    private void initListener() {

        mainAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = mainTv.getText().toString();
                Integer integer = Integer.valueOf(string);
                integer++;
                mainTv.setText(integer + "");
                if (listener != null) {
                    listener.onNumberChange(integer + "", string);
                }
            }
        });

        mainMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = mainTv.getText().toString();
                Integer integer = Integer.valueOf(string);
                if (integer <= 0) {
                    integer = 0;
                } else {
                    integer--;
                }
                mainTv.setText(integer + "");
                if (listener != null) {
                    listener.onNumberChange(integer + "", string);
                }
            }
        });

    }

    private void initView() {
        mainMinus = (Button) inflate.findViewById(R.id.main_minus);
        mainTv = (TextView) inflate.findViewById(R.id.main_tv);
        mainAdd = (Button) inflate.findViewById(R.id.main_add);
    }

    public void setListener(onNumberListener listener) {
        this.listener = listener;
    }

    public interface onNumberListener {
        void onNumberChange(String number, String old);
    }
}
