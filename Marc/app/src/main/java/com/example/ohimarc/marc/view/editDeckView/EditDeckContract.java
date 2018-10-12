package com.example.ohimarc.marc.view.editDeckView;

import com.example.ohimarc.marc.model.Deck;

public interface EditDeckContract {
    interface View {
        void updateDeckList();

        void deckTitles();

        void promptForDeletion(int index, Deck deck);

        void editCardInDeck(int index);
    }

    interface Presenter {
        void start();

        void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder position, int rowView);

        int getBasicNoteRowsCount();

        void onUserClickedAtPosition(int adapterPosition);

        void onUserLongClickedAtPosition(int adapterPosition);
    }
}
