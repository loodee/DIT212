package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.stats.StatsContract;
import com.example.ohimarc.marc.view.stats.StatsView;
import com.example.ohimarc.marc.view.stats.StatsViewHolder;

public class StatsPresenter implements Presenter, StatsContract.Presenter{

    private StatsView view;
    private MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();

    public StatsPresenter(StatsView view){
        this.view = view;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void start() {

    }

    @Override
    public void onBindBasicNoteRowViewAtPosition(StatsViewHolder rowView, int position) {
        rowView.setDeckTitle(mtt.getActiveUser().getDeck(position).getTitle());
    }

    @Override
    public int getStatRowsCount() {
        return mtt.getActiveUser().getDeckTitles().size();
    }
}
