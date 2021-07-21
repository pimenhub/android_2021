package com.jpimentel.myappextrasrecyclerfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    private Fragment fragment1, fragment2;
    private FragmentTransaction transaction;

    //encargadas de recibir datos y luego insertar esos datos a los fragmentos
    private int detalle;
    private int especificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragment1 = new DetalleFragment();
        fragment2 = new EspecificacionesFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID, fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID, fragment2).hide(fragment2).commit();


        //Datos
        this.obtenerDatos();
        this.trasladarFrag1();
        this.trasladarFrag2();
    }

    //obtener datos
    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        detalle = bundle.getInt("detalle");
        especificaciones = bundle.getInt("especificaciones");
    }
    //Traslado de informacion al fragment 1
    private void trasladarFrag1(){
        Bundle bundle = new Bundle();
        bundle.putInt("deta", detalle);
        fragment1.setArguments(bundle);
    }
    //Traslado de informacion al fragment 2
    private void trasladarFrag2(){
        Bundle bundle = new Bundle();
        bundle.putInt("espe", especificaciones);
        fragment2.setArguments(bundle);
    }



    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btnDetalles:
                if (fragment1.isAdded()){
                    transaction.hide(fragment2).show(fragment1);
                }
                else {
                    transaction.hide(fragment2).add(R.id.contenedorID, fragment1);
                    transaction.addToBackStack(null);
                }
                break;
            case R.id.btnEspecificaciones:
                if (fragment2.isAdded()){
                    transaction.hide(fragment1).show(fragment2);
                }
                else {
                    transaction.hide(fragment1).add(R.id.contenedorID, fragment2);
                    transaction.addToBackStack(null);
                }
                break;
        }
        transaction.commit();
    }
}