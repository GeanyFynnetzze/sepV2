package com.example.spacestationv2.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.spacestationv2.Model.Humidity;
import com.example.spacestationv2.Model.Temperature;

@androidx.room.Database(entities = {CO2Entity.class, HumidityEntity.class, TemperatureEntity.class, AllStatsEntity.class}, version = 4)
public abstract class Database extends RoomDatabase{

    private static Database instance;

    public abstract CO2DAO co2DAO();
    public abstract HumidityDAO humidityDAO();
    public abstract TemperatureDAO temperatureDAO();
    public abstract AllStatsDAO allStatsDAO();

    public static synchronized Database getInstance(Context context)
    {
        if(instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "Sensors_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private CO2DAO co2DAO;
        private HumidityDAO humidityDAO;
        private TemperatureDAO temperatureDAO;
        private AllStatsDAO allStatsDAO;

        private PopulateDbAsyncTask(Database db)
        {
            co2DAO = db.co2DAO();
            humidityDAO = db.humidityDAO();
            temperatureDAO = db.temperatureDAO();
            allStatsDAO=db.allStatsDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
        co2DAO.insert(new CO2Entity(1,25.32f,"27-11-2020"));
            co2DAO.insert(new CO2Entity(1,26.32f,"28-11-2020"));
            co2DAO.insert(new CO2Entity(3,298.32f,"30-11-2020"));
            co2DAO.insert(new CO2Entity(3,298.32f,"30-11-2020"));
            co2DAO.insert(new CO2Entity(4,298.32f,"30-11-2020"));



            return null;
        }
    }

}
