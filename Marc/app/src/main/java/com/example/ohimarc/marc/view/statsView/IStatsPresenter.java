package com.example.ohimarc.marc.view.statsView;

public interface IStatsPresenter {

    void onBindBasicNoteRowViewAtPosition(StatsViewHolder rowView, int position);

    int getStatRowsCount();

}
