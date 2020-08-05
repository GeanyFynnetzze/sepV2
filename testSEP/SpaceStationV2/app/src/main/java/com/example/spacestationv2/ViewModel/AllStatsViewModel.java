package com.example.spacestationv2.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.spacestationv2.Database.AllStatsRepositoryData;
import com.example.spacestationv2.Database.AllStatsEntity;


import com.example.spacestationv2.Model.AllStats;
import com.example.spacestationv2.API.RepositoryAllStats;

import java.util.List;


public class AllStatsViewModel extends AndroidViewModel {
    private MutableLiveData<List<AllStats>> mutableLiveData;
    private AllStatsRepositoryData repositoryData;
    private RepositoryAllStats repositoryAllStats;
    private LiveData<List<AllStatsEntity>> allStats;

    public AllStatsViewModel(@NonNull Application application) {
        super(application);
        repositoryData = new AllStatsRepositoryData(application);
        allStats= repositoryData.getAllStats();
    }



    public void initLivingRoom() {
        if (mutableLiveData != null) {
            return;
        }
        repositoryAllStats = RepositoryAllStats.getInstance();
        mutableLiveData = repositoryAllStats.getLivingRoom();
    }
    public void initToilet() {
        if (mutableLiveData != null) {
            return;
        }
        repositoryAllStats = RepositoryAllStats.getInstance();
        mutableLiveData = repositoryAllStats.getToilet();
    }
    public void initKitchen() {
        if (mutableLiveData != null) {
            return;
        }
        repositoryAllStats = RepositoryAllStats.getInstance();
        mutableLiveData = repositoryAllStats.getKitchen();
    }

    public void insert(AllStatsEntity allStats)
    {
        repositoryData.insert(allStats);
    }


    public LiveData<List<AllStatsEntity>> getAllStatsEntities()
    {
        return  allStats;
    }

    public LiveData<List<AllStats>> getAllStatsRepo() {
        return mutableLiveData;
    }


}
