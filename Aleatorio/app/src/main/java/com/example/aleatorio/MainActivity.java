package com.example.aleatorio;

import android.annotation.SuppressLint;
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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btGerar, btLimpar;
    EditText edInicio, edFinal;
    TextView tvResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btGerar = (Button)findViewById(R.id.btGerar);
        btLimpar = (Button)findViewById(R.id.btLimpar);

        edInicio = (EditText)findViewById(R.id.edInicio);
       edFinal = (EditText)findViewById(R.id.edFinal);

        tvResultado = (TextView)findViewById(R.id.tvResultado);

        btGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int inicio, fim;

                inicio = Integer.parseInt(edInicio.getText().toString());
                fim = Integer.parseInt(edFinal.getText().toString());

                int resultado = (int) (Math.floor(Math.random()*(fim-inicio+1))+inicio);

                tvResultado.setText(String.valueOf(resultado));

                btLimpar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edInicio.setText("");
                        edFinal.setText("");
                        tvResultado.setText("");
                    }
                });
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}