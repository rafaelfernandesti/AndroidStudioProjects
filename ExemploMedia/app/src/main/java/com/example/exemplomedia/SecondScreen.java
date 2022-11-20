package com.example.exemplomedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

    TextView txtResultado;
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        voltar();
        //associação do elemento de tela com o objeto
        txtResultado = findViewById(R.id.txtResultado);

        //lê o parâmetro que vem com o Intent
        Intent i = getIntent();
        float media = i.getFloatExtra("mediaCalculada",0f);
        //verifica se o valor é maior ou igual a 6.
        String situacao = "";
        if(media >= 6){
            situacao = "Aprovado";
        }else{
            situacao = "Reprovado";
        }
        String msg = "Você foi " + situacao + " com média de " + media;

        txtResultado.setText(msg);
    }

    public void voltar(){
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declara a intent, responsável por identificar a próxima tela a ser aberta
                Intent intent = new Intent(SecondScreen.this, MainScreen.class);
                startActivity(intent);
            }
        });
    }
}