package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.addRemoveDeckView.AddDeckView;
import com.example.ohimarc.marc.view.addRemoveDeckView.AddRemoveDeckView;

import java.util.List;

 */
 * Author Victor Johansson (Vroxie on github)
/**
public class AddRemoveDeckPresenter {

    private List<String> deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    private AddDeckView view;
    private UserStorage userStorage;

    public AddRemoveDeckPresenter(AddDeckView view, String filePath) {
        this.view = view;
        userStorage = new LocalUserStorage(filePath);
    }

    /**
     * Binds a viewholder to a item in the recyclerview
     * @param rowView the viewholderfor the item
     * @param position the item
     */
    public void onBindDeckListRowViewAtPosition(int position, AddRemoveDeckView rowView) {
        rowView.setTitle(deckList.get(position));
    }

    /**
     * Counts how many rows/items the recyclerview will contain
     * @return the amount of rows that the recycler will contain
     */
    public int getDeckListRowsCount() {
        return deckList.size();
    }

    /**
     * Adds a deck to the list of decks and stores it in the device
     * @param deckTitle the title deck that is going to be added
     */
    public void addDeck(String deckTitle) {
        MemorizationTrainingTool.getInstance().getActiveUser().createNewDeck(deckTitle);
        userStorage.storeState(MemorizationTrainingTool.getInstance());
        deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    }

    /**
     * Deletes a deck in the list of decks and stores the change in the list
     * @param index which deck that should be deleted
     */
    public void deleteDeck(int index) {
        MemorizationTrainingTool.getInstance().getActiveUser().deleteDeck(index);
        userStorage.storeState(MemorizationTrainingTool.getInstance());
        deckList = MemorizationTrainingTool.getInstance().getActiveUser().getDeckTitles();
    }

    /**
     * Handles a click on the deck
     * Tells the view to run deckClicked(int adapterPostion)
     * Which is implemented in the viw that basically navigates the user to a new screen
     * Where the user can see the decks' cards/notes
     * @param adapterPosition which deck that has been clicked
     */
    public void deckClicked(int adapterPosition) {
        view.deckIsClicked(adapterPosition);
    }
}
