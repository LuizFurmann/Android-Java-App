package com.aplicativo.topijava.api;

import androidx.lifecycle.MutableLiveData;
import com.aplicativo.topijava.model.Data;
import com.aplicativo.topijava.model.Lista;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRespository {

    private RetrofitService retrofitService;

    //repository for abstract the api call
    public RetrofitRespository(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    public RetrofitService getRetrofitService() {
        return retrofitService;
    }

    public void Apicall(String query, MutableLiveData<List<Data>> liveData){
        Call<Lista> call = retrofitService.getAllUser(query);

        call.enqueue(new Callback<Lista>() {
            @Override
            public void onResponse(Call<Lista> call, Response<Lista> response) {
                if(response.isSuccessful()){
                    liveData.postValue(response.body().getItems());
                }else{
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<Lista> call, Throwable t) { }
        });
    }
}
