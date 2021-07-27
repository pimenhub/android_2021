package com.jpimentel.myappcine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {
    TabLayout tabLayout;
    Fragment fragment1, fragment2, fragment3;
    FragmentTransaction transaction;

    ImageButton imageButton;
    TextView textView;

    private int sinopsis;
    private int directoresActores;
    private int puntuacionRecaudacion;

    private int imagen;
    private String nombrePeli;
    private int precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageButton = findViewById(R.id.imgBtnID);
        textView = findViewById(R.id.txtNombrePelicula);

        tabLayout = findViewById(R.id.tabsID);
        tabLayout.addTab(tabLayout.newTab().setText("Sinopsis"));
        tabLayout.addTab(tabLayout.newTab().setText("Director y Actores"));
        tabLayout.addTab(tabLayout.newTab().setText("Puntuacion y Recaudacion"));
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        fragment1 = new SinopsisFragment();
        fragment2 = new DyaFragment();
        fragment3 = new PyrFragment();



        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment3).hide(fragment3).commit();

        this.obtenerDatos();
        this.trasladarFrag1();
        this.trasladarFrag2();
        this.trasladarFrag3();

        this.setInformacion();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        if (fragment1.isAdded()){
                            transaction.hide(fragment2).hide(fragment3).show(fragment1);
                        }
                        else {
                            transaction.hide(fragment2).hide(fragment3).add(R.id.contenedorID, fragment1);
                            transaction.addToBackStack(null);
                        }
                        break;
                    case 1:
                        if (fragment2.isAdded()){
                            transaction.hide(fragment1).hide(fragment3).show(fragment2);
                        }
                        else {
                            transaction.hide(fragment1).hide(fragment3).add(R.id.contenedorID, fragment2);
                            transaction.addToBackStack(null);
                        }
                        break;
                    case 2:
                        if (fragment3.isAdded()){
                            transaction.hide(fragment2).hide(fragment1).show(fragment3);
                        }
                        else {
                            transaction.hide(fragment2).hide(fragment1).add(R.id.contenedorID, fragment3);
                            transaction.addToBackStack(null);
                        }
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        sinopsis = bundle.getInt("sinopsis");
        directoresActores = bundle.getInt("dya");
        puntuacionRecaudacion = bundle.getInt("pyr");

        imagen = bundle.getInt("imagen");
        nombrePeli = bundle.getString("nombrePeli");
        precio = bundle.getInt("precio");
    }
    private void trasladarFrag1(){
        Bundle bundle = new Bundle();
        bundle.putInt("sinopsis", sinopsis);
        fragment1.setArguments(bundle);
    }
    private void trasladarFrag2(){
        Bundle bundle = new Bundle();
        bundle.putInt("dya", directoresActores);
        fragment2.setArguments(bundle);
    }
    private void trasladarFrag3(){
        Bundle bundle = new Bundle();
        bundle.putInt("pyr", puntuacionRecaudacion);
        fragment3.setArguments(bundle);
    }

    private void setInformacion(){
        imageButton.setImageResource(imagen);
        textView.setText(String.valueOf(nombrePeli));
    }


    public void onClick(View view) {
        if(view.getId() == R.id.btnComprarB) {
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
            intent.putExtra("precio", precio);
            startActivity(intent);
        }
        if(view.getId() == R.id.imgBtnID) {
            Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
            intent.putExtra("imagen", imagen);
            startActivity(intent);
        }
    }
}