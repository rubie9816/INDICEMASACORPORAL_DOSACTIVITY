package com.example.indicemasacorporal_dosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Bundle bundle;
    TextView lblresultadoIMC;
    TextView lblresultadoCategoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lblresultadoIMC = (TextView) findViewById(R.id.lblIMC);
        lblresultadoCategoria = (TextView) findViewById(R.id.lblCategoria);

        bundle = getIntent().getExtras();
        String IMC = bundle.getString("resultadoIMC");
        lblresultadoIMC.setText(IMC);
        String Categoria = bundle.getString("resultadoCategoria");
        lblresultadoCategoria.setText(Categoria);


    }
}
