package br.com.paroquiacristooperario.ejc.services;

import br.com.paroquiacristooperario.ejc.model.NewsList;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ServiceNews {
    @GET("noticias")
    Call<NewsList> getNews();
}
