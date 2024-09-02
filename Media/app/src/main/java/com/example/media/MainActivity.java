package com.example.media;

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
        EditText edNome, edNota1, edNota2, edNota3, edFaltas;
        TextView tvSituacao, tvMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btLimpar = (Button)findViewById(R.id.btLimpar);
        btCalcular = (Button)findViewById(R.id.btCalcular);

        edNome = (EditText)findViewById(R.id.edNome);
        edNota1 = (EditText)findViewById(R.id.edNota1);
        edNota2 = (EditText)findViewById(R.id.edNota2);
        edNota3 = (EditText)findViewById(R.id.edNota3);
        edFaltas = (EditText)findViewById(R.id.edFaltas);

        tvSituacao = (TextView)findViewById(R.id.tvSituacao);
        tvMedia = (TextView)findViewById(R.id.tvMedia);


        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double nota1, nota2, nota3, media;
                int falta;
                String situacao;

                nota1 = Double.parseDouble(edNota1.getText().toString());
                nota2 = Double.parseDouble(edNota2.getText().toString());
                nota3 = Double.parseDouble(edNota3.getText().toString());
                falta = Integer.parseInt(edFaltas.getText().toString());

                if(nota1<= nota2 && nota1<= nota3){
                    media = (nota1+nota3)/2;
                }
                else if(nota2<= nota1 && nota2<=nota3){
                    media = (nota1+nota3)/2;
                }
                else{
                    media = (nota1+nota2)/2;
                }

                tvMedia.setText(String.valueOf(media));

                if ( media >= 6 && falta <= 5){
                    situacao = "Aprovado";
                }
                else if( media >= 6 && falta >=5 ){
                    situacao = "Reprovado por faltas";
                }
                else if( media <= 6 && falta <=5 ){
                    situacao = "Reprovado por nota";
                }
                else{
                    situacao = " Reprovado por nota e faltas";
                }
                tvSituacao.setText(String.valueOf(situacao));

                btLimpar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        edNome.setText("");
                        edNota1.setText("");
                        edNota2.setText("");
                        edNota3.setText("");
                        tvMedia.setText("");
                        tvSituacao.setText("");
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