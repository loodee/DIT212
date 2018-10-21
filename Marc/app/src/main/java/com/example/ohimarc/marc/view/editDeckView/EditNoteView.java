package com.example.ohimarc.marc.view.editDeckView;

import android.view.View;

/**
 * @author Thomas Li
 */
public interface EditNoteView {
    /**
     * Called when the user saves a Note, attempts to save the Note with the edited values.
     *
     * @param v The view of the related Activity.
     */
    void confirmAdd(View v);

    /**
     * Called to clear the text input fields, as well as redirect focus to the topmost field.
     */
    void resetInputs();

    /**
     * Called to display the toast confirming the addition of a Note.
     */
    void showToast();

    /**
     * Called to give visual feedback regarding errors when the user's input is detected as invalid.
     */
    void showErrors();

    /**
     * Prepares the activity with the appropriate fields and values to edit an existing BasicNote.
     *
     * @param front The text to pre-fill the `front` input field with.
     * @param back  The text to pre-fill the `back` input field with.
     */
    void setupBasic(String front, String back);

    /**
     * Prepares the activity with the appropriate fields and values to edit an existing ClozeNote.
     *
     * @param text The text to pre-fill the `text` input with.
     */
    void setupCloze(String text);

    /**
     * Prepares the activity with the appropriate fields and values to create a new Note.
     */
    void setupNew();

    /**
     * Called to close the activity and return to the previous screen.
     */
    void selfDestruct();
}
