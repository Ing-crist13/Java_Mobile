package com.example.combustivel;

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
    EditText edEtanol, edGasolina;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalcular = (Button)findViewById(R.id.btCalcular);

        edEtanol = (EditText)findViewById(R.id.edEtanol);
        edGasolina = (EditText)findViewById(R.id.edGasolina);

        tvResultado = (TextView)findViewById(R.id.tvResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double etanol, gasolina, media;
                String resultado;

                etanol = Double.parseDouble(edEtanol.getText().toString());
                gasolina = Double.parseDouble(edGasolina.getText().toString());

                media = etanol/gasolina;

                if(media>0.7){
                    resultado = "Gasolina";

                } else
                    resultado = "Etanol";

                tvResultado.setText(String.valueOf(resultado));
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}