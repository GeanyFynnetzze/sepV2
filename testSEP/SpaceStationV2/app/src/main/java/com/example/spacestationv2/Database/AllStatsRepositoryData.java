package com.example.spacestationv2.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AllStatsRepositoryData {

    private AllStatsDAO allStatsDAO;
    private LiveData<List<AllStatsEntity>> allStats;

    public AllStatsRepositoryData(Application application) {
        Database database = Database.getInstance(application);
        allStatsDAO = database.allStatsDAO();
       allStats = allStatsDAO.getAllStats();
    }

    public LiveData<List<AllStatsEntity>> getAllStats() {
        return allStats;
    }



    public void insert(AllStatsEntity allStatsEntity) {
        new AllStatsRepositoryData.InsertAllStatsAsyncTask(allStatsDAO).execute(allStatsEntity);
    }

    private static class InsertAllStatsAsyncTask extends AsyncTask<AllStatsEntity, Void, Void> {
        private AllStatsDAO allStatsDAO;

        private InsertAllStatsAsyncTask(AllStatsDAO allStatsDAO) {
            this.allStatsDAO = allStatsDAO;
        }

        @Override
        protected Void doInBackground(AllStatsEntity... allStatsEntities) {
            allStatsDAO.insert(allStatsEntities[0]);
            return null;
        }
    }
}
