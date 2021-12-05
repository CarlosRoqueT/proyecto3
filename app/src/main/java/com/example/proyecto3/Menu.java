package com.example.proyecto3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {
    ImageButton comida;
    ImageButton bebida;
    ImageButton postres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        comida =(ImageButton)findViewById(R.id.button_comida);
        comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Menu.this, comida1.class);
                startActivity(intent);
            }
        });

        bebida =(ImageButton)findViewById(R.id.button_bebida);
        bebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Menu.this, bebida1.class);
                startActivity(intent);
            }
        });

        postres =(ImageButton)findViewById(R.id.button_postres);
        postres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Menu.this, postresof.class);
                startActivity(intent);
            }
        });
    }
}