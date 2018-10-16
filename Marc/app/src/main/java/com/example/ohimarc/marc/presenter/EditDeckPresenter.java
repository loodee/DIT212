package com.example.ohimarc.marc.presenter;

import android.util.Log;

import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.editdeck.BasicNoteViewHolder;
import com.example.ohimarc.marc.view.editdeck.EditDeckActivity;
import com.example.ohimarc.marc.view.editdeck.EditDeckContract;

public class EditDeckPresenter implements EditDeckContract.Presenter {
    private Deck deck;
    private EditDeckActivity editDeckActivity;


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

    @Override
    public int getBasicNoteRowsCount() {
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
        editDeckActivity.promptForDeletion(deck.getNoteIndexFromCardIndex(adapterPosition), deck);
    }

    public void confirmDeletion(int index) {
        Log.d("IN CONFIRM DELETION:", "" + deck.getNoteIndexFromCardIndex(index));
        deck.deleteNote(index);
    }

}
