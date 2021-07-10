package com.jpimentel.myapp_repaso3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.txtNumero);
        this.dato();

    }

    private void dato(){
        Bundle bundle = getIntent().getExtras();
        int numero = bundle.getInt("numero");

        textView.setText(String.valueOf(numero));
    }
}