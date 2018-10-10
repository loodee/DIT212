package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.editdeck.EditNoteView;

public class EditNotePresenter implements Presenter {
    private EditNoteView view;
    private Deck deck;
    private int noteIndex;
    private UserStorage store;

    public EditNotePresenter(EditNoteView view, int noteIndex, int deckIndex, String filepath) {
        this.view = view;
        this.deck = MemorizationTrainingTool.getInstance().getActiveUser().getDeck(deckIndex);
        this.noteIndex = noteIndex;
        this.store = new LocalUserStorage(filepath);
    }

    @Override
    public void onCreate() {
        if (noteIndex != -1) {
            if (deck.getNote(noteIndex) instanceof BasicNote) {
                BasicNote note = ((BasicNote) deck.getNote(noteIndex));
                view.setValues(note.getFront(), note.getBack());
            }
        }
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
     *
     * @param input String value to be validated
     * @return true if the string contains only whitespaces, false otherwise
     */
    public boolean invalidInput(String input) {
        return input.replaceAll("\\s", "").isEmpty();
    }

    /**
     * @param front     String value to go on the front of the card.
     * @param back      String value to go on the back of the card.
     * @param isEditing true if editing an existing Note, false if creating a new Note,
     */
    public void confirmAddClicked(String front, String back, boolean isEditing) {
        boolean valid = true;
        if (invalidInput(front)) valid = false;
        else if (invalidInput(back)) valid = false;

        if (valid) {
            if (isEditing) {
                deck.addBasicNote(front, back, noteIndex);
                view.selfDestruct();
            } else {
                deck.addBasicNote(front, back);
                view.resetInputs();
            }
            store.storeState(MemorizationTrainingTool.getInstance());
            view.showToast();
        } else {
            view.showErrors();
        }
    }
}
