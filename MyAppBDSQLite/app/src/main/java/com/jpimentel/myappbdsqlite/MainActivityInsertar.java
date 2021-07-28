package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jpimentel.myappbdsqlite.complementos.ConstantesSQL;

public class MainActivityInsertar extends AppCompatActivity {
    private EditText editTextNombre, editTextSabor, editTextTipo, editTextPrecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar);

        editTextNombre = findViewById(R.id.edtNombreBebida);
        editTextSabor = findViewById(R.id.edtSaborBebida);
        editTextTipo = findViewById(R.id.edtTipoBebida);
        editTextPrecio = findViewById(R.id.edtPrecioBebida);
    }

    public void onClick(View view) {
        this.insertarBebida();
    }

    private void insertarBebida(){
        if(!editTextNombre.getText().toString().isEmpty() &&
        !editTextSabor.getText().toString().isEmpty() &&
        !editTextTipo.getText().toString().isEmpty() &&
        !editTextPrecio.getText().toString().isEmpty()){
            //Realizar la conexion por medio del objeto Conector
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_BEBIDA,
                    null,ConstantesSQL.VERSION);
            //Instaciamos el objeto de base de datos para establecer lo que se va a realizar a continuacio
            //en la base de datos
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            //Creacion del query para la insercion de los datos
            try {
                String consultaInsertar;
                consultaInsertar = "INSERT INTO "+ConstantesSQL.TABLA_BEBIDA + " ("+ConstantesSQL.CAMPO_NOMBRE+", "+
                        ConstantesSQL.CAMPO_SABOR+", "+ConstantesSQL.CAMPO_TIPO+", "+ConstantesSQL.CAMPO_PRECIO+
                        ") VALUES ('"+editTextNombre.getText().toString()+"', '"+editTextSabor.getText().toString()+
                        "', '"+editTextTipo.getText().toString()+"', "+editTextPrecio.getText().toString()+");";

                //accion de la consulta
                database.execSQL(consultaInsertar);
                database.close();
                editTextNombre.setText("");
                editTextSabor.setText("");
                editTextTipo.setText("");
                editTextPrecio.setText("");

                Toast.makeText(this, "Datos Insertados Correctamente", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                e.getMessage();
            }
        }
        else {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}





