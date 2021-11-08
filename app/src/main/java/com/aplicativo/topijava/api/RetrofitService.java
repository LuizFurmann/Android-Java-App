package com.aplicativo.topijava.api;

import com.aplicativo.topijava.model.Lista;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    //Path api
    @GET("repositories")
    Call<Lista> getAllUser(@Query("q") String query);
}
