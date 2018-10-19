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

        /** Creates the viewholder for every single item inside the recyclerview
         *
         * @param viewGroup is the viewholder in the recyclerview
         * @param i is not used but is required due to the interface that is being used for the method
         * @return
         */
    @NonNull
    @Override
    public BasicNoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BasicNoteViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_basic_note, viewGroup, false), presenter);
    }

        /** Attaches a viewholder to an item inside the recyclerview
         *
         * @param basicNoteViewHolder is the viewholder for the items inside the recyclerview
         * @param i the position of the item inside of the recyclerview
         */
    @Override
    public void onBindViewHolder(@NonNull BasicNoteViewHolder basicNoteViewHolder, int i) {
        presenter.onBindBasicNoteRowViewAtPosition(basicNoteViewHolder, i);
    }

        /**
         * Used when the needed to know the amount of items in the recyclerview
         * @return the amount of items in the recyclerview
         */
    @Override
    public int getItemCount() {
        return presenter.getCardRowsCount();
    }
}
