package com.example.proyecto3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class bebida1 extends AppCompatActivity {

    BebidasOfertas bo = new BebidasOfertas();
    BebidasEspeciales be = new BebidasEspeciales();
    BebidasDestacadas bd = new BebidasDestacadas();
    Settings s = new Settings();
    Contacto c = new Contacto();
    AcercaDeNosotros ac = new AcercaDeNosotros();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebida1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(bo);
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
            case R.id.contacto:
                loadFragment(c);
                return true;
            case R.id.atras:
                Intent intent =new Intent(bebida1.this, com.example.proyecto3.Menu.class);
                startActivity(intent);
                return true;
            case R.id.configuracion:
                loadFragment(s);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private final NavigationBarView.OnItemSelectedListener mOnNavigationItemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(bo);
                    return true;
                case R.id.secondFragment:
                    loadFragment(bd);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(be);
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