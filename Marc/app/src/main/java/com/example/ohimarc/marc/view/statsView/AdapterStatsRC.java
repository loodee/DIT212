package com.example.ohimarc.marc.view.statsView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.StatsPresenter;

/**
 * @author Gustav Albertson
 *
 * Class responsible for setting up the StatsViewHolders for the recycler view
 * */
class AdapterStatsRC extends RecyclerView.Adapter<StatsViewHolder> {

    private final StatsPresenter presenter;

    /**
     * Sets up a AdapterStatsRC with the given presenter to communicate with
     *
     * @param presenter The presenter in which the instance can communicate with
     */
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
