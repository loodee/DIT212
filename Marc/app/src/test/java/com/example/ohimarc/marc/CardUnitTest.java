package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardUnitTest {
    @Test
    public void createCard() {
        Card c = new Card("Front", "Back");

        assertEquals(c.getFront(), "Front");
        assertEquals(c.getBack(), "Back");
    }

    @Test
    public void createNullBack() {
        Card c = new Card("Front", null);

        assertEquals(c.getFront(), "Front");
        assertEquals(c.getBack(), "");
    }

    @Test
    public void createNullFront() {
        Card c = new Card(null, "Back");

        assertEquals(c.getFront(), "");
        assertEquals(c.getBack(), "Back");
    }

}
