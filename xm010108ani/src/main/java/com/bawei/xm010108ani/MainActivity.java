package com.bawei.xm010108ani;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text_dian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_dian=findViewById(R.id.text_dian);

        text_dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator translationX = ObjectAnimator.ofFloat(text_dian, "translationX", 100, 200);
                ObjectAnimator translationY = ObjectAnimator.ofFloat(text_dian, "translationY", 100, 200);

                ObjectAnimator rotationX = ObjectAnimator.ofFloat(text_dian, "rotationX", 100, 200);
                ObjectAnimator rotationY = ObjectAnimator.ofFloat(text_dian, "rotationY", 100, 200);

                ObjectAnimator scaleX = ObjectAnimator.ofFloat(text_dian, "scaleX", 2 );
                ObjectAnimator scaleY= ObjectAnimator.ofFloat(text_dian, "scaleY", 2 );

                AnimatorSet set=new AnimatorSet();
                set.setDuration(3000);
                set.play(translationX).with(translationY).before(rotationX).before(rotationY).after(scaleX).after(scaleY);
                set.start();



            }
        });
    }
}
