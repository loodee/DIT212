package com.example.ohimarc.marc.view.choosingDeck;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ChoosingDeckPresenter;


public class ChoosingDeckAdapter extends RecyclerView.Adapter<ChoosingDeckViewHolder> {

    private final ChoosingDeckPresenter presenter;

    public ChoosingDeckAdapter(ChoosingDeckPresenter presenter) {this.presenter = presenter;}

    @Override
    public ChoosingDeckViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new ChoosingDeckViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.content_add_remove_deck, parent, false),presenter);
    }


    @Override
    public void onBindViewHolder(ChoosingDeckViewHolder holder, int position) {
        presenter.onBindDeckListRowViewAtPosition(position, holder);

    }

    @Override
    public int getItemCount() {
        return presenter.getDeckListRowsCount();
    }
}
