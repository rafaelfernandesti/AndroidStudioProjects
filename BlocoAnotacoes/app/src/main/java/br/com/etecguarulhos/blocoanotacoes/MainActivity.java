package br.com.etecguarulhos.blocoanotacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.etecguarulhos.blocoanotacoes.bancodedados.BancoDeDados;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext()); //abre a comunicação com o BD
        final Cursor cursor = bancoDeDados.obterAnotacoes(); //obtendo anotações e armazenando no Cursor

        String[] nomeCampos = new String[] {"_id","titulo"}; //campos que serão utilizados no List
        int[] idViews = new int[]{R.id.lblId, R.id.lblTituloModelo}; //IDs criados no modelo

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),R.layout.modelo_lista,cursor,nomeCampos,idViews,0);
        //adicionando o conteúdo do banco e o modelo no adaptador

        ListView lista = (ListView)findViewById(R.id.listaDeNotas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                cursor.moveToPosition(position);
                Intent intent = new Intent(MainActivity.this, EditarAnotacao.class);
                intent.putExtra("id",cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
                startActivity(intent);
                finish();
            }
        });
    }

    public void abrirTelaCriarAnotacao(View view) {
        Intent iniciarNovaActivity = new Intent(this, ActivityCriarAnotacao.class);
        startActivity(iniciarNovaActivity);
    }

}
