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
    public void addBasicNotes() {
        String front1 = "front of card 1";
        String back1 = "back of card 1";
        d.addBasicNote(front1, back1);

        assertEquals(1, d.getDeckSize());
        assertEquals(front1, d.getCardCopies()[0][0]);
        assertEquals(back1, d.getCardCopies()[0][1]);

        String front2 = "frontTwo";
        String back2 = "backTwo";
        d.addBasicNote(front2, back2);

        assertEquals(2, d.getDeckSize());
        assertEquals(front2, d.getCardCopies()[1][0]);
        assertEquals(back2, d.getCardCopies()[1][1]);
    }
}
