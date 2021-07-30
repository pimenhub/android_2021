package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jpimentel.myappbdsqlite.complementos.ConstantesSQL;

public class MainActivityActualizar extends AppCompatActivity {
    private EditText editTextBuscar, editTextNombre,
            editTextSabor, editTextTipo, editTextPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar);

        editTextBuscar = findViewById(R.id.edtBuscarBebidaActualizar);
        editTextNombre = findViewById(R.id.edtNombreActualizar);
        editTextSabor = findViewById(R.id.edtSaborActualizar);
        editTextTipo = findViewById(R.id.edtTipoActualizar);
        editTextPrecio = findViewById(R.id.edtPrecioActualizar);


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscarBebidaActualizar:
                this.consultarID();
                break;
            case R.id.btnActualizarBebida:
                this.actualizarBebida();
                break;
        }
    }

    private void consultarID(){
        if(!editTextBuscar.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_BEBIDA, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getReadableDatabase();
            String[] parametro = {editTextBuscar.getText().toString()};
            try {
                String consultarID;
                consultarID = "SELECT "+ConstantesSQL.CAMPO_NOMBRE+", "+ConstantesSQL.CAMPO_SABOR+", "+
                        ConstantesSQL.CAMPO_TIPO+", "+ConstantesSQL.CAMPO_PRECIO+" FROM "+ConstantesSQL.TABLA_BEBIDA+
                        " WHERE "+ConstantesSQL.CAMPO_ID+" = ?;";
                Cursor cursor = database.rawQuery(consultarID, parametro);
                cursor.moveToFirst();
                editTextNombre.setText(cursor.getString(0));
                editTextSabor.setText(cursor.getString(1));
                editTextTipo.setText(cursor.getString(2));
                editTextPrecio.setText(cursor.getString(3));
                cursor.close();
            }
            catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debe ingresar el dato a buscar", Toast.LENGTH_SHORT).show();
        }
    }

    private void actualizarBebida(){
        if(!editTextBuscar.getText().toString().isEmpty() && !editTextNombre.getText().toString().isEmpty()
        && !editTextSabor.getText().toString().isEmpty() && !editTextTipo.getText().toString().isEmpty()
        && !editTextPrecio.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_BEBIDA, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            try {
                String consultaActualizar;
                consultaActualizar = "UPDATE "+ConstantesSQL.TABLA_BEBIDA+" SET "+
                        ConstantesSQL.CAMPO_NOMBRE+"= '"+editTextNombre.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_SABOR+"= '"+editTextSabor.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_TIPO+"= '"+editTextTipo.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_PRECIO+"= "+editTextPrecio.getText().toString()+" WHERE "+
                        ConstantesSQL.CAMPO_ID+"= "+editTextBuscar.getText().toString()+";";
                database.execSQL(consultaActualizar);
                database.close();

                editTextBuscar.setText("");
                editTextNombre.setText("");
                editTextSabor.setText("");
                editTextTipo.setText("");
                editTextPrecio.setText("");
                Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                e.getMessage();
            }
        }
        else {
            Toast.makeText(this, "Debe de llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
}