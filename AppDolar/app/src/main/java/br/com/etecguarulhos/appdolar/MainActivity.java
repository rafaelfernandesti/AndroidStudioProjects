package br.com.etecguarulhos.appdolar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View v){

        //Endereço do webservice
        String url = "http://api.fixer.io/latest?base=USD";

        //criar uma tarefa assíncrona que realiza a requisição do webservice
        //e retorna o valor do dólar em um Toast
        System.out.println(new DownloadTask().execute(url));
    }

    private class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params){
            try{
                return downloadContent(params[0]);
            }catch (IOException e){
                return "Unable to recuperar dados. URL deve estar inválida";
            }
        }

        @Override
        protected void onPostExecute(String result){

            //ao terminar de carregar, irá ler o conteúdo e disparar o Toast com o valor do dólar

            try{

                JSONObject parent_obj = new JSONObject(result).getJSONObject("rates");
                Toast.makeText(MainActivity.this, "Dólar está: "+parent_obj.getString("BRL"), Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, "Erro no JSON: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        private String downloadContent(String myurl) throws IOException{
            InputStream is = null;
            int length = 500;

            //Realiza o request e retorna o resultado como String
            try{
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                int response = conn.getResponseCode();
                is = conn.getInputStream();

                //Converte o InputStream para uma String
                String contentAsString = convertInputStreamToString(is,length);
                return contentAsString;
            }
            finally {
                if(is != null){
                    is.close();
                }
            }
        }
        public String convertInputStreamToString(InputStream stream, int length) throws IOException, UnsupportedEncodingException{
            Reader reader = null;
            reader = new InputStreamReader(stream,"utf-8");
            char[] buffer = new char[length];
            reader.read(buffer);
            return new String(buffer);
        }
    }



}
