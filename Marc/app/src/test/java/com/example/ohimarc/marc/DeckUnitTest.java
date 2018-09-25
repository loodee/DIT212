package com.example.ohimarc.marc;

import com.example.ohimarc.marc.models.Deck;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckUnitTest {
    Deck d;
    String title = "testing title";

    @Before
    public void createEmptyDeck() {
        String title = "testing title";
        d = new Deck(title);
    }

    @Test
    public void checkNewDeckIsEmpty() {
        assertEquals(title, d.getTitle());
        assertEquals(0, d.getDeckSize());
    }

    @Test
    public void addCardToDeck() {
        String card1front = "front of card 1";
        String card1back = "back of card 1";
        d.addCard(card1front, card1back);

        assertEquals(1, d.getDeckSize());
        assertEquals(card1front, d.getCardInfo(0)[0]);
        assertEquals(card1back, d.getCardInfo(0)[1]);
    }
}
