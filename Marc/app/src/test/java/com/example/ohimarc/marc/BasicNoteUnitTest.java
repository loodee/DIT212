package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.Card;


import org.junit.Test;

import static org.junit.Assert.*;

public class BasicNoteUnitTest {
    private final BasicNote b = new BasicNote("Front", "Back");

    @Test
    public void createBasicNote() {
        assertEquals(b.getFront(), "Front");
        assertEquals(b.getBack(), "Back");
    }

    @Test
    public void emptyFront() {

        BasicNote b = new BasicNote(null, "Back");
        assertEquals(b.getFront(), "");
        assertEquals(b.getBack(), "Back");
    }

    @Test
    public void emptyBack() {

        BasicNote b = new BasicNote("Front", null);
        assertEquals(b.getFront(), ("Front"));
        assertEquals(b.getBack(), "");
    }

    @Test
    public void checkCardsFront() {
        b.generateCards();

        Card generatedCard = b.getCards()[0];
        assertEquals(b.getFront(), generatedCard.getFront());

    }

    @Test
    public void checkCardsBack() {
        b.generateCards();

        Card generatedCard = b.getCards()[0];
        assertEquals(b.getBack(), generatedCard.getBack());
    }

    @Test
    public void checkCardInfo() {
        assertEquals(b.getCardInfo().length, 1);
        assertEquals(b.getCardInfo()[0][0], "Front");
        assertEquals(b.getCardInfo()[0][1], "Back");
    }

    @Test
    public void testSetBack() {
        b.setBack("TestSet");
        assertEquals("TestSet", b.getBack());
    }

    @Test
    public void testSetFront() {
        b.setFront("TestSetFront");
        assertEquals("TestSetFront", b.getFront());
    }

}
