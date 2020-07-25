package com.example.spacestationv2.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CO2RepositoryData {

    private CO2DAO co2DAO;
    private LiveData<List<CO2Entity>> allCO2;

    public CO2RepositoryData(Application application) {
        Database database = Database.getInstance(application);
        co2DAO = database.co2DAO();
        allCO2 = co2DAO.getAllCO2();
    }

    public LiveData<List<CO2Entity>> getAllCO2() {
        return allCO2;
    }

    public void insert(CO2Entity co2Entity) {
        new CO2RepositoryData.InsertCO2AsyncTask(co2DAO).execute(co2Entity);
    }

    private static class InsertCO2AsyncTask extends AsyncTask<CO2Entity, Void, Void> {
        private CO2DAO co2DAO;

        private InsertCO2AsyncTask(CO2DAO co2DAO) {
            this.co2DAO = co2DAO;
        }

        @Override
        protected Void doInBackground(CO2Entity... co2Entities) {
            co2DAO.insert(co2Entities[0]);
            return null;
        }
    }
}
