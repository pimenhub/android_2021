package com.jpimentel.myapp_repaso2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText campoEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoEdad = findViewById(R.id.txtEdad);

    }

    private void verificar(){
        String edad = campoEdad.getText().toString();
        Intent intent;
        if(!edad.isEmpty()){
         int edadIngresada = Integer.parseInt(edad);
         if(edadIngresada < 18){
             intent = new Intent(this, MainActivity2.class);
             startActivity(intent);
         }
         else {
             intent = new Intent(this, MainActivity3.class);
             startActivity(intent);
         }
        }
        else{
            Toast.makeText(this, "Dato no agregado", Toast.LENGTH_SHORT).show();
        }
    }


    public void onClick(View view) {
        this.verificar();
    }
}