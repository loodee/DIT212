package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.choosingDeckView.ChoosingDeckView;
import com.example.ohimarc.marc.view.choosingDeckView.ChoosingDeckViewHolder;

import java.util.List;

/**
 * Author Victor Johansson (Vroxie on github)
 */
public class ChoosingDeckPresenter {

    private List<String> deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    private ChoosingDeckView view;

    public ChoosingDeckPresenter(ChoosingDeckView view) {
        this.view = view;
    }

    /**
     * Binds a viewholder to a item in the recyclerview
     * @param rowView the viewholder for the item
     * @param position the item
     */
    public void onBindDeckListRowViewAtPosition(int position, ChoosingDeckViewHolder rowView) {
        rowView.setTitle(deckList.get(position));
    }

    /**
     * Counts how many rows/items the recyclerview will contain
     * @return the amount of rows that the recycler will contain
     */
    public int getDeckListRowsCount() {
        return deckList.size();
    }

    public void deckClicked(int adapterPosition) {
        view.deckIsClicked(adapterPosition);
    }
}
