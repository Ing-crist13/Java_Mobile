package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button BtCalcular, BtLimpar;
    EditText EdNome, EdPeso, EdAltura;
    TextView tvIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BtCalcular = (Button)findViewById(R.id.BtCalcular);
        BtLimpar = (Button)findViewById(R.id.BtLimpar);

        EdNome = (EditText) findViewById(R.id.EdNome);
        EdAltura = (EditText) findViewById(R.id.EdAltura);
        EdPeso = (EditText) findViewById(R.id.EdPeso);

        tvIMC = (TextView) findViewById(R.id.tvIMC);




        BtCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso, altura, imc;


                peso = Double.parseDouble(EdPeso.getText().toString());
                altura = Double.parseDouble((EdAltura.getText().toString()));
                imc = (peso/(altura*altura))*10000;
                tvIMC.setText(String.valueOf(Math.round(imc)));


            }
        });

        BtLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdNome.setText("");
                EdPeso.setText("");
                EdAltura.setText("");
                tvIMC.setText("");
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}