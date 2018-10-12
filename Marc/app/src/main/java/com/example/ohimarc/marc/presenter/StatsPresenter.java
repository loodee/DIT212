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

    }

    @Override
    public int getStatRowsCount() {
        int counts = 0;

        for (int i = 0; i < mtt.getActiveUser().getDeckTitles().size(); i++) {
            Stat[] stats = mtt.getActiveUser().getStatsForDeck(i);

            if(stats != null) {
                counts += mtt.getActiveUser().getStatsForDeck(i).length;
            }
        }

        return counts;
    }
}
