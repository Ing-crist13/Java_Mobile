package com.example.juros_simples;

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

    Button btCalclular;
    EditText edValorInicial, edPercentual, edMeses;
    TextView tvValorFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalclular = (Button)findViewById(R.id.btCalcular);

        edValorInicial = (EditText)findViewById(R.id.edValorInicial);
        edPercentual = (EditText)findViewById(R.id.edPercentual);
        edMeses = (EditText)findViewById(R.id.edMeses);

        tvValorFinal = (TextView)findViewById(R.id.tvValorFinal);

        btCalclular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorInicial, ValorFinal, percentual, juros;
                int meses;

                valorInicial = Double.parseDouble(edValorInicial.getText().toString());
                percentual = Double.parseDouble(edPercentual.getText().toString());
                meses = Integer.parseInt(edMeses.getText().toString());

                juros = (valorInicial * (percentual/100) * meses);

                ValorFinal = valorInicial + juros;

                tvValorFinal.setText(String.valueOf(ValorFinal));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}