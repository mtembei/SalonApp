package com.patrickmukiira.salonapp;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class Book extends AppCompatActivity {
    EditText ET_NAME,ET_MASS ,ET_OTHERS,ET_PHONE,ET_HAIR,ET_TIME;
    String name,phone_number,hair,massage,others,time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ET_NAME = (EditText)findViewById(R.id.name);
        ET_PHONE = (EditText)findViewById(R.id.phone_number);
        ET_HAIR = (EditText)findViewById(R.id.hair);
        ET_MASS = (EditText)findViewById(R.id.massage);
        ET_OTHERS = (EditText)findViewById(R.id.others);
        ET_TIME = (EditText)findViewById(R.id.time);

    }
    public void bookn(View view){
        name = ET_NAME.getText().toString();
        phone_number = ET_PHONE.getText().toString();
        hair = ET_HAIR.getText().toString();
        massage = ET_MASS.getText().toString();
        others = ET_OTHERS.getText().toString();
        time = ET_TIME.getText().toString();
        String method = "book";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,phone_number,hair,massage,others,time);
    }
    class BackgroundTask extends AsyncTask<String,String,String> {
        AlertDialog alertDialog;
        Context ctx;
        BackgroundTask(Context ctx)
        {
            this.ctx =ctx;
        }
        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(ctx).create();
            alertDialog.setTitle("booking in progess....");
            alertDialog.show();
        }
        @Override
        protected String doInBackground(String... params) {
            String book_url = "http://10.0.2.2:86/salon/register.php";

            String method = params[0];
            if (method.equals("book")) {
                String name = params[1];
                String phone_number = params[2];
                String hair = params[3];
                String massage = params[4];
                String others = params[5];
                String time = params[6];
                try {
                    URL url = new URL(book_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    //httpURLConnection.setDoInput(true);
                    OutputStream OS = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                    String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                            URLEncoder.encode("phone_number", "UTF-8") + "=" + URLEncoder.encode(phone_number, "UTF-8") + "&" +
                            URLEncoder.encode("hair", "UTF-8") + "=" + URLEncoder.encode(hair, "UTF-8") + "&" +
                            URLEncoder.encode("massage", "UTF-8") + "=" + URLEncoder.encode(massage, "UTF-8") + "&" +
                            URLEncoder.encode("others", "UTF-8") + "=" + URLEncoder.encode(others, "UTF-8")+ "&" +
                            URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();
                    InputStream IS = httpURLConnection.getInputStream();
                    IS.close();
                    //httpURLConnection.connect();
                    httpURLConnection.disconnect();
                    return "New record created successfully";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String result) {
            if(result.equals("New record created successfully"))
            {
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(ctx, "please book details", Toast.LENGTH_LONG).show();
            }
        }
    }

}