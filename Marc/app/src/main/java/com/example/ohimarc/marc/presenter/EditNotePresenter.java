package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.ClozeNote;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.editDeckView.EditNoteView;

/**
 * Presenter responsible for handling user calls for updating the model by handling input validation
 * and deleting/adding notes in the model.
 *
 * @author Thomas Li
 */
public class EditNotePresenter {
    private EditNoteView view;
    private Deck deck;
    private int noteIndex;
    private UserStorage store;

    /**
     * Creates an EditNotePresenter which handles interaction from the user in the corresponding activity.
     *
     * @param view      Lists the methods that may be called from the presenter in the
     *                  corresponding activity. The activity should implement this activity.
     * @param noteIndex Specifies the index of the currently handled Note in the Deck. If the user
     *                  is adding a new Note rather than editing an existing one, this value will be < 0.
     * @param deckIndex Specifies the index of the currently handled Deck in the active User's collection.
     * @param filepath  Absolute filepath where the persistent state file of the app is saved.
     */
    public EditNotePresenter(EditNoteView view, int noteIndex, int deckIndex, String filepath) {
        this.view = view;
        this.deck = MemorizationTrainingTool.getInstance().getActiveUser().getDeck(deckIndex);
        this.noteIndex = noteIndex;
        this.store = new LocalUserStorage(filepath);
        onCreate();
    }

    /**
     * Sets the corresponding activity up with the correct environment, determining if editing an
     * existing Note or not, as well as the type of Note (Basic, Cloze).
     */
    public void onCreate() {
        if (noteIndex != -1) {
            if (deck.getNote(noteIndex) instanceof BasicNote) {
                BasicNote note = ((BasicNote) deck.getNote(noteIndex));
                view.setupBasic(note.getFront(), note.getBack());
            } else if (deck.getNote(noteIndex) instanceof ClozeNote) {
                ClozeNote note = ((ClozeNote) deck.getNote(noteIndex));
                view.setupCloze(note.getText());
            }
        } else {
            view.setupNew();
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
        return !input.matches("(.*)\\Q[[\\E(.*)\\Q::\\E(.*)\\Q]]\\E(.*)");
    }

    /**
     * Validates the input and saves the cloze note to the deck, or triggers an error if the input is invalid
     *
     * @param front     String value to go on the front of the card.
     * @param back      String value to go on the back of the card.
     * @param isEditing true if editing an existing Note, false if creating a new Note,
     */
    public void confirmAddBasicClicked(String front, String back, boolean isEditing) {
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
        } else view.showErrors();
    }

    /**
     * Validates the input and saves the cloze note to the deck, or triggers an error if the input is invalid
     *
     * @param text      String value to be parsed into cloze cards
     * @param isEditing true if editing an existing Note, false if creating a new Note
     */
    public void confirmAddClozeClicked(String text, boolean isEditing) {
        boolean valid = !invalidInputCloze(text);

        if (valid) {
            if (isEditing) {
                deck.addClozeNote(text, noteIndex);
                view.selfDestruct();
            } else {
                deck.addClozeNote(text);
                view.resetInputs();
            }
            store.storeState(MemorizationTrainingTool.getInstance());
            view.showToast();
        } else view.showErrors();
    }
}
