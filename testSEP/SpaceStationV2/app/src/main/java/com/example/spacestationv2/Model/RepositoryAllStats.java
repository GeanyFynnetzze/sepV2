package com.example.spacestationv2.Model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.spacestationv2.Database.AllStatsEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
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
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Retrofit retro = new Retrofit.Builder().baseUrl("https://datawebservice20200720021920.azurewebsites.net/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        api = retro.create(Api.class);
        myDateObj = LocalDateTime.now();
    }

    public MutableLiveData<List<AllStats>> getAllStats() {
        final MutableLiveData<List<AllStats>> allStatsData = new MutableLiveData<>();
        api.getAllStats().enqueue(new Callback<List<AllStats>>() {
            @Override
            public void onResponse(Call<List<AllStats>> call, Response<List<AllStats>> response) {
                Log.d("AllStatsFragment", "Status Code = " + response.code());
                if (response.isSuccessful()) {
                    allStatsData.setValue(response.body());
                    System.out.println(response.body().get(0).getCO2_value());
                }
            }

            @Override
            public void onFailure(Call<List<AllStats>> call, Throwable t) {

                System.out.println(t.getMessage());

                //  view.setText("error " + t.toString() + "\n" + call.request().toString());
            }
        });
        return allStatsData;
    }
}