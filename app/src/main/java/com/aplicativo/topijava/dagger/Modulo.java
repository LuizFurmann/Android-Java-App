package com.aplicativo.topijava.dagger;

import com.aplicativo.topijava.api.RetrofitService;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class Modulo {

    //url of api
    String BASE_URL = "https://api.github.com/search/";

    @Singleton
    @Provides
    public RetrofitService getInstance(Retrofit retrofit){
        return retrofit.create(RetrofitService.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}