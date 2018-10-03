package com.example.ohimarc.marc.view.editdeck;

public interface EditDeckContract {
    interface View {
        void setPresenter(EditDeckContract.Presenter presenter);

        void updateDeckList();

        void deckTitles();

        void editDeckTitle();
    }

    interface Presenter {
        void start();

        void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder position, int rowView);

        int getBasicNoteRowsCount();

    }
}
