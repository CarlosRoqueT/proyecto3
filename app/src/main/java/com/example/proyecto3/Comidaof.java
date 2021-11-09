package com.example.proyecto3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Comidaof extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton especial;
    ImageButton destacado;
    ImageButton comida1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidaof);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        especial =(ImageButton)findViewById(R.id.espbutton);
        especial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Comidaof.this, comidaes.class);
                startActivity(intent);
            }
        });

        destacado =(ImageButton)findViewById(R.id.desbutton);
        destacado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Comidaof.this, comidades.class);
                startActivity(intent);
            }
        });

        comida1 =(ImageButton)findViewById(R.id.postof1);
        comida1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Comidaof.this, comida1.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.acerca, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.acercade) {
            Intent intent =new Intent(Comidaof.this, ad.class);
            startActivity(intent);
        } else if (id == R.id.atras) {
            onBackPressed();
        } else if (id == R.id.orden) {
            Intent intent =new Intent(Comidaof.this, orden.class);
            startActivity(intent);
        }
        return true;
    }
}