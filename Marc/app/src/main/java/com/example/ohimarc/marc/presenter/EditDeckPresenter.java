package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.editDeckView.BasicNoteViewHolder;
import com.example.ohimarc.marc.view.editDeckView.EditDeckActivity;
import com.example.ohimarc.marc.view.editDeckView.EditDeckContract;

public class EditDeckPresenter implements EditDeckContract.Presenter {
    private final Deck deck;
    private final EditDeckActivity editDeckActivity;


    public EditDeckPresenter(EditDeckActivity a, int deckIndex) {
        this.editDeckActivity = a;
        this.deck = MemorizationTrainingTool.getInstance().getActiveUser().getDeck(deckIndex);
    }

    @Override
    public void start() {
        editDeckActivity.updateDeckList();
    }

    @Override
    public void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder rowView, int position) {
        BasicNote basicNote = (BasicNote) deck.getNotes().get(position);
        rowView.setBasicNoteText(basicNote.getFront(), basicNote.getBack());
    }

    /** Used when the needed to get the amount of objects inside of deck(size)
     *
     * @return the amount of cards in deck
     */
    @Override
    public int getCardRowsCount() {
        return deck.getDeckSize();
    }

    /**
     *
     * @param adapterPosition is the index in the recyclerView that the user clicked at
     */
    @Override
    public void onUserClickedAtPosition(int adapterPosition) {
        editDeckActivity.editCardInDeck(deck.getNoteIndexFromCardIndex(adapterPosition));
    }

    /**
     *
     * @param adapterPosition is the index in the recyclerView that the user long clicked at
     */
    @Override
    public void onUserLongClickedAtPosition(int adapterPosition) {
        editDeckActivity.promptForDeletion(deck.getNoteIndexFromCardIndex(adapterPosition));
    }

    /** gets the deckTitle from deck and returns it
     *
     * @return the title of the deck that is currently in "editing mode"
     */
    @Override
    public String getDeckTitle() {
        return deck.getTitle();
    }

    /**
     * @param index is the card in the list that will get deleted
     */
    public void confirmDeletion(int index) {
        deck.deleteNote(index);
    }
}
