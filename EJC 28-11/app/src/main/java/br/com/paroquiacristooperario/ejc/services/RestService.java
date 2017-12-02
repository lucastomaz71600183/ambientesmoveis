package br.com.paroquiacristooperario.ejc.services;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.paroquiacristooperario.ejc.model.News;
import br.com.paroquiacristooperario.ejc.model.NewsList;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private Retrofit adapter;

    public RestService(String endPoint) {

        Gson gson = new GsonBuilder().serializeNulls().create();

        adapter = new Retrofit.Builder().
                baseUrl(endPoint).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
    }

    public <T> T getService(Class<T> c) {
        return adapter.create(c);
    }
}