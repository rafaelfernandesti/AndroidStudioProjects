package br.com.etecguarulhos.blocoanotacoes.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados {
    public SQLiteDatabase banco;
    public GerenciarBanco gerenteBanco;
    public BancoDeDados(Context context){
        gerenteBanco = new GerenciarBanco(context);
    }

    public boolean criarNota(String titulo, String conteudo){
        banco = gerenteBanco.getWritableDatabase();
        //requisitando o BD em modo leitura e escrita

        ContentValues valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("conteudo", conteudo);
        //criação de objeto para conteúdo e titulo

        long resultado = banco.insert("tb_anotacoes", null, valores);
        //inserção dos valores no BD
        banco.close();
        //fecha a conexão com o BD

        return resultado > 0;
        //retorna true se o resultado for positivo e false caso dê alguma falha
    }

    public Cursor obterAnotacoes(){
        String[] campos = {"_id","titulo"};
        //array para campos que serão resgatados
        SQLiteDatabase db = gerenteBanco.getReadableDatabase(); //conexao em modo leitura
        Cursor cursor = db.query("tb_anotacoes",campos,null,null,null,null, "titulo ASC");

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
        //cursor está com todos os elementos encontrados na consulta
    }
    
    
    public void excluiAnotacao(int id) {
        SQLiteDatabase db = gerenteBanco.getReadableDatabase();
        String where = " _id = "+id;

        db.delete("tb_anotacoes",where,null);
        db.close();
    }

    public void atualizaAnotacao(int id, String titulo, String conteudo) {
        SQLiteDatabase db = gerenteBanco.getReadableDatabase();
        String where = " _id = "+id;

        ContentValues valores = new ContentValues();
        valores.put("titulo",titulo);
        valores.put("conteudo",conteudo);

        db.update("tb_anotacoes", valores, where, null);
        db.close();
    }

    public Cursor consultarAnotacaoPeloID(int notaId) {
        Cursor cursor;
        String[] campos = {"_id","titulo","conteudo"};
        String where = "_id = " + notaId;
        SQLiteDatabase db = gerenteBanco.getReadableDatabase();
        cursor = db.query("tb_anotacoes",campos, where, null ,null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
