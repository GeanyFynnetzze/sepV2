package com.example.spacestationv2.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {AllStatsEntity.class}, version = 5)
public abstract class Database extends RoomDatabase{

    private static Database instance;


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

        private AllStatsDAO allStatsDAO;

        private PopulateDbAsyncTask(Database db)
        {

            allStatsDAO=db.allStatsDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }
    }

}
