package com.example.spacestationv2.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

        holder.co2Image.setImageResource(R.drawable.ic_justworkco2);
        holder.humidityValue.setText("Hum Value : " + currentList.getHuM_value());
        holder.co2Value.setText("ValueCO2 : " + currentList.getCO2_value());
        holder.temperatureValue.setText("Value Temp: " + currentList.getTemP_value());
        holder.allStatsDate.setText("Date : " + currentList.getDate1());

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
        private ImageView co2Image;
        private TextView co2Value;
        private TextView humidityValue ;
        private TextView temperatureValue;
        private TextView allStatsDate;



        public MyviewHolder(View itemView) {
            super(itemView);
            co2Image = itemView.findViewById(R.id.imageview);
            temperatureValue=itemView.findViewById(R.id.textview4);
            humidityValue = itemView.findViewById(R.id.textview2);
            co2Value = itemView.findViewById(R.id.textview1);
            allStatsDate = itemView.findViewById(R.id.textview3);

        }
    }
}