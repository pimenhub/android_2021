package com.jpimentel.myappautenticacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    //Declaracion de uso de api
    private GoogleApiClient googleApiClient;
    //Declarar boton
    private SignInButton signInButton;

    //Constante de codigo de sesion
    private static final int CODE_SING_IN = 123;

    //Implementacion para uso con Firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener fireAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInButton = findViewById(R.id.btnLogin);
        //proceso de login segun tipo, esto define que sera por Correo
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
             //Cuando la autenticacion sea por fireba se debe de agregar lo siguiente
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();
        //Validar el acceso
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, CODE_SING_IN);
            }
        });

        //Inicializar el uso de firebase - Esto es solo para Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        fireAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    irMain();
                }
            }
        };

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
    //Valida el resulta elegido en el recuadro de los correos
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE_SING_IN){
            GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //Metodo para obtener el resulta y realizar la accion debida
            obtenerResultado(googleSignInResult);
        }
        else {
            Toast.makeText(this, "Error onActivity", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para obtener el resulta y realizar la accion debida
    private void obtenerResultado(GoogleSignInResult googleSignInResult){
        if(googleSignInResult.isSuccess()){
            //irMain();//este metodo se debe de comentar cuando utilizamos firebase
            //Este metodo es para firebase
            firebaseAuthConGoogle(googleSignInResult.getSignInAccount());
        }
        else {
            Toast.makeText(this, "Error de Conexion Obtener ", Toast.LENGTH_SHORT).show();
        }
    }

    //Este metodo es solo para Firebase
    private void firebaseAuthConGoogle(GoogleSignInAccount googleSignInAccount){
        AuthCredential credential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(),null);
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "No es posible Auntenticar con Firebase", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    private void irMain(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //Se definer Flags para poder controlar el ciclo de vida de la actividad
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}