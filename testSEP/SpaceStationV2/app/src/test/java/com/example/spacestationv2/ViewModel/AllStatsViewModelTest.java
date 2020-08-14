package com.example.spacestationv2.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.spacestationv2.API.Api;
import com.example.spacestationv2.API.RepositoryAllStats;
import com.example.spacestationv2.Database.AllStatsRepositoryData;
import com.example.spacestationv2.Model.AllStats;
import com.example.spacestationv2.Model.Rooms;
import com.example.spacestationv2.Model.Sensors;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.spacestationv2.API.RestAdapter.getUnsafeOkHttpClient;
import static org.junit.Assert.*;

public class AllStatsViewModelTest extends Fragment {
    private Api api;
    private Gson gson;
    private ArrayList<Sensors> sensors;

    @Before
    public void setUp() throws Exception {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd' 'HH:mm:ss").create();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://datawebservice20200720021920.azurewebsites.net/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        api = retro.create(Api.class);
        System.out.println("Works?");

    }

    @Test
    public void initLivingRoom() throws IOException {

        Response<Rooms> response = api.getLivingRoom().execute();
        Rooms rooms = response.body();
        sensors=rooms.getSensors();
        System.out.println(sensors.get(0).getData().get(0).getCO2_value());
        assertEquals(88.0,sensors.get(0).getData().get(0).getCO2_value(),0.0);
    }

    @Test
    public void initKitchen() throws IOException {

        Response<Rooms> response = api.getKitchen().execute();
        Rooms rooms = response.body();
        sensors=rooms.getSensors();
        System.out.println(sensors.get(0).getData().get(0).getHuM_value());
        assertEquals(46.0,sensors.get(0).getData().get(0).getHuM_value(),0.0);
    }
}