package com.example.ohimarc.marc.view.editDeckView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.R;

public class BasicNoteViewHolder extends RecyclerView.ViewHolder {

    private final TextView basicNoteTextFront;
    private final TextView basicNoteTextBack;

    BasicNoteViewHolder(@NonNull View itemView, final EditDeckContract.Presenter presenter) {
        super(itemView);
        basicNoteTextFront = itemView.findViewById(R.id.tv_front_basic_note);
        basicNoteTextBack = itemView.findViewById(R.id.tv_back_basic_note);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                presenter.onUserLongClickedAtPosition(getAdapterPosition());
                return true;
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onUserClickedAtPosition(getAdapterPosition());
            }
        });

    }

    public void setBasicNoteText(String frontText, String backText) {
        basicNoteTextFront.setText(frontText);
        basicNoteTextBack.setText(backText);
    }

}
