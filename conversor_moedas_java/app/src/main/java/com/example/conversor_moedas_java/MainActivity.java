package com.example.conversor_moedas_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.edit_value = findViewById(R.id.edit_value);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Resume executado",Toast.LENGTH_SHORT).show();
    }

    private static class ViewHolder{
        //Classe estática que conterá todos os elementos de interface, que serão instanciados
        // apenas uma vez no onCreate

        EditText edit_value;
    }
}