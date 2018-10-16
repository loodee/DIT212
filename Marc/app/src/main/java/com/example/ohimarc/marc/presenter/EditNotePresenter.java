package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.ClozeNote;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.editDeckView.EditNoteView;

public class EditNotePresenter {
    private EditNoteView view;
    private Deck deck;
    private int noteIndex;
    private UserStorage store;

    public EditNotePresenter(EditNoteView view, int noteIndex, int deckIndex, String filepath) {
        this.view = view;
        this.deck = MemorizationTrainingTool.getInstance().getActiveUser().getDeck(deckIndex);
        this.noteIndex = noteIndex;
        this.store = new LocalUserStorage(filepath);
        onCreate();
    }

    public void onCreate() {
        if (noteIndex != -1) {
            if (deck.getNote(noteIndex) instanceof BasicNote) {
                BasicNote note = ((BasicNote) deck.getNote(noteIndex));
                view.setupBasic(note.getFront(), note.getBack());
            } else if (deck.getNote(noteIndex) instanceof ClozeNote) {
                ClozeNote note = ((ClozeNote) deck.getNote(noteIndex));
                view.setupCloze(note.getText());
            }
        }
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
     * Checks if the input string is an invalid cloze text (contains no cloze deletions).
     *
     * @param input String value to be validated
     * @return true if the string contains no cloze deletions false otherwise
     */
    public boolean invalidInputCloze(String input) {
        return input.matches("(.*)\\Q[[\\E(.*)\\Q::\\E(.*)\\Q]]\\E(.*)");
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

    public void confirmAddClicked(String text, boolean isEditing) {
        boolean valid = true;
        if (invalidInput(text)) valid = false;

        if (valid) {
            if (isEditing) {
                deck.addClozeNote(text, noteIndex);
                view.selfDestruct();
            } else {
                deck.addClozeNote(text);
                view.resetInputs();
            }
        }
    }
}
