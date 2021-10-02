package com.jpimentel.myappfirebaseauth2021;
//Esta aplicacion tiene 2 acciones, una es autenticarse directamente con Google
//y la otra es autenticarse con firebase
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

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private ImageView img;
    private TextView txtN, txtCorr, txtCod;

    //Agregar la clase de googleapiclient
    GoogleApiClient googleApiClient;

    //Implementamos firebase para su uso
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgId);
        txtN = findViewById(R.id.txtNombre);
        txtCorr = findViewById(R.id.txtCorreo);
        txtCod = findViewById(R.id.txtCodigo);

        //Validamos de nuevo la autenticacion
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();


        //Inicializamos en el onCreate al firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                //luego de validar en el metodo firebaseAuthConGoogle
                FirebaseUser user   = firebaseAuth.getCurrentUser();
                if (user != null){
                    //debemos de crear un metodo que traiga la informacion del usuario pero desde Firebase
                    obtenerInfoUserFirebase(user);
                }
                else{
                    irLogin();
                }
            }
        };


    }

    private void obtenerInfoUserFirebase(FirebaseUser user) {
        txtN.setText(user.getDisplayName());
        txtCorr.setText(user.getEmail());
        txtCod.setText(user.getUid());
        Glide.with(this).load(user.getPhotoUrl()).into(img);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogout:
                firebaseAuth.signOut();
                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        if(status.isSuccess()){
                            irLogin();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "No es posible cerrar sesion", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;

            case R.id.btnRevoke:
                firebaseAuth.signOut();
                Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        if(status.isSuccess()){
                            irLogin();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "No es posible revocar sesion", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this, "Fail "+connectionResult.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    //Estos metodos son solo para Firebase
    @Override
    protected void onStart() {
        super.onStart();
        //inicializa la escucha
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener != null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }

    //Este para el uso de firebase se debe de comentar
    /*@Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> optionalPendingResult = Auth.GoogleSignInApi.silentSignIn(googleApiClient);

        if (optionalPendingResult.isDone()){
            GoogleSignInResult googleSignInResult = optionalPendingResult.get();
            obtenerResultado(googleSignInResult);
        }

        else {
            optionalPendingResult.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    obtenerResultado(googleSignInResult);
                }
            });
        }
    }*/

    //Este se comenta para el uso de Firebase
    /*private void obtenerResultado(GoogleSignInResult googleSignInResult) {
        if(googleSignInResult.isSuccess()){
            GoogleSignInAccount googleSignInAccount = googleSignInResult.getSignInAccount();
            txtN.setText(googleSignInAccount.getDisplayName());
            txtCorr.setText(googleSignInAccount.getEmail());
            txtCod.setText(googleSignInAccount.getId());
            Glide.with(this).load(googleSignInAccount.getPhotoUrl()).into(img);
        }
        else {
            irLogin();
        }
    }*/
    private void irLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}