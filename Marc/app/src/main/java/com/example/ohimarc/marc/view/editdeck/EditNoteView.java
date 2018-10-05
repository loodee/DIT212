package com.example.ohimarc.marc.view.editdeck;

import android.view.View;

public interface EditNoteView {
    void confirmAdd(View v);

    void resetInputs();

    void showToast();

    void showErrors();

    void setValues(String front, String back);

    void selfDestruct();
}
