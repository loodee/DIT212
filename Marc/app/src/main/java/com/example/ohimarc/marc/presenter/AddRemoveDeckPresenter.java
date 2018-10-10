package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.addremovedeck.AddDeckView;
import com.example.ohimarc.marc.view.addremovedeck.AddRemoveDeckView;

import java.util.List;

public class AddRemoveDeckPresenter implements Presenter {

    private List<String> deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    private AddDeckView view;
    private UserStorage userStorage;

    public AddRemoveDeckPresenter(AddDeckView view, String filePath) {
        this.view = view;
        userStorage = new LocalUserStorage(filePath);
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

    public void onBindDeckListRowViewAtPosition(int position, AddRemoveDeckView rowView) {
        rowView.setTitle(deckList.get(position));
    }

    public int getDeckListRowsCount() {
        return deckList.size();
    }

    public void addDeck(String deckTitle) {
        MemorizationTrainingTool.getInstance().getActiveUser().createNewDeck(deckTitle);
        userStorage.storeState(MemorizationTrainingTool.getInstance());
        deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    }

    public void deleteDeck(int index) {
        MemorizationTrainingTool.getInstance().getActiveUser().deleteDeck(index);
        userStorage.storeState(MemorizationTrainingTool.getInstance());
        deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    }

    public void deckClicked(int adapterPosition) {
        view.deckIsClicked(adapterPosition);
    }
}
