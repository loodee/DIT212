package com.example.ohimarc.marc.view.editDeckView;


/**
 * @author Mathias Forsman (Sorchar on github)
 * <p>
 * Methods that will be in View/Presenter
 */
public interface EditDeckContract {
    /**
     * These are the methods that View has to implement
     */
    interface View {

        /**
         * notifies the list that changes have been made and updates the recyclerView
         */
        void updateDeckList();

        /**
         * this creates a popup when called upon, the popup is for deleting a card with given index
         *
         * @param index the card position in the recyclerView that has been long clicked
         */
        void promptForDeletion(int index);

        /**
         * With given index will start the editNote view
         *
         * @param index the card position in the recyclerView that has been clicked
         */
        void editCardInDeck(int index);
    }

    /**
     * These are the methods that the presenter has to implement
     */
    interface Presenter {
        /**
         * Method in presenter that will be called from the view
         */
        void start();

        /**
         * handles setting up rows in the recyclerView
         *
         * @param rowView  holds everything regarding the object in a row
         * @param position is the index/position of a row in the recyclerView
         */
        void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder position, int rowView);


        /**
         * Used when the needed to get the amount of rows in the recyclerView
         *
         * @return the amount of rows in the deck(in our case amount of cards in deck)
         */
        int getCardRowsCount();

        /**
         * Handles events when user has clicked on a card with the index of a card that has been clicked
         *
         * @param adapterPosition is the index in the recyclerView that the user clicked at
         */
        void onUserClickedAtPosition(int adapterPosition);

        /**
         * Handles events when the user has longClicked a card with the index of the card that has been longClicked
         *
         * @param adapterPosition is the index in the recyclerView that the user long clicked at
         */
        void onUserLongClickedAtPosition(int adapterPosition);

        /**
         * gets the deckTitle from deck and returns it, responsible for communicating with the model regarding the deckTitle
         *
         * @return the title of the deck that is currently in "editing mode"
         */
        String getDeckTitle();

    }
}
