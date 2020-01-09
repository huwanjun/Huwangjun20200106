package com.bawei.xm010107lx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FlowLayout flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flow=findViewById(R.id.flow);

       for (int i = 0; i < 20; i++) {
           flow.addTag("斛涂蛋");
           flow.addTag("四川省四川省");

           flow.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
               @Override
              public void OnTagClick(String tag) {
                   Toast.makeText(MainActivity.this,"点击了"+ tag, Toast.LENGTH_SHORT).show();
              }
            });
        flow.setOnTagLongClickListener(new FlowLayout.OnTagLongClickListener() {
             @Override
            public void OnTagLongClick(String tag) {
                Toast.makeText(MainActivity.this,"长安删除了"+ tag, Toast.LENGTH_SHORT).show();
            }
        });
       }
    }
}
