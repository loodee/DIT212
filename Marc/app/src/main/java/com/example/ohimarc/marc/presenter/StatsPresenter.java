package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.Stat;
import com.example.ohimarc.marc.view.stats.IStatsPresenter;
import com.example.ohimarc.marc.view.stats.StatsView;
import com.example.ohimarc.marc.view.stats.StatsViewHolder;

public class StatsPresenter implements IStatsPresenter {

    private StatsView view;
    private MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();

    public StatsPresenter(StatsView view){
        this.view = view;
    }

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

        /*int counts = 0;

        for (int i = 0; i < mtt.getActiveUser().getDeckTitles().size(); i++) {
            Stat[] stats = mtt.getActiveUser().getStatsForDeck(i);

            if(stats != null) {
                counts += mtt.getActiveUser().getStatsForDeck(i).length;
            }
        }

        return counts;*/
    }
}
