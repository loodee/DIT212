package com.example.ohimarc.marc.view.addRemoveDeckView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AddRemoveDeckPresenter;


/**
 * @author Victor Johansson (Vroxie on github)
 */
public class AddRemoveAdapter extends RecyclerView.Adapter<AddRemoveDeckViewHolder>
{

    private final AddRemoveDeckPresenter presenter;

    public AddRemoveAdapter(AddRemoveDeckPresenter presenter){
        this.presenter = presenter;
    }

    /**
     * Creates a viewholder for each item in the recyclerview
     * @param parent the Viewholder for the recyclerview
     * @param viewType
     * @return the new viewholder for a item in the recylcerview
     */
    @Override
    public AddRemoveDeckViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        return new AddRemoveDeckViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.content_choosing_deck, parent, false),presenter);
    }

    /**
     * Binds a viewholder to a item in the recyclerview
     * @param holder the viewholder for the item
     * @param position the item
     */
    @Override
    public void onBindViewHolder(AddRemoveDeckViewHolder holder, int position) {
        presenter.onBindDeckListRowViewAtPosition(position, holder);

    }

    /**
     * Counts how many rows/items the recyclerview will contain
     * @return the amount of rows that the recycler will contain
     */
    @Override
    public int getItemCount() {
        return presenter.getDeckListRowsCount();
    }


}
