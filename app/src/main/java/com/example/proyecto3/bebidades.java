package com.example.proyecto3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class bebidades extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton especial;
    ImageButton oferta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidades);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        especial =(ImageButton)findViewById(R.id.espbutton);
        especial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(bebidades.this, bebidaes.class);
                startActivity(intent);
            }
        });

        oferta =(ImageButton)findViewById(R.id.oferbutton);
        oferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(bebidades.this, bebidaof.class);
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
            Intent intent =new Intent(bebidades.this, ad.class);
            startActivity(intent);
        } else if (id == R.id.atras) {
            Intent intent =new Intent(bebidades.this, com.example.proyecto3.Menu.class);
            startActivity(intent);
        } else if (id == R.id.orden) {
            Intent intent =new Intent(bebidades.this, orden.class);
            startActivity(intent);
        }
        return true;
    }

}