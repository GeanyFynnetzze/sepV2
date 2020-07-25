package com.example.spacestationv2.Database;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class TemperatureRepositoryData {

    private TemperatureDAO temperatureDAO;
    private LiveData<List<TemperatureEntity>> allTemperatures;

    public TemperatureRepositoryData(Application application)
    {
        Database database = Database.getInstance(application);
        temperatureDAO = database.temperatureDAO();
        allTemperatures = temperatureDAO.getAllTEMP();
    }

    public LiveData<List<TemperatureEntity>> getAllTemperatures()
    {
        return allTemperatures;
    }

    public void insert(TemperatureEntity temperatureEntity)
    {
        new InsertTemperaturesAsyncTask(temperatureDAO).execute(temperatureEntity);
    }

    private static class InsertTemperaturesAsyncTask extends AsyncTask<TemperatureEntity, Void, Void>
    {
        private TemperatureDAO temperatureDAO;
        private InsertTemperaturesAsyncTask(TemperatureDAO temperatureDAO)
        {
            this.temperatureDAO = temperatureDAO;
        }

        @Override
        protected Void doInBackground(TemperatureEntity... temperatureEntities) {
            temperatureDAO.insert(temperatureEntities[0]);
            return null;
        }
    }
}
