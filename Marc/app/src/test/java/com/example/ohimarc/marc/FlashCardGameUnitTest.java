package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.*;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class FlashCardGameUnitTest {
    @Test
    public void createEmptyFlashcardGame() {
        Deck d = new Deck("Test");
        FlashCardGame g = new FlashCardGame(d);

        String[] s = g.peekNextCard();

        assertTrue(s == null);
    }

    @Test
    public void createCard() {
        Deck d = new Deck("Test");
        d.addBasicNote("Front", "Back");

        FlashCardGame g = new FlashCardGame(d);

        String[] s = g.peekNextCard();

        assertEquals(s[0], "Front");
        assertEquals(s[1], "Back");
    }

    @Test
    public void createCards() {
        Deck d = new Deck("Test");
        d.addBasicNote("Front", "Back");

        FlashCardGame g = new FlashCardGame(d);

        String[] s = g.peekNextCard();

        assertEquals(s[0], "Front");
        assertEquals(s[1], "Back");
    }

    @Test
    public void stepNextCard() {
        Deck d = new Deck("Test");
        d.addBasicNote("Front", "Back");
        d.addBasicNote("Front1", "Back1");

        FlashCardGame g = new FlashCardGame(d);

        g.goToNextCard();
        String[] s = g.peekNextCard();

        assertEquals(s[0], "Front1");
        assertEquals(s[1], "Back1");
    }

    @Test
    public void addResult() {
        Deck d = new Deck("Test");
        d.addBasicNote("Front", "Back");
        d.addBasicNote("Front1", "Back1");
        FlashCardGame g = new FlashCardGame(d);
        g.questionAnswer(0, true);

        assertEquals(true, g.getQuestionAns()[0].getElement1());
        assertEquals(2, g.getQuestionAns().length);
        assertEquals(0, g.getQuestionAns()[0].getElement0());
    }

    @Test
    public void testGetters() {
        Deck d = new Deck("Test");
        d.addBasicNote("Front", "Back");
        d.addBasicNote("Front1", "Back1");
        FlashCardGame g = new FlashCardGame(d);

        assertEquals("Test", g.getDeckTitle());
        assertEquals(0, g.getNextCard());
        assertEquals(2, g.getDecksize());
        assertEquals("Flashcard Game", g.getName());
    }

}
