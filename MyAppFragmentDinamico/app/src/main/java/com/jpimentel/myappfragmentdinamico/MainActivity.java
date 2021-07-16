package com.jpimentel.myappfragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment1, fragment2, fragment3;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new FragmentUno();
        fragment2 = new FragmentDos();
        fragment3 = new FragmentTres();

        /*getSupportFragmentManager().beginTransaction().replace(R.id.contenedorID,fragment1).disallowAddToBackStack().commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorID,fragment2).disallowAddToBackStack().commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorID,fragment3).disallowAddToBackStack().commit();*/
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment3).hide(fragment3).commit();

    }

    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btnFrag1:
                if(fragment1.isAdded()){
                    transaction.hide(fragment2).hide(fragment3).show(fragment1);
                }
                else {
                    transaction.hide(fragment2).hide(fragment3).add(R.id.contenedorID,fragment1);
                    transaction.addToBackStack(null);
                }
                break;
            case R.id.btnFrag2:
                if(fragment2.isAdded()){
                    transaction.hide(fragment1).hide(fragment3).show(fragment2);
                }
                else {
                    transaction.hide(fragment1).hide(fragment3).add(R.id.contenedorID,fragment2);
                    transaction.addToBackStack(null);
                }
                break;
            case R.id.btnFrag3:
                if(fragment3.isAdded()){
                    transaction.hide(fragment2).hide(fragment1).show(fragment3);
                }
                else {
                    transaction.hide(fragment2).hide(fragment1).add(R.id.contenedorID,fragment3);
                    transaction.addToBackStack(null);
                }
                break;
        }
        transaction.commit();

    }
}