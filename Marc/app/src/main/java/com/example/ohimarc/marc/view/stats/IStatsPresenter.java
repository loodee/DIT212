package com.example.ohimarc.marc.view.stats;

public interface IStatsPresenter {

    void onBindBasicNoteRowViewAtPosition(StatsViewHolder rowView, int position);

    int getStatRowsCount();

}
