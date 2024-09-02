package com.example.idade;

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

public class MainActivity extends AppCompatActivity {

    Button btLimpar, btCalcular;
    EditText edNome, edNascimento, edAtual, edDiaatual, edDia, edMes, edMesatual;
    TextView tvResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalcular = (Button)findViewById(R.id.btCalcular);
        btLimpar = (Button)findViewById(R.id.btLimpar);

        edNome = (EditText)findViewById(R.id.edNome);
        edDia = (EditText)findViewById(R.id.edDia);
        edMes = (EditText)findViewById(R.id.edMes);
        edDiaatual = (EditText)findViewById(R.id.edDiaatual);
        edMesatual = (EditText)findViewById(R.id.edMesatual);
        edNascimento = (EditText)findViewById(R.id.edNascimento);
        edAtual = (EditText)findViewById(R.id.edAtual);

        tvResultado = (TextView)findViewById(R.id.tvResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dian, mesn, nascimento,diaatual, mesatual, atual, Diaresultado, Mesresultado, Anoresultado;


                nascimento = Integer.parseInt(edNascimento.getText().toString());
                dian = Integer.parseInt(edDia.getText().toString());
                mesn = Integer.parseInt(edMes.getText().toString());
                diaatual = Integer.parseInt(edDiaatual.getText().toString());
                mesatual = Integer.parseInt(edMesatual.getText().toString());
                atual = Integer.parseInt((edAtual.getText().toString()));
                Diaresultado = (diaatual-dian);
                Mesresultado =(mesatual-mesn);
                Anoresultado = (atual-nascimento);
                tvResultado.setText(String.valueOf(Anoresultado+ " Anos " + Mesresultado + " Meses " + Diaresultado + " Dias "));

            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edNome.setText("");
                edDia.setText("");
                edDiaatual.setText("");
                edMes.setText("");
                edMesatual.setText("");
                edNascimento.setText("");
                edAtual.setText("");
                tvResultado.setText("");
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}