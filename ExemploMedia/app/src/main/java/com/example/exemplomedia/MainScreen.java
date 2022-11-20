package com.example.exemplomedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    //declaração de objetos para elementos de tela
    EditText editNumero1, editNumero2;
    Button btnCalcular;
    TextView txtTeste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associa os elementos da tela com os objetos declarados
        editNumero1 = findViewById(R.id.edtNumero1);
        editNumero2 = findViewById(R.id.edtNumero2);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia(v);
            }
        });
    }


    public void calcularMedia(View v){
        float nota1 = Float.parseFloat(editNumero1.getText().toString());
        float nota2 = Float.parseFloat(editNumero2.getText().toString());
        float media = (nota1 + nota2) /2;
        txtTeste = findViewById(R.id.txtTeste);
        txtTeste.setText(String.valueOf(media));
        //Declara a intent, responsável por identificar a próxima tela a ser aberta
        Intent intent = new Intent(MainScreen.this, SecondScreen.class);
        //Insere um parâmetro a mais
        intent.putExtra("mediaCalculada", media);
        //chamando segunda tela
        startActivity(intent);
    }
}