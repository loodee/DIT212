package com.example.ohimarc.marc.view.editDeckView;


public interface EditDeckContract {
    interface View {
        void updateDeckList();

        void promptForDeletion(int index);

        void editCardInDeck(int index);
    }

    interface Presenter {
        void start();

        void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder position, int rowView);

        int getCardRowsCount();

        void onUserClickedAtPosition(int adapterPosition);

        void onUserLongClickedAtPosition(int adapterPosition);


        String deckTitles();
    }
}
