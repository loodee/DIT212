package com.example.ohimarc.marc.view.statsView;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.StatsPresenter;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;


public class StatsActivity extends ToolbarExtension implements StatsView {

    private StatsPresenter statsPresenter;
    private AdapterStatsRC adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        statsPresenter = new StatsPresenter(this);

        RecyclerView rv = findViewById(R.id.statsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        adapter = new AdapterStatsRC(statsPresenter);

        rv.setAdapter(adapter);

        initExtension(this, R.id.statsActivity,"Statistics");
    }
}