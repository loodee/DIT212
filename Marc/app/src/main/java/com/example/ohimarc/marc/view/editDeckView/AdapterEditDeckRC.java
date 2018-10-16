package com.example.ohimarc.marc.view.editDeckView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;

class AdapterEditDeckRC extends RecyclerView.Adapter<BasicNoteViewHolder> {

    private final EditDeckContract.Presenter presenter;

    AdapterEditDeckRC(EditDeckContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Creates the viewHolder for every single item inside the recyclerView
     *
     * @param viewGroup is the viewHolder in the recyclerView
     * @param i         the index for the viewHolder
     * @return the new ViewHolder for the new item in the recyclerView
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
     * @param i                   the position of the item inside of the recycleRView
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
