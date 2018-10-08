package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.view.addremovedeck.AddDeckView;
import com.example.ohimarc.marc.view.addremovedeck.AddRemoveDeckView;

import java.util.ArrayList;

public class AddRemoveDeckPresenter implements Presenter {

    private final ArrayList<Deck> deckList = new ArrayList<>();
    private AddDeckView view;
    private Deck testDeck = new Deck("TestDeck0");
    private Deck testDeck1 = new Deck("TestDeck1");
    private Deck testDeck2 = new Deck("TestDeck2");

    public AddRemoveDeckPresenter(AddDeckView view){
        this.view = view;
        deckList.add(testDeck);
        deckList.add(testDeck1);
        deckList.add(testDeck2);
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
        Deck deck = deckList.get(position);
        rowView.setTitle(deck.getTitle());
    }

    public int getDeckListRowsCount() {
        return deckList.size();
    }

    public void addDeck(String deckTitle){
        deckList.add(new Deck(deckTitle));
    }

    public void deleteDeck(int index){
        deckList.remove(index);
    }

    public void deckClicked(int adapterPosition) {
        String title = deckList.get(adapterPosition).getTitle();
        view.deckIsClicked(title);
    }
}
