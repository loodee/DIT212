package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.*;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class FlashCardGameUnitTest {
    @Test
    public void testDeckNameIsEmpty() {
        Deck d = new Deck("Test");
        FlashCardGame g = new FlashCardGame(d);

        String[] s = g.peekNextCard();

        assertNull(s);
    }

    @Test
    public void testExistsOneCardWithFrontAndBack() {
        Deck d = new Deck("Test");
        d.addBasicNote("Front", "Back");

        FlashCardGame g = new FlashCardGame(d);

        String[] s = g.peekNextCard();

        assertEquals(s[0], "Front");
        assertEquals(s[1], "Back");
        TestCase.assertEquals(1, d.getDeckSize());
    }

    @Test
    public void testStepNextCard() {
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

    @Test
    public void testQuestionAnswerSize() {
        Deck d = new Deck("Test");
        d.addBasicNote("Front1", "Back1");
        d.addBasicNote("Front2", "Back2");
        d.addBasicNote("Front3", "Back3");
        FlashCardGame g = new FlashCardGame(d);
        assertEquals(g.getDecksize(), g.getQuestionAns().length);
    }

    @Test
    public void testQuestionAnsAnswers() {
        Deck d = new Deck("Test");
        d.addBasicNote("Front1", "Back1");
        d.addBasicNote("Front2", "Back2");
        d.addBasicNote("Front3", "Back3");
        FlashCardGame g = new FlashCardGame(d);
        g.questionAnswer(0, true);
        g.questionAnswer(1, false);

        assertEquals(g.getQuestionAns()[0].getElement1(), true);
        assertEquals(g.getQuestionAns()[1].getElement1(), false);
        Assert.assertNull(g.getQuestionAns()[2]);
    }

}
