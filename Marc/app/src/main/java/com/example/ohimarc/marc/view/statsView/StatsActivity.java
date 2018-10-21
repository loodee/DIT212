package com.example.ohimarc.marc.view.statsView;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.StatsPresenter;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

/**
 * @author Gustav Albertsson
 * <p>
 * Activity that displays the statistics for a player in a RecyclerView
 */
public class StatsActivity extends ToolbarExtension {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        StatsPresenter statsPresenter = new StatsPresenter();

        RecyclerView rv = findViewById(R.id.statsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        AdapterStatsRC adapter = new AdapterStatsRC(statsPresenter);

        rv.setAdapter(adapter);

        initExtension(this, R.id.statsActivity, "Statistics");
    }
}