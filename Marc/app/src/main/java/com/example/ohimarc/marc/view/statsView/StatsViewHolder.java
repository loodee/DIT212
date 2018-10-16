package com.example.ohimarc.marc.view.statsView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ohimarc.marc.R;

public class StatsViewHolder extends RecyclerView.ViewHolder {

    private final TextView deckTitle;
    private final LinearLayout rowLayout;

    public StatsViewHolder(@NonNull View itemView) {
        super(itemView);

        deckTitle = itemView.findViewById(R.id.deckTitle);
        rowLayout = itemView.findViewById(R.id.statistics_row);
    }

    public void setDeckTitle(String title) {
        deckTitle.setText(title);
    }

    public void addGameMode(String gameMode, int highScore, int timesPlayed, double averageScore) {
        TextView tv = new TextView(rowLayout.getContext());
        tv.setText(rowLayout.getContext().getString(R.string.stats_gameMode_text) + gameMode);
        tv.setPadding(20,0,0,0);
        rowLayout.addView(tv);

        tv = new TextView(rowLayout.getContext());
        tv.setText(rowLayout.getContext().getString(R.string.stats_highScore_text) + highScore);
        tv.setPadding(20,0,0,0);
        rowLayout.addView(tv);

        tv = new TextView(rowLayout.getContext());
        tv.setText(rowLayout.getContext().getString(R.string.stats_timesPlayed_text) + timesPlayed);
        tv.setPadding(20,0,0,0);
        rowLayout.addView(tv);

        tv = new TextView(rowLayout.getContext());
        tv.setText("Average Score: " + averageScore);
        tv.setPadding(20,0,0,20);

        rowLayout.addView(tv);
    }
}
