package br.com.etecguarulhos.blocoanotacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

import br.com.etecguarulhos.blocoanotacoes.bancodedados.BancoDeDados;

public class EditarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_anotacao);

        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        final Cursor cursor = bancoDeDados.consultarAnotacaoPeloID(this.getIntent().getIntExtra("id",0));

        EditText titulo = (EditText) findViewById(R.id.campoTituloEditar);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudoEditar);

        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        conteudo.setText(cursor.getString(cursor.getColumnIndexOrThrow("conteudo")));
    }

    public void excluirAnotacao(View view) {
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = (EditText) findViewById(R.id.campoTituloEditar);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudoEditar);

        try {
            bancoDeDados.excluiAnotacao(this.getIntent().getIntExtra("id",0));
            Toast.makeText(getApplicationContext(),"Anotação excluída com sucesso",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Anotação não excluída. Verificae",Toast.LENGTH_LONG).show();
        }
        voltarTela(view);
    }

    public void voltarTela(View view) {
        //código para retornar à página anterior
        Intent voltarActivity = new Intent(this,MainActivity.class);
        startActivity(voltarActivity);
    }

    public void atualizarAnotacao(View view) {
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = (EditText) findViewById(R.id.campoTituloEditar);
        EditText conteudo = (EditText) findViewById(R.id.campoConteudoEditar);

        try{
            bancoDeDados.atualizaAnotacao(this.getIntent().getIntExtra("id",0),titulo.getText().toString(),conteudo.getText().toString());
            Toast.makeText(getApplicationContext(),"Anotação alterada com sucesso",Toast.LENGTH_LONG).show();
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Anotação não alterada... verificae",Toast.LENGTH_LONG).show();
        }
        voltarTela(view);
    }
}
