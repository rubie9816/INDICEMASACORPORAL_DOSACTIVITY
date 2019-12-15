package com.example.indicemasacorporal_dosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String resultadoIMC;
    String resultadoCategoria;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OBTENER LA ALTURA
                final EditText heighText = (EditText)
                        findViewById(R.id.txtAltura);

                String heighStr = heighText.getText().toString();
                double height = Double.parseDouble(heighStr);

                //OBTENER EL PESO

                final EditText weightText = (EditText)
                        findViewById(R.id.txtPeso);

                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);

                double BMI = (weight) / (height * height);
                resultadoIMC = Double.toString(BMI);

                String BMI_Cat;
                if (BMI < 15)
                    BMI_Cat = "Very severely underweight";
                else if (BMI < 16)
                    BMI_Cat = "Severely underweight";
                else if (BMI < 18.5)
                    BMI_Cat = "Underweight";
                else if (BMI < 25)
                    BMI_Cat = "Normal";
                else if (BMI < 30)
                    BMI_Cat = "Overweight";
                else if (BMI < 35)
                    BMI_Cat = "Obese Class 1 - Moderately Obese";
                else if (BMI < 40)
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                else
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";

                resultadoCategoria = BMI_Cat;

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("resultadoIMC",resultadoIMC);
                intent.putExtra("resultadoCategoria",resultadoCategoria);
                startActivity(intent);
            }
        });
    }
}