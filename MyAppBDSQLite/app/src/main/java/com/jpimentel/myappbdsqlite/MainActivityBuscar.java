package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jpimentel.myappbdsqlite.complementos.ConstantesSQL;

public class MainActivityBuscar extends AppCompatActivity {
    private EditText editTextID;
    private TextView textViewNombre, textViewSabor, textViewTipo, textViewPrecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar);

        editTextID = findViewById(R.id.edtBuscarBebida);
        textViewNombre = findViewById(R.id.txtNombreBuscar);
        textViewSabor = findViewById(R.id.txtSaborBuscar);
        textViewTipo = findViewById(R.id.txtTipoBuscar);
        textViewPrecio = findViewById(R.id.txtPrecioBuscar);

    }

    public void onClick(View view) {
        this.buscarBebida();
    }

    private void buscarBebida(){
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_BEBIDA,
                null,ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        String[] parametro = {editTextID.getText().toString()};
        if (!editTextID.getText().toString().isEmpty()){
            try {
                //Consulta por ID
                String consultaID;
                consultaID = "SELECT " + ConstantesSQL.CAMPO_NOMBRE + ", " + ConstantesSQL.CAMPO_SABOR + ", " +
                        ConstantesSQL.CAMPO_TIPO + ", " + ConstantesSQL.CAMPO_PRECIO + " FROM " + ConstantesSQL.TABLA_BEBIDA +
                        " WHERE " + ConstantesSQL.CAMPO_ID + " = ?;";
                //Objeto que permite obtener datos de una consulta de base de datos
                Cursor cursor = database.rawQuery(consultaID, parametro);
                cursor.moveToFirst();
                textViewNombre.setText(cursor.getString(0));
                textViewSabor.setText(cursor.getString(1));
                textViewTipo.setText(cursor.getString(2));
                textViewPrecio.setText(cursor.getString(3));
                cursor.close();
            }
            catch (Exception e){
                e.getMessage();
            }

        }
        else {
            Toast.makeText(this, "Debe de llenar el campo", Toast.LENGTH_SHORT).show();
        }

    }

}