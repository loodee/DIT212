package com.example.ohimarc.marc.view;

import android.view.View;

public interface AddNoteView {
    void confirmAdd(View v);
    void clearInputs();
    void resetFocus();
    void showToast();
}
