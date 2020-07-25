package com.example.spacestationv2.ViewModel;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.spacestationv2.Database.CO2Entity;
import com.example.spacestationv2.Database.CO2RepositoryData;
import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.Model.CO2;
import com.example.spacestationv2.Model.Repository;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.List;


public class Co2ViewModel extends AndroidViewModel {
    private Repository repository;
    private MutableLiveData<List<CO2>> mutableLiveData;
    private CO2RepositoryData repositoryData;
    private LiveData<List<CO2Entity>> co2Entities;

    public Co2ViewModel(@NonNull Application application) {
        super(application);
        repositoryData = new CO2RepositoryData(application);
        co2Entities = repositoryData.getAllCO2();
    }

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        repository = Repository.getInstance();
        mutableLiveData = repository.getList("toilet", "CO2");
    }

    public void insert(CO2Entity co2Entity)
    {
        repositoryData.insert(co2Entity);
    }

    public LiveData<List<CO2Entity>> getCo2Entities()
    {
        return  co2Entities;
    }

    public LiveData<List<CO2>> getCo2Repo() {
        return mutableLiveData;
    }


}
