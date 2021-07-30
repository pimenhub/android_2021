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

public class MainActivityEliminar extends AppCompatActivity {
    private EditText editText;
    private TextView textViewNombre, textViewSabor, textViewTipo, textViewPrecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar);

        editText = findViewById(R.id.edtBuscarBebidaEliminar);
        textViewNombre = findViewById(R.id.txtNombreEliminar);
        textViewSabor = findViewById(R.id.txtSaborEliminar);
        textViewTipo = findViewById(R.id.txtTipoEliminar);
        textViewPrecio = findViewById(R.id.txtPrecioEliminar);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarBebidaEliminar:
                this.consultarID();
                break;
            case R.id.btnEliminarBebida:
                this.eliminarBebida();
                break;
        }
    }

    private void consultarID(){
        if (!editText.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_BEBIDA,null,ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getReadableDatabase();
            String[] parametro = {editText.getText().toString()};
            try {
                String consultarID;
                consultarID = "SELECT "+ConstantesSQL.CAMPO_NOMBRE+", "+
                        ConstantesSQL.CAMPO_SABOR+", "+
                        ConstantesSQL.CAMPO_TIPO+", "+
                        ConstantesSQL.CAMPO_PRECIO+" FROM "+ConstantesSQL.TABLA_BEBIDA+" WHERE "+
                        ConstantesSQL.CAMPO_ID+"= ?;";
                Cursor cursor = database.rawQuery(consultarID,parametro);
                cursor.moveToFirst();
                textViewNombre.setText(cursor.getString(0));
                textViewSabor.setText(cursor.getString(1));
                textViewTipo.setText(cursor.getString(2));
                textViewPrecio.setText(cursor.getString(3));
                cursor.close();
            }
            catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debe de llenar el campo a buscar", Toast.LENGTH_SHORT).show();
        }
    }
    private void eliminarBebida(){
        if(!editText.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_BEBIDA,null,ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            try {
                String consultaEliminar;
                consultaEliminar = "DELETE FROM "+ConstantesSQL.TABLA_BEBIDA+
                        " WHERE "+ConstantesSQL.CAMPO_ID+"= "+editText.getText().toString()+";";
                database.execSQL(consultaEliminar);
                database.close();
                editText.setText("");
                textViewNombre.setText("");
                textViewSabor.setText("");
                textViewTipo.setText("");
                textViewPrecio.setText("");
                Toast.makeText(this, "Datos Eliminados Correctamente", Toast.LENGTH_SHORT).show();

            }
            catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(this, "Debe de llenar el dato a buscar", Toast.LENGTH_SHORT).show();
        }
    }
}