package com.example.ohimarc.marc.view.editdeck;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.ohimarc.marc.R;

public class BasicNoteViewHolder extends RecyclerView.ViewHolder {

    private EditText basicNoteTextFront;
    private EditText basicNoteTextBack;

    public BasicNoteViewHolder(@NonNull View itemView) {
        super(itemView);
        basicNoteTextFront = itemView.findViewById(R.id.et_front_basic_note);
        basicNoteTextBack = itemView.findViewById(R.id.et_back_basic_note);
    }

    public void setBasicNoteText(String frontText, String backText) {
        basicNoteTextFront.setText(frontText);
        basicNoteTextBack.setText(backText);

    }
}
