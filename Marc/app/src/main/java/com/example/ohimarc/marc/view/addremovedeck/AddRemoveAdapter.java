package com.example.ohimarc.marc.view.addremovedeck;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AddRemoveDeckPresenter;


public class AddRemoveAdapter extends RecyclerView.Adapter<AddRemoveDeckViewHolder>
{

    private final AddRemoveDeckPresenter presenter;

    public AddRemoveAdapter(AddRemoveDeckPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public AddRemoveDeckViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        return new AddRemoveDeckViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.content_choosing_deck, parent, false),presenter);
    }

    @Override
    public void onBindViewHolder(AddRemoveDeckViewHolder holder, int position) {
        presenter.onBindDeckListRowViewAtPosition(position, holder);

    }

    @Override
    public int getItemCount() {
        return presenter.getDeckListRowsCount();
    }


}
