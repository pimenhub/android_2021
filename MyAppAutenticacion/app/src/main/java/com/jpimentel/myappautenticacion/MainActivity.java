package com.jpimentel.myappautenticacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//En este proyecto se agregaran diferentes validaciones de autenticacion
public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private ImageView imageView;
    private TextView textViewN, textViewC, textViewCod;

    private GoogleApiClient googleApiClient;

    //Implementacion para uso con Firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener fireAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imgId);
        textViewN = findViewById(R.id.txtNombre);
        textViewC = findViewById(R.id.txtCorreo);
        textViewCod = findViewById(R.id.txtCodigo);
        //proceso de login segun tipo, esto define que sera por Correo
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        //Validar acceso de nuevo
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();


        //Inicializar el uso de firebase - Esto es solo para Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        fireAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    obtenerInfoUserFirebase(user);
                }
                else {
                    irLogin();
                }
            }
        };
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCerrarSesion:
                firebaseAuth.signOut();
                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        if(status.isSuccess()){
                            irLogin();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "No es posible Cerrar Sesion", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.btnRevocar:
                firebaseAuth.signOut();
                Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        if (status.isSuccess()){
                            irLogin();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "No es posible Revocar Sesion", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }

    private void obtenerInfoUserFirebase(FirebaseUser user){
        textViewN.setText(user.getDisplayName());
        textViewC.setText(user.getEmail());
        textViewCod.setText(user.getUid());
        Glide.with(this).load(user.getPhotoUrl()).into(imageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //El escucha de firebase
        firebaseAuth.addAuthStateListener(fireAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Validamos el escucha
        if(fireAuthStateListener != null){
            firebaseAuth.removeAuthStateListener(fireAuthStateListener);
        }
    }



    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this, "Fallo de Conexion "+connectionResult.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }
    //Este metodo no se utilizar cuando se valida con Firebase
    /*@Override
    protected void onStart() {
        super.onStart();
        //Vericacion de la informacion obtenidad luego de la identificacion
        OptionalPendingResult<GoogleSignInResult> optionalPendingResult = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(optionalPendingResult.isDone()){
            GoogleSignInResult googleSignInResult = optionalPendingResult.get();
            obtenerResultado(googleSignInResult);
        }
        else{
            optionalPendingResult.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    obtenerResultado(googleSignInResult);
                }
            });
        }
    }*/

    //Este metodo no se utiliza cuando se valida con Firebase
    //Metodo para obtener el resulta y realizar la accion debida, ademas de mostrar la informacion
    /*private void obtenerResultado(GoogleSignInResult googleSignInResult){
        if(googleSignInResult.isSuccess()){
            GoogleSignInAccount googleSignInAccount = googleSignInResult.getSignInAccount();
            textViewN.setText(googleSignInAccount.getDisplayName());
            textViewC.setText(googleSignInAccount.getEmail());
            textViewCod.setText(googleSignInAccount.getId());
            Glide.with(this).load(googleSignInAccount.getPhotoUrl()).into(imageView);
        }
        else {
            irLogin();
        }

    }*/
    private void irLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        //Se definer Flags para poder controlar el ciclo de vida de la actividad
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}