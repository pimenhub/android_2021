package com.jpimentel.myappcamara;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    //Inicializar el boton de tomar foto, por el motivo de que los permisos de acepten o denieguen
    private Button btnTomarFoto;

    //Variables Globales
    private String nombreIMG;
    private String rutaAlmacenamiento;

    //Constantes
    private final String CARPETA_PRINCIPAL = "CamaraAndroid/";
    private final String CARPETA_FOTOS = CARPETA_PRINCIPAL+"Fotos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imgCargar);
        btnTomarFoto = findViewById(R.id.btnTomarFoto);


        if(permisos()){
            btnTomarFoto.setEnabled(true);
        }
        else {
            btnTomarFoto.setEnabled(false);
        }


    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnTomarFoto:
                tomarFoto();
                break;
            case R.id.btnCargarFoto:
                cargarImagen();
                break;
        }
    }


    private void tomarFoto(){
        //identificar la ruta donde estara la foto
        File fileImagen = new File(Environment.getExternalStorageDirectory(),CARPETA_FOTOS);
        //validar la ruta dond estara la foto
        boolean rutaExiste = fileImagen.exists();
        if(rutaExiste == false){
            rutaExiste = fileImagen.mkdirs();
        }
        if(rutaExiste == true){
            nombreIMG = "IMG"+ Calendar.getInstance().getTime()+".jpg";
        }
        //almacenamiento de la foto en la ruta indicada
        rutaAlmacenamiento = Environment.getExternalStorageDirectory()+
                File.separator+CARPETA_FOTOS+File.separator+nombreIMG;
        File almacenar = new File(rutaAlmacenamiento);

        //Tomar Foto
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Permisos primera etapa
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //Variable de autorizacion
            String autorizacion = getApplicationContext().getPackageName()+".provider";
            Uri uri = FileProvider.getUriForFile(this,autorizacion,almacenar);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        }
        else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(almacenar));
        }
        startActivity(intent);
    }


    //Cargar Foto o Imagen
    private void cargarImagen(){
        activityResultLauncher.launch("image/*");
    }
    ActivityResultLauncher<String> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                      imageView.setImageURI(result);
                }
            }
    );



    //Permisos segunda Etapa
    public boolean permisos(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return true;
        }
        if((checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_GRANTED)){
            return true;
        }
        requestPermissions(new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 3001);
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 3001){
            if(grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
            && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                btnTomarFoto.setEnabled(true);
            }
        }

    }
}