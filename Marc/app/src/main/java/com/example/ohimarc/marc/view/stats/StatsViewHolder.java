package com.example.ohimarc.marc.view.stats;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ohimarc.marc.R;

public class StatsViewHolder extends RecyclerView.ViewHolder{

    private TextView deckTitle;
    private LinearLayout rowLayout;

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
        tv.setText(rowLayout.getContext().getString(R.string.stats_gamemode_text) + gameMode);
        rowLayout.addView(tv);

        tv = new TextView(rowLayout.getContext());
        tv.setText(rowLayout.getContext().getString(R.string.stats_highscore_text) + highScore);
        rowLayout.addView(tv);

        tv = new TextView(rowLayout.getContext());
        tv.setText("Times Played: " + timesPlayed);
        rowLayout.addView(tv);

        tv = new TextView(rowLayout.getContext());
        tv.setText("Average Score: " + averageScore);
        tv.setPadding(0,0,0,20);

        rowLayout.addView(tv);
    }
}
