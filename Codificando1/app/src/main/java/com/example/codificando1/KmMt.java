package com.example.codificando1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KmMt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km_mt);

        //associar os componentes da programação com os da interface (R.id)
        final EditText edtKm_prog = findViewById(R.id.edtKm);
        final EditText edtMt_prog = findViewById(R.id.edMt);
        Button btnConverter_prog = findViewById(R.id.btnConverter);

        btnConverter_prog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //estrutura da ação para o botão
                float km, m;
                km = Float.parseFloat(edtKm_prog.getText().toString());
                m = km * 1000;
                edtMt_prog.setText(String.valueOf(m));
            }
        });
    }
}