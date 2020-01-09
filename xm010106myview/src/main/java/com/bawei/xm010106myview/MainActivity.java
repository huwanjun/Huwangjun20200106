package com.bawei.xm010106myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FlowLayout flow;
    private EditText edit_search;
    private TextView sou;
    private MyNumberView mainNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flow=findViewById(R.id.flow);
        edit_search=findViewById(R.id.edit_search);
        sou=findViewById(R.id.text_sou);
        mainNum=findViewById(R.id.main_num);

        initListener();

        sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit_search.getText().toString();
                flow.addTag(s);
        }
        });


    }

    private void initListener() {
        mainNum.setListener(new MyNumberView.onNumberListener() {
            @Override
            public void onNumberChange(String number, String old) {
                Toast.makeText(MainActivity.this, "现在:"+number+"之前的"+old, Toast.LENGTH_SHORT).show();
            }


        });
        flow.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
            @Override
            public void OnTagClick(String tag) {

                Toast.makeText(MainActivity.this, "点击了"+tag, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
