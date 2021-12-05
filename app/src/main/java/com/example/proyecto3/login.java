package com.example.proyecto3;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity{


    private TextView registrate;
    private EditText correo;
    private  EditText password;
    private FirebaseAuth mAuth;
    private Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = findViewById(R.id.correo);
        password = findViewById(R.id.password);
        registrate = findViewById(R.id.registrateaqui);
        mAuth = FirebaseAuth.getInstance();
        iniciar = findViewById(R.id.iniciar);

        registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirRegistro();
            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        });

    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

     public void abrirapp(){
        Intent i = new Intent(login.this,bebida1.class);
        startActivity(i);
     }
     public void abrirRegistro(){
        Intent i = new Intent(login.this,Registrar.class);
        startActivity(i);
     }
     public void iniciarSesion(){
        mAuth.signInWithEmailAndPassword(correo.getText().toString(),password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                   FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(getApplicationContext(), "Inicio de sesion exitosa", Toast.LENGTH_SHORT).show();
                    abriraplicacion();
                }else{
                    Toast.makeText(getApplicationContext(),"Authentication failed",Toast.LENGTH_SHORT).show();

                }
            }
        });

     }
     public void abriraplicacion(){
        Intent i = new Intent(login.this, Menu.class );
        startActivity(i);
     }

}