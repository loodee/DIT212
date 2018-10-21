package com.example.ohimarc.marc.view.choosingDeckView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ChoosingDeckPresenter;

/**
 * @author  Victor Johansson (Vroxie on github)
 */

/**
 * This class is the viewholder for choosing a deck you want to play
 * Sets up view for each item in recycler view such as title etc.
 */
public class ChoosingDeckViewHolder extends RecyclerView.ViewHolder implements ChoosingDeckViewH {

    private final TextView titleTextView;

    /**
     * The constructor for the Viewholder for the recyclerview
     * @param itemView what view that needs a viewholder
     * @param presenter the presenter that a view creates, in order to know what to print out on screen
     */
    public ChoosingDeckViewHolder(View itemView, final ChoosingDeckPresenter presenter) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.deck_Title);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.deckClicked(getAdapterPosition());
            }
        });
    }

    /**
     * Sets the title of deck in the recyclerview
     * @param title the title of the deck
     */
    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }
}
