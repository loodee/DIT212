package com.example.ohimarc.marc.view.statsView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.StatsPresenter;

class AdapterStatsRC extends RecyclerView.Adapter<StatsViewHolder> {

    private final StatsPresenter presenter;

    public AdapterStatsRC(StatsPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public StatsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new StatsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_stat, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StatsViewHolder statsViewHolder, int i) {
        presenter.onBindStatsRowViewAtPosition(statsViewHolder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getStatRowsCount();
    }

}
