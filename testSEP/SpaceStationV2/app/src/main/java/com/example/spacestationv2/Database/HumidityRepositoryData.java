package com.example.spacestationv2.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HumidityRepositoryData {

    private HumidityDAO humidityDAO;
    private LiveData<List<HumidityEntity>> allHumidities;

    public HumidityRepositoryData(Application application)
    {
        Database database = Database.getInstance(application);
        humidityDAO = database.humidityDAO();
        allHumidities = humidityDAO.getAllHUM();
    }

    public LiveData<List<HumidityEntity>> getAllHumidities()
    {
        return allHumidities;
    }

    public void insert(HumidityEntity humidityEntity)
    {
        new HumidityRepositoryData.InsertHumiditiesAsyncTask(humidityDAO).execute(humidityEntity);
    }

    private static class InsertHumiditiesAsyncTask extends AsyncTask<HumidityEntity, Void, Void>
    {
        private HumidityDAO humidityDAO;
        private InsertHumiditiesAsyncTask(HumidityDAO humidityDAO)
        {
            this.humidityDAO = humidityDAO;
        }

        @Override
        protected Void doInBackground(HumidityEntity... humidityEntities) {
            humidityDAO.insert(humidityEntities[0]);
            return null;
        }
    }
}
