package com.example.ohimarc.marc.view.editDeckView;

import android.view.View;

public interface EditNoteView {
    void confirmAdd(View v);

    void resetInputs();

    void showToast();

    void showErrors();

    void setupBasic(String front, String back);

    void setupCloze(String text);

    void selfDestruct();
}
