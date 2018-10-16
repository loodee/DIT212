package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.Stat;
import com.example.ohimarc.marc.view.statsView.IStatsPresenter;
import com.example.ohimarc.marc.view.statsView.StatsViewHolder;

public class StatsPresenter implements IStatsPresenter {

    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();

    @Override
    public void onBindBasicNoteRowViewAtPosition(StatsViewHolder rowView, int position) {
        rowView.setDeckTitle(mtt.getActiveUser().getDeck(position).getTitle());

        //For every stat
        for (Stat stat : mtt.getActiveUser().getStatsForDeck(position)) {
            rowView.addGameMode(stat.getGameMode(), stat.getHighScore(), stat.getTimesPlayed(), stat.getAverageScore());
        }
    }

    @Override
    public int getStatRowsCount() {
        return mtt.getActiveUser().getDeckTitles().size();
    }
}
