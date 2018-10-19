package com.example.ohimarc.marc.view.statsView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ohimarc.marc.R;

/**
 * @author Gustav Albertsson
 *
 * Class responsbile for holding the statistics for one deck in one row in the recyclerView
 * */
public class StatsViewHolder extends RecyclerView.ViewHolder {

    private final TextView deckTitle;
    private final LinearLayout rowLayout;


    public StatsViewHolder(@NonNull View itemView) {
        super(itemView);

        deckTitle = itemView.findViewById(R.id.deckTitle);
        rowLayout = itemView.findViewById(R.id.statistics_row);
    }

    /**
     * Method for setting the deck title text
     * @param title The title of the deck
     * */
    public void setDeckTitle(String title) {
        deckTitle.setText(title);
    }

    /**
     * Method for adding information about a game mode to the row
     * @param gameMode The game mode which the statistics is for
     * @param highScore The high score that the user has gotten for the game mode/deck combo
     * @param timesPlayed The total times that the user has played the game mode/deck combo
     * @param averageScore The average score that the user has gotten on the game mode/deck combo
     * */
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
