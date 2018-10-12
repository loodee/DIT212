package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.choosingDeckView.ChoosingDeckView;
import com.example.ohimarc.marc.view.choosingDeckView.ChoosingDeckViewHolder;

import java.util.List;

public class ChoosingDeckPresenter {

    private List<String> deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    private ChoosingDeckView view;

    public ChoosingDeckPresenter(ChoosingDeckView view) {
        this.view = view;
    }

    public void onBindDeckListRowViewAtPosition(int position, ChoosingDeckViewHolder rowView) {
        rowView.setTitle(deckList.get(position));
    }

    public int getDeckListRowsCount() {
        return deckList.size();
    }

    public void deckClicked(int adapterPosition) {
        view.deckIsClicked(adapterPosition);
    }
}
