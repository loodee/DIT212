package com.example.ohimarc.marc.view.editdeck;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;

public class AdapterEditDeckRC extends RecyclerView.Adapter<BasicNoteViewHolder> {

    private final EditDeckContract.Presenter presenter;

    public AdapterEditDeckRC(EditDeckContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @NonNull
    @Override
    public BasicNoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BasicNoteViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_basic_note, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull BasicNoteViewHolder basicNoteViewHolder, int i) {
        presenter.onBindBasicNoteRowViewAtPosition(basicNoteViewHolder, i);

    }


    @Override
    public int getItemCount() {
        return presenter.getBasicNoteRowsCount();
    }
}
