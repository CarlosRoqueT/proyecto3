package com.example.proyecto3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ComidaOfertas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Button buttondevolver;
    private String mParam1;
    private String datos = "";
    private String mParam2;
    private Integer suma = 0;
    private Button agregarBirria;
    private Bundle datosAEnviar;
    Fragment fragmentcuenta = new Cuenta();
    public ArrayList<String> orden;
    private Button button1;
    public ComidaOfertas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComidaOfertas.
     */
    // TODO: Rename and change types and number of parameters
    public static ComidaOfertas newInstance(String param1, String param2) {
        ComidaOfertas fragment = new ComidaOfertas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comida_ofertas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    orden = new ArrayList<>();
    agregarBirria = getView().findViewById(R.id.buttoncuenta);
    buttondevolver = getView().findViewById(R.id.devolver);

    agregarBirria.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView dato;
            TextView precio;
            String dacio;
            dato = getView().findViewById(R.id.nachos);
            precio = getView().findViewById(R.id.precionachos);
            suma = suma + Integer.parseInt(precio.getText().toString());
            dacio = Integer.toString(suma);
            orden.add(dato.getText().toString());
            Toast.makeText(getContext(),dato.getText().toString(),Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(),dacio,Toast.LENGTH_SHORT).show();
            datosAEnviar = new Bundle();


            datosAEnviar.putStringArrayList("orden",orden);
            fragmentcuenta.setArguments(datosAEnviar);

        }
    });

    buttondevolver.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for(int i = 0; i <= orden.size()-1;i++){
                Toast.makeText(getContext(),Integer.toString(i +1 ),Toast.LENGTH_SHORT).show();
                datos = orden.get(i);
                Toast.makeText(getContext(),datos,Toast.LENGTH_SHORT).show();
            }

        }
    });




    }



}