package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.choosingDeck.ChoosingDeckView;
import com.example.ohimarc.marc.view.choosingDeck.ChoosingDeckViewHolder;

import java.util.List;

public class ChoosingDeckPresenter implements Presenter {

    private List<String> deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    private ChoosingDeckView view;

    public ChoosingDeckPresenter(ChoosingDeckView view){
        this.view = view;
    }
    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

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
