package com.example.spacestationv2.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacestationv2.Database.AllStatsEntity;
import com.example.spacestationv2.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapterAllStats extends RecyclerView.Adapter<RecycleAdapterAllStats.MyviewHolder> {
    private Context context;
    private List<AllStatsEntity> allStats = new ArrayList<>();

    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_adapter, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterAllStats.MyviewHolder holder, int position) {
        AllStatsEntity currentList = allStats.get(position);

        holder.humidityValue.setText("Humidity : " + currentList.getHuM_value() + " g/m^3");
        holder.co2Value.setText("CO2 : " + currentList.getCO2_value()+ " ppm");
        holder.temperatureValue.setText("Temperature: " + currentList.getTemP_value()+ " °C");
        holder.allStatsDate.setText("Date : " + currentList.getDate1().substring(0,10) + " - "
                                    + currentList.getDate1().substring(12, currentList.getDate1().length()));

    }

    public RecycleAdapterAllStats(Context context, List<AllStatsEntity> allStats) {
        this.context = context;
        this.allStats = allStats;
    }

    public void setAllStatsEntities(List<AllStatsEntity> allStats) {
        this.allStats = allStats;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (allStats != null)
            return allStats.size();
        return 0;
    }

    static class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView co2Value;
        private TextView humidityValue ;
        private TextView temperatureValue;
        private TextView allStatsDate;



        public MyviewHolder(View itemView) {
            super(itemView);
            temperatureValue=itemView.findViewById(R.id.textview4);
            humidityValue = itemView.findViewById(R.id.textview3);
            co2Value = itemView.findViewById(R.id.textview2);
            allStatsDate = itemView.findViewById(R.id.textview1);

        }
    }
}