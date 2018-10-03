package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.StaticTestDeck;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.view.editdeck.AddNoteView;

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

    /**
     * Checks if the input string is invalid (contains only whitespaces)
     * @param input String value to be validated
     * @return true if the string contains only whitespaces, false otherwise
     */
    public boolean invalidInput(String input) {
        return input.replaceAll("\\s", "").isEmpty();
    }

    public void confirmAddClicked(String front, String back) {
        boolean valid = true;
        if (invalidInput(front)) valid = false;
        else if (invalidInput(back)) valid = false;

        if (valid) {
            deck.addBasicNote(front, back);
            view.resetInputs();
            view.showToast();
        } else {
            view.showErrors();
        }
    }
}
