package com.example.ohimarc.marc.view.editDeckView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.R;

/**
 * @author Mathias Forsman (Sorchar on github)
 */

/**
 * This is the class that represents the viewHolder for viewing/editing/deleting cards inside of a deck
 * This sets up the view for every note inside of the recyclerView.
 */

public class BasicNoteViewHolder extends RecyclerView.ViewHolder {

    private final TextView basicNoteTextFront;
    private final TextView basicNoteTextBack;

    /**
     * Sets up the new ViewHolder every time called upon
     *
     * @param itemView  represents the given view, in this example front/back note
     * @param presenter handles information sent from this viewHolder
     */
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

    /**
     * Sets strings that will show on the front and back of the card
     *
     * @param frontText is the string that will be set on the front of the card
     * @param backText  is the string that will be set on the back of the card
     */
    public void setBasicNoteText(String frontText, String backText) {
        basicNoteTextFront.setText(frontText);
        basicNoteTextBack.setText(backText);
    }

}
