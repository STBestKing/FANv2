package com.example.suntao.fanv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_off;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button change;
    CircleView circleView;
    int black = 0;
    int yellow = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        circleView.change();
    }

    public void init(){
        btn_off = findViewById(R.id.btn_off);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        change = findViewById(R.id.change);
        circleView = findViewById(R.id.circle);

        btn_off.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        change.setOnClickListener(this);
        circleView.setClickable(true);
        circleView.setOnClickListener(this);
        black = circleView.black;
        yellow = circleView.yellow;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_off:
                circleView.speed = 0;
                break;
            case R.id.btn_1:
                circleView.speed = 10;
                break;
            case R.id.btn_2:
                circleView.speed = 16;
                break;
            case R.id.btn_3:
                circleView.speed = 25;
                break;
            case R.id.change:
                if (circleView.fan == circleView.black) {
                    circleView.fan = circleView.yellow;
                    circleView.change();
                }
                else {
                    circleView.fan = black;
                    circleView.change();
                }
                break;
            default:
                break;
        }
    }

}