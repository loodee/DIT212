package com.example.ohimarc.marc.view.editdeck;

import android.view.View;

import com.example.ohimarc.marc.model.Deck;

public interface EditDeckContract {
    interface View {
        void setPresenter(EditDeckContract.Presenter presenter);

        void updateDeckList();

        void deckTitles();

        void editDeckTitle();

        void promptForDeletion(int index, Deck deck);
    }

    interface Presenter {
        void start();

        void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder position, int rowView);

        int getBasicNoteRowsCount();

        void onUserClickedAtPosition(int adapterPosition);

        void onUserLongClickedAtPosition(int adapterPosition);

    }
}
