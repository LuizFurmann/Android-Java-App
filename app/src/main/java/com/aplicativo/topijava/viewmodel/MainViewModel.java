package com.aplicativo.topijava.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.aplicativo.topijava.api.RetrofitRespository;
import com.aplicativo.topijava.api.RetrofitService;
import com.aplicativo.topijava.model.Data;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    MutableLiveData<List<Data>> liveData;

    @Inject
    RetrofitService retrofitService;

    @Inject
    public MainViewModel() {
        liveData = new MutableLiveData();
    }

    public MutableLiveData<List<Data>> getLiveData(){
        return liveData;
    }

    public void Apicall(){
        RetrofitRespository retrofitRespository = new RetrofitRespository(retrofitService);
        retrofitRespository.Apicall("us", liveData);
    }
}
