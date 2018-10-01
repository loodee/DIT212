package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.view.editdeck.BasicNoteRowView;
import com.example.ohimarc.marc.view.editdeck.BasicNoteViewHolder;
import com.example.ohimarc.marc.view.editdeck.EditDeckContract;

public class EditDeckPresenter implements EditDeckContract.Presenter {


    private Deck deck;

    @Override
    public void start() {
        // TODO: Add presenter init logic
        deck = new Deck("Test");
        deck.addBasicNote("hej", "san"); // testing purposes
    }

    @Override
    public void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder position, int rowView) {

    }


    public void onBindBasicNoteRowViewAtPosition(BasicNoteRowView rowView, int position) {
        // TODO: Solve potential casting problem. The list must be BasicNotes or it will cause exception
        BasicNote basicNote = (BasicNote) deck.getNotes().get(position);
        rowView.setFrontText(basicNote.getFront());
        rowView.setBackText(basicNote.getBack());
    }

    @Override
    public int getBasicNoteRowsCount() {
        return deck.getDeckSize();
    }
}
