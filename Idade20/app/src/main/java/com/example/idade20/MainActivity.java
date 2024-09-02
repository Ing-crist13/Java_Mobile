package com.example.idade20;

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

public class MainActivity extends AppCompatActivity {

    Button btCalcular;
    EditText edNome, edAno, edAtual;
    TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalcular = (Button)findViewById(R.id.btCalcular);

        edNome = (EditText)findViewById(R.id.edNome);
        edAno = (EditText)findViewById(R.id.edAno);
        edAtual = (EditText)findViewById(R.id.edAtual);

        tvResultado = (TextView)findViewById(R.id.tvResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ano, atual, idade, meses, dias, horas, minutos;
                String nome;

                ano = Integer.parseInt(edAno.getText().toString());
                atual = Integer.parseInt(edAtual.getText().toString());

                idade = atual-ano;
                meses = idade*12;
                dias = idade*365;
                horas = idade*8760;
                minutos = idade*525600;

                tvResultado.setText(String.valueOf(idade + " Anos \n" +  meses + " meses\n"
                        + dias + " dias\n" + horas + " horas\n" + minutos + " minutos"));

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}