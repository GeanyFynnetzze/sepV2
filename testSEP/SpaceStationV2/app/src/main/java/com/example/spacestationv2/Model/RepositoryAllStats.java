package com.example.spacestationv2.Model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.spacestationv2.Database.AllStatsEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.spacestationv2.ViewModel.RestAdapter.getUnsafeOkHttpClient;

public class RepositoryAllStats {


    private Gson gson;
    private Api api;
    private LocalDateTime myDateObj;
    private static RepositoryAllStats instance;

    public static RepositoryAllStats getInstance() {
        if (instance == null) {
            instance = new RepositoryAllStats();
        }
        return instance;
    }

    public RepositoryAllStats() {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd' 'HH:mm:ss").create();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://datawebservice20200720021920.azurewebsites.net/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        api = retro.create(Api.class);
        myDateObj = LocalDateTime.now();
    }

    public MutableLiveData<List<AllStats>> getLivingRoom() {
        final MutableLiveData<List<AllStats>> allStatsData = new MutableLiveData<>();
        api.getLivingRoom().enqueue(new Callback<Rooms>() {
            @Override
            public void onResponse(Call<Rooms> call, Response<Rooms> response) {
                Log.d("AllStatsFragment", "Status Code = " + response.code());
                if (response.isSuccessful()) {
                    ArrayList<AllStats> sensors = response.body().getSensors().get(0).getData();
                    allStatsData.setValue(sensors);

                }
            }

            @Override
            public void onFailure(Call<Rooms> call, Throwable t) {

                System.out.println(t.getMessage());

            }
        });
        return allStatsData;
    }

    public MutableLiveData<List<AllStats>> getToilet() {
        final MutableLiveData<List<AllStats>> allStatsData = new MutableLiveData<>();
        api.getToilet().enqueue(new Callback<Rooms>() {
            @Override
            public void onResponse(Call<Rooms> call, Response<Rooms> response) {
                Log.d("AllStatsFragment", "Status Code = " + response.code());
                if (response.isSuccessful()) {
                    //Rooms rooms = response.body();
                    ArrayList<AllStats> sensors = response.body().getSensors().get(0).getData();
                    allStatsData.setValue(sensors);

                }
            }

            @Override
            public void onFailure(Call<Rooms> call, Throwable t) {

                System.out.println(t.getMessage());

            }
        });
        return allStatsData;
    }

    public MutableLiveData<List<AllStats>> getKitchen() {
        final MutableLiveData<List<AllStats>> allStatsData = new MutableLiveData<>();
        api.getKitchen().enqueue(new Callback<Rooms>() {
            @Override
            public void onResponse(Call<Rooms> call, Response<Rooms> response) {
                Log.d("AllStatsFragment", "Status Code = " + response.code());
                if (response.isSuccessful()) {
                    //Rooms rooms = response.body();
                    ArrayList<AllStats> sensors = response.body().getSensors().get(0).getData();
                    allStatsData.setValue(sensors);

                }
            }

            @Override
            public void onFailure(Call<Rooms> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
        return allStatsData;
    }
}