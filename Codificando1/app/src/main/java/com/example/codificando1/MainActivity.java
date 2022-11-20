package com.example.codificando1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Desenvolvimento do Button e associação à Activity (tela)
        Button btnKmMtProg = findViewById(R.id.btnKmMt);
        Button btnMtKmProg = findViewById(R.id.btnMtKm);
        //Responsável por verificar o momento em que o botão é pressionado, chamando ações (códigos) para abrir a outra tela.
        btnKmMtProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent informa que estamos na Activity "MainActivity" e vamos para a outra.
                Intent intent = new Intent(MainActivity.this, KmMt.class);
                startActivity(intent);
            }
        });

        btnMtKmProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent informa que estamos na Activity "MainActivity" e vamos para a outra.
                Intent intent = new Intent(MainActivity.this, MtKm.class);
                startActivity(intent);
            }
        });

    }
}