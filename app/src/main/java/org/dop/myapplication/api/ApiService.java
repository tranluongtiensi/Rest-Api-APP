package org.dop.myapplication.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.dop.myapplication.MainActivity;
import org.dop.myapplication.model.Info;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("fact")
    Call<Info> cheetabInfo(@Query("fact") String fact,
                           @Query("length") String length);
}
