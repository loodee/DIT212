package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.Stat;
import com.example.ohimarc.marc.view.statsView.StatsViewHolder;

/**
 * @author Gustav Albertsson
 *
 * This class is responsible for the handling communication between StatsActivity and the model
 * */
public class StatsPresenter {

    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();

    /**
     * Method for setting up one row of the recyclerView
     * @param position The position of the row in the recyclerView
     * @param rowView The StatsViewHolder object which holds the information for that row
     * */
    public void onBindStatsRowViewAtPosition(StatsViewHolder rowView, int position) {
        rowView.setDeckTitle(mtt.getActiveUser().getDeck(position).getTitle());

        //For every stat
        for (Stat stat : mtt.getActiveUser().getStatsForDeck(position)) {
            rowView.addGameMode(stat.getGameMode(), stat.getHighScore(), stat.getTimesPlayed(), stat.getAverageScore());
        }
    }

    /**
     * Method for getting how many rows there should be in the statistics view
     * @return The number of rows there should be in the statistics view
     * */
    public int getStatRowsCount() {
        return mtt.getActiveUser().getDeckTitles().size();
    }
}
