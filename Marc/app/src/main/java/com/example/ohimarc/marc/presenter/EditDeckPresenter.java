package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.view.EditDeckView;

public class EditDeckPresenter {
    private Deck testDeck;

    public EditDeckPresenter(EditDeckView view){
        testDeck = new Deck("testdeck");
        testDeck.addBasicNote("hund (front)", "dog");

    }

    public String getDeckTitle() {
        return testDeck.getTitle();
    }

}
