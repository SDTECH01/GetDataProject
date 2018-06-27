package com.example.getdatafromandroid;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static okhttp3.HttpUrl.*;

public class SaveUserCheckData {
    public static String serverURL = "https://app-1530030008.000webhostapp.com/API/get_data.php";

    public static void SaveUserCheckDataok() {
        OkHttpClient client = new OkHttpClient();
        Builder urlBuilder = new Builder();
        // String url = urlBuilder.build().toString();
        urlBuilder.addQueryParameter("name", "kouassi");
        urlBuilder.addQueryParameter("email", "kouass@mail.com");
        Request request = new Request.Builder().url("https://app-1530030008.000webhostapp.com/API/get_data.php").build();
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("une erreur   " + e);
        }


    }

    public static void SaveUserCheckDataook() {
        OkHttpClient client = new OkHttpClient();
        Builder urlBuilder = new Builder();
        // String url = urlBuilder.build().toString();
        urlBuilder.addQueryParameter("name", "kouassi");
        urlBuilder.addQueryParameter("email", "kouass@mail.com");
        Request request = new Request.Builder().url("https://app-1530030008.000webhostapp.com/API/get_data.php").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                System.out.println("votre erreur" + mMessage);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String mMessage = response.body().string();
                if (response.isSuccessful()) {
                    try {
                        JSONObject json = new JSONObject(mMessage);
                        final String serverResponse = json.getString("c'est OK");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // Log.i("la requete est ", String.valueOf(response+" et "+ request));
            }
        });


    }

    public static void InsertData(final String name, final String email) {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String NameHolder = name;
                String EmailHolder = email;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("name", NameHolder));
                nameValuePairs.add(new BasicNameValuePair("email", EmailHolder));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(serverURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                //Toast.makeText(MainActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(name, email);
    }


    public static final class Konzaga {
        OkHttpClient client = new OkHttpClient();

        @TargetApi(Build.VERSION_CODES.KITKAT)
        public void run() throws Exception {
            RequestBody formBody = new FormBody.Builder()
                    .add("name", "Jurassic Park")
                    .add("email", "mail.com")
                    .build();
            Request request = new Request.Builder()
                    .url("https://app-1530030008.000webhostapp.com/API/get_data.php")
                    .post(formBody)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful())
                    throw new IOException("Unexpected code " + response);

                System.out.println(response.body().string());
            }
        }
    }

    public void Cka()

    {
        try {
            new Konzaga().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
