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

public class postreses extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton oferta;
    ImageButton destacado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postreses);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        oferta =(ImageButton)findViewById(R.id.oferbutton);
        oferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(postreses.this, postresof.class);
                startActivity(intent);
            }
        });

        destacado =(ImageButton)findViewById(R.id.desbutton);
        destacado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(postreses.this, postresdes.class);
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
            Intent intent =new Intent(postreses.this, ad.class);
            startActivity(intent);
        } else if (id == R.id.atras) {
            Intent intent =new Intent(postreses.this, com.example.proyecto3.Menu.class);
            startActivity(intent);
        } else if (id == R.id.orden) {
            Intent intent =new Intent(postreses.this, orden.class);
            startActivity(intent);
        }
        return true;
    }
}