package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Deck;

public class StaticTestDeck {
    public static Deck globalDeck = new Deck("global test deck");

    public static void addFirst() {
        globalDeck.addBasicNote("first card front", "first card back");
    }
}
