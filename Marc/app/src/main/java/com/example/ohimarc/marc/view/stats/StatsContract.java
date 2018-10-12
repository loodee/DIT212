package com.example.ohimarc.marc.view.stats;

public interface StatsContract {
    interface Presenter {
        void start();

        void onBindBasicNoteRowViewAtPosition(StatsViewHolder rowView, int position);

        int getStatRowsCount();

    }
}
