package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Deck;

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

    @Test
    public void deleteNotes() {
        String front1 = "front1";
        String back1 = "back1";
        String front2 = "front2";
        String back2 = "back2";
        String front3 = "front3";
        String back3 = "back3";
        String front4 = "front4";
        String back4 = "back4";

        d.addBasicNote(front1, back1);
        d.addBasicNote(front2, back2);
        d.addBasicNote(front3, back3);
        d.addBasicNote(front4, back4);

        d.deleteNote(2);
        assertEquals(3, d.getDeckSize());

        String[][] cardCopies = d.getCardCopies();

        assertEquals(cardCopies[2][0], front4);

        int cardIndex = 1;
        int noteIndex = d.getNoteIndexFromCardIndex(cardIndex);

        assertEquals(cardCopies[cardIndex][0], cardCopies[noteIndex][0]);
    }

    @Test
    public void testGets() {
        d.addBasicNote("front 1", "front2");
        boolean b1 = d.getNote(0).getCards()[0].getFront().equals("front 1");
        boolean b2 = d.getNotes().size() == 1;
        assertTrue(b1 && b2);
    }

    @Test
    public void addBasicNote() {
        d.addBasicNote("front1", "back1");
        boolean b1 = d.getNote(0).getCards()[0].getFront().equals("front1");
        d.addBasicNote("frontNew", "backNew", 0);
        boolean b2 = d.getNote(0).getCards()[0].getFront().equals("frontNew");
        assertTrue(b1 && b2);
    }

    @Test
    public void addClozeNote() {
        String cloze1 = "[[c1::cloze1]] cloze1vis";
        d.addClozeNote(cloze1);
        d.addClozeNote("cloze2");
        boolean correctSize = d.getDeckSize() == 1;
        boolean correctCardFront = d.getNote(0).getCards()[0].getFront().equals("[..] cloze1vis");
        boolean correctCardBack = d.getNote(0).getCards()[0].getBack().equals("cloze1 cloze1vis");
        assertTrue(correctSize);
        assertTrue(correctCardFront);
        assertTrue(correctCardBack);
    }

    @Test
    public void replaceClozeNote() {
        String cloze1 = "[[c1::cloze1]] cloze1vis";
        String cloze2 = "back [[c1::pack]]";
        String cloze3 = "[[c1::try this]]";
        String cloze4 = "replacement [[c1::clozer]]";
        d.addClozeNote(cloze1);
        d.addClozeNote(cloze2);
        d.addClozeNote(cloze3);
        d.addClozeNote(cloze4, 1);
        assertEquals(d.getNote(1).getCards()[0].getBack(), "replacement clozer");
    }

    @Test
    public void inValidIndex() {
        d.addBasicNote("front1", "back1");
        int index = d.getNoteIndexFromCardIndex(-1);
        assertEquals(-1, index);
    }
}