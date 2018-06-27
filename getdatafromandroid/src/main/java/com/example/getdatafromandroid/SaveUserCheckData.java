package com.example.getdatafromandroid;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class SaveUserCheckData {

    public static void SaveUserCheckData(){
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://app-1530030008.000webhostapp.com/API/get_data.php").newBuilder();
        String url = urlBuilder.build().toString();
        urlBuilder.addQueryParameter("name", "kouassi");
        urlBuilder.addQueryParameter("email", "kouass@mail.com");
        Request request = new Request.Builder().url(url).build();
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("une erreur   "+ e );
        }


    }
}
