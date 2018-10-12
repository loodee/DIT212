package com.example.ohimarc.marc.view.choosingDeckView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ChoosingDeckPresenter;

/**
 * @author  Victor Johansson (Vroxie on github)
 */
public class ChoosingDeckAdapter extends RecyclerView.Adapter<ChoosingDeckViewHolder> {

    /**
     * This class is the adapter for the recyclerview in the screen where you choose
     *  a deck you want to play.
     *  It chooses what should contain in the recyclerview
     */
    private final ChoosingDeckPresenter presenter;

    public ChoosingDeckAdapter(ChoosingDeckPresenter presenter) {this.presenter = presenter;}

    /**
     * Creates a viewholder for each item in the recyclerview
     * @param parent the Viewholder for the recyclerview
     * @param viewType
     * @return the new viewholder for a item in the recylcerview
     */
    @Override
    public ChoosingDeckViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new ChoosingDeckViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.content_add_remove_deck, parent, false),presenter);
    }


    /**
     * Binds a viewholder to a item in the recyclerview
     * @param holder the viewholder for the item
     * @param position the item
     */
    @Override
    public void onBindViewHolder(ChoosingDeckViewHolder holder, int position) {
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
