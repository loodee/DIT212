package com.example.ohimarc.marc.view.editDeckView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;

/**
 * @author Mathias Forsman (Sorchar on github)
 */

/**
 * Sets up every row in the recyclerView with given objects
 */

class AdapterEditDeckRC extends RecyclerView.Adapter<BasicNoteViewHolder> {

    private final EditDeckContract.Presenter presenter;

    /**
     * Given a presenter this AdapterClass will have a communication link with the given presenter
     *
     * @param presenter is given presenter that will communicate with the Adapter
     */
    AdapterEditDeckRC(EditDeckContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Creates the viewHolder for every single item inside the recyclerView
     *
     * @param viewGroup is the viewHolder in the recyclerView
     * @param i         is the index that the viewHolder will be in the recyclerView
     * @return the viewHolder on a specific row inside the recyclerView
     */
    @NonNull
    @Override
    public BasicNoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BasicNoteViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_basic_note, viewGroup, false), presenter);
    }

    /**
     * Attaches a viewHolder to an item inside the recyclerView
     *
     * @param basicNoteViewHolder is the viewHolder for the items inside the recyclerView
     * @param i                   the position of the item inside of the recyclerView
     */
    @Override
    public void onBindViewHolder(@NonNull BasicNoteViewHolder basicNoteViewHolder, int i) {
        presenter.onBindBasicNoteRowViewAtPosition(basicNoteViewHolder, i);
    }

    /**
     * Used when the needed to know the amount of items in the recyclerView
     *
     * @return the amount of items in the recyclerView
     */
    @Override
    public int getItemCount() {
        return presenter.getCardRowsCount();
    }
}
