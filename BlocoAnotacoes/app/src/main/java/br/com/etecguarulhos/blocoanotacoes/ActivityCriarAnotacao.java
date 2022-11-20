package br.com.etecguarulhos.blocoanotacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.etecguarulhos.blocoanotacoes.bancodedados.BancoDeDados;

public class ActivityCriarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anotacao);
    }

    public void voltarTela(View view){
        //código para retornar à página anterior
        Intent voltarActivity = new Intent(this,MainActivity.class);
        startActivity(voltarActivity);
    }
    public void criarAnotacao(View view){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = (EditText) findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudo);

        boolean result = bancoDeDados.criarNota(titulo.getText().toString(), conteudo.getText().toString());

        if(result){
            Toast.makeText(getApplicationContext(),"Anotação criada com sucesso", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(getApplicationContext(),"Deu ruim na criação da nota. Verificae!", Toast.LENGTH_LONG).show();
        }
        voltarTela(view);

    }

}
