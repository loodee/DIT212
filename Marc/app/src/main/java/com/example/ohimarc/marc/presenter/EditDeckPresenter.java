package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.StaticTestDeck;
import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.view.editdeck.BasicNoteViewHolder;
import com.example.ohimarc.marc.view.editdeck.EditDeckActivity;
import com.example.ohimarc.marc.view.editdeck.EditDeckContract;

public class EditDeckPresenter implements EditDeckContract.Presenter {
    private Deck deck;
    private EditDeckActivity editDeckActivity;
    private EditDeckContract.View view;

    public EditDeckPresenter(EditDeckActivity a) {
        editDeckActivity = a;
        this.view = view;
    }

    @Override
    public void start() {
        // TODO: Add presenter init logic
        deck = StaticTestDeck.globalDeck;
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

    @Override
    public void onUserClickedAtPosition(int adapterPosition) {

    }

    @Override
    public void onUserLongClickedAtPosition(int adapterPosition) {
    }

    public void confirmDeletion(int index) {
    }

}
