package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.StaticTestDeck;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.view.AddNoteView;

public class AddNotePresenter implements Presenter {
    private AddNoteView view;
    private Deck deck = StaticTestDeck.globalDeck;

    public AddNotePresenter(AddNoteView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void confirmAddClicked(String front, String back) {
        deck.addBasicNote(front, back);
        resetInputs();
        view.showToast();
    }

    private void resetInputs() {
        view.clearInputs();
        view.resetFocus();
    }
}
