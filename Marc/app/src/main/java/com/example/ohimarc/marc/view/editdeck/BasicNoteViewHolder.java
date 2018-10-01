package com.example.ohimarc.marc.view.editdeck;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.ohimarc.marc.R;

public class BasicNoteViewHolder extends RecyclerView.ViewHolder {

    private EditText basicNoteText;

    public BasicNoteViewHolder(@NonNull View itemView) {
        super(itemView);
        basicNoteText = itemView.findViewById(R.id.et_front_basic_note);
        basicNoteText = itemView.findViewById(R.id.et_back_basic_note);
    }

    public void setBasicNoteText(String text) {
        basicNoteText.setText(text);
    }
}
