package com.jpimentel.myapp_actionandtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Barra de Accion");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Ver compras", Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.ic_online_shopping);
                break;
            case R.id.item2:
                Toast.makeText(this, "Ver compras", Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.ic_shopping);
                break;
            case R.id.item3:
                Toast.makeText(this, "Ver compras", Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.ic_store);
                break;
            case R.id.item4:
                Toast.makeText(this, "Ver compras", Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.ic_shopping_cart);
                break;
            case R.id.item5:
                imageView.setImageResource(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}