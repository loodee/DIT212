package com.example.ohimarc.marc.view.mainMenu;

import android.support.v7.widget.RecyclerView;

public interface StartMenuContract {
    interface View {
        void setPresenter(StartMenuContract.Presenter presenter);

        void updateDeckList();

        void deckTitles();

        void editDeckTitle();
    }

    interface Presenter {
        void start();

        void onBindBasicNoteRowViewAtPosition(UserViewHolder rowView, int position);

        int getUserRowsCount();

    }
}
