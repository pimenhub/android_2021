package com.jpimentel.myapp_gridcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MA_color extends AppCompatActivity {
    private TextView textView;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_color);

        textView = findViewById(R.id.txtColorHexa);
        relativeLayout = findViewById(R.id.relative1);

        this.dato();
    }

    private  void dato(){
        Bundle bundle = getIntent().getExtras();
        String hexa = bundle.getString("hexa");
        int color = bundle.getInt("color");

        textView.setText(String.valueOf(hexa));
        relativeLayout.setBackgroundColor(color);


    }
}