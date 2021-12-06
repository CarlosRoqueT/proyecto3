package com.example.proyecto3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Registrar extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView ingresa;
    private EditText correo;
    private EditText password;
    private EditText passconfirmation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        mAuth = FirebaseAuth.getInstance();

        ingresa = findViewById(R.id.ingresa);
        correo =  findViewById(R.id.correo);
        password = findViewById(R.id.password);
        passconfirmation = findViewById(R.id.passconfirmation);



    ingresa.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            abrirInicio();
        }
    });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.


    }

    public void registrarUsuario(View view){
        try{
        if(password.getText().toString().equals(passconfirmation.getText().toString())){
            mAuth.createUserWithEmailAndPassword(correo.getText().toString(),password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getApplicationContext(),"Usuario creado con exito",Toast.LENGTH_SHORT).show();
                                abrirInicio();



                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(),"Error de autenticacion, o el usuario ya existe",Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
        }else{
            Toast.makeText(this,"Los pass no coinciden wey",Toast.LENGTH_SHORT).show();

        }}catch (Exception e){
            Toast.makeText(this,"No deje campos vacios",Toast.LENGTH_SHORT).show();
        }
    }
    public void abrirInicio(){
        Intent i = new Intent(Registrar.this, login.class);
        startActivity(i);
    }
}

