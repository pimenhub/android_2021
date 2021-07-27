package com.jpimentel.myappcine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private EditText editTextNom, editTextApe, editTextNIT, editTextNumB;
    private TextView textViewPre, textViewTotal;
    private int precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editTextNom = findViewById(R.id.edtNombre);
        editTextApe = findViewById(R.id.edtApellido);
        editTextNIT = findViewById(R.id.edtNIT);
        editTextNumB = findViewById(R.id.edtNumeroB);

        textViewPre = findViewById(R.id.txtPrecio);
        textViewTotal = findViewById(R.id.txtTotal);

        this.obtenerDatos();


        editTextNumB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cambioCantidad();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        precio = bundle.getInt("precio");
        textViewPre.setText(String.valueOf(precio));
    }
    private void cambioCantidad(){
        if(!editTextNumB.getText().toString().isEmpty()) {
            int precio = Integer.parseInt(textViewPre.getText().toString());
            int cantidad = Integer.parseInt(editTextNumB.getText().toString());
            int resultado = cantidad * precio;
            textViewTotal.setText(String.valueOf(resultado));
        }
        else {
            Toast.makeText(this, "Debe de agregar por lo menos un boleto", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        if(view.getId() == R.id.btnComprar){
            if(!editTextNumB.getText().toString().isEmpty() &&
            !editTextNom.getText().toString().isEmpty() &&
            !editTextApe.getText().toString().isEmpty() &&
            !editTextNIT.getText().toString().isEmpty()){

                String n = editTextNom.getText().toString();
                String a = editTextApe.getText().toString();
                String nit = editTextNIT.getText().toString();
                String precio = textViewTotal.getText().toString();

                Toast.makeText(this, "Cliente "+n+" "+a+" con NIT "+nit+" su compra fue satisfactoria por un total de Q."+precio, Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Debe de llenar los datos", Toast.LENGTH_LONG).show();
            }
        }
    }
}