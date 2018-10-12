package com.example.ohimarc.marc.view.stats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.StatsPresenter;


public class StatsActivity extends AppCompatActivity implements StatsView {

    private StatsPresenter statsPresenter;
    private AdapterStatsRC adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.activity_toolbar));

        statsPresenter = new StatsPresenter(this);

        RecyclerView rv = findViewById(R.id.statsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        adapter = new AdapterStatsRC(statsPresenter);

        rv.setAdapter(adapter);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }
}