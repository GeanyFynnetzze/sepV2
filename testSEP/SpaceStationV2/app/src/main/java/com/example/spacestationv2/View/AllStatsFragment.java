package com.example.spacestationv2.View;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//Bar Chart
import com.example.spacestationv2.Database.AllStatsEntity;
import com.example.spacestationv2.Model.AllStats;
import com.example.spacestationv2.Model.RecycleAdapterAllStats;
import com.example.spacestationv2.Model.RepositoryAllStats;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.AllStatsViewModel;

import java.util.ArrayList;
import java.util.List;

public class AllStatsFragment extends Fragment {
    public Button spinButton;
    private List<AllStatsEntity> allStatsList;
    private RepositoryAllStats repositoryAllStats;
    private RecycleAdapterAllStats adapter;
    private AllStatsViewModel allStatsViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_all_stats, container, false);

        final List<AllStatsEntity> listOfEntities = new ArrayList<>();


        allStatsViewModel = ViewModelProviders.of(this).get(AllStatsViewModel.class);

        allStatsViewModel.init();

            allStatsViewModel.getAllStatsRepo().observe(this, new Observer<List<AllStats>>() {
                @Override
                public void onChanged(List<AllStats> allStats) {
                    for (int i = 0; i < allStats.size(); i++) {
                        AllStatsEntity statsEntity = new AllStatsEntity(allStats.get(i).huM_ID, allStats.get(i).cO2_ID,
                                allStats.get(i).temP_ID, allStats.get(i).date, allStats.get(i).huM_value,
                                allStats.get(i).cO2_value, allStats.get(i).temP_value);

                        
                        allStatsViewModel.insert(statsEntity);
                    }

                }
            });


        allStatsViewModel.getAllStatsEntities().observe(this, new Observer<List<AllStatsEntity>>() {
            @Override
            public void onChanged(List<AllStatsEntity> allStatsEntities) {
                adapter.setAllStatsEntities(allStatsEntities);
            }
        });

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecycleAdapterAllStats(getContext(), listOfEntities);
        recyclerView.setAdapter(adapter);



        return rootView;
    }
}

