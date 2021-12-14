package com.example.proyecto3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class comida1 extends AppCompatActivity {
    ComidaOfertas co = new ComidaOfertas();
    ComidaDestacadas cd = new ComidaDestacadas();
    ComidaEspeciales ce = new ComidaEspeciales();
    Contacto c = new Contacto();
    Cuenta o = new Cuenta();
    AcercaDeNosotros ac = new AcercaDeNosotros();

    public ArrayList<String> orden;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida1);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadFragment(co);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.acerca, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.acercade:
                loadFragment(ac);
                return true;
            case R.id.orden:
                loadFragment(o);
                return true;
            case R.id.contacto:
                loadFragment(c);
                return true;
            case R.id.atras:
                Intent intent =new Intent(comida1.this, com.example.proyecto3.Menu.class);
                startActivity(intent);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
    private final NavigationBarView.OnItemSelectedListener mOnNavigationItemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(co);
                    return true;
                case R.id.secondFragment:
                    loadFragment(cd);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(ce);
                    return true;

            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


}