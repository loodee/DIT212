package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.ClozeNote;
import com.example.ohimarc.marc.model.Card;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClozeNoteUnitTest {
    private ClozeNote c;
    private String text1 = "cloze notes [[1::aren't]] cool";
    private String text2 = "[[1::basicnotes]] are old, [[2::clozes]] is the new [[1::orange]]";

    @Test
    public void createClozeNote() {
        c = new ClozeNote(text1);
        assertEquals(c.getText(), text1);
        assertEquals(c.getSize(), 1);

        c = new ClozeNote(text2);
        assertEquals(c.getSize(), 2);
    }

    @Test
    public void emptyText() {
        ClozeNote apa = new ClozeNote(null);
        assertEquals(apa.getText(), "");
        assertEquals(apa.getSize(), 0);
    }

    @Test
    public void testSetText() {
        ClozeNote bepa = new ClozeNote("old text");
        String newText = "new text";
        bepa.setText("new text");
        assertEquals(bepa.getText(), newText);
    }

    @Test
    public void add() {
        ClozeNote cn = new ClozeNote("[[a::Ed]] Hello [[b::Bob]]");

        Card[] cards = cn.getCards();

        cn.generateCards();

        assertEquals(2, cards.length);
        assertEquals("Ed Hello [..]", cards[1].getFront());
        assertEquals("[..] Hello Bob", cards[0].getFront());
        assertEquals("Ed Hello Bob", cards[0].getBack());
        assertEquals("Ed Hello Bob", cards[1].getBack());
    }


    @Test
    public void addMultiple() {
        ClozeNote cn = new ClozeNote("[[a::Ed]] Hello [[a::Bob]]");

        cn.generateCards();

        Card[] cards = cn.getCards();
        assertEquals(1, cards.length);

        assertEquals("[..] Hello [..]", cards[0].getFront());
    }

    @Test
    public void addInvalidSyntax() {
        ClozeNote cn = new ClozeNote("Hello [[a::Bob]");

        cn.generateCards();
        Card[] cards = cn.getCards();


        assertEquals(0, cards.length);
    }

    @Test
    public void addWithSpecialCharacter() {
        ClozeNote cn = new ClozeNote("Hello [[a::Bo]b]]");

        cn.generateCards();

        Card[] cards = cn.getCards();
        assertEquals(1, cards.length);

        assertEquals("Hello [..]", cards[0].getFront());
        assertEquals("Hello Bo]b", cards[0].getBack());
    }

    @Test
    public void addWithDoubleClosing() {
        ClozeNote cn = new ClozeNote("Hello [[a::Bo]] b]]");

        cn.generateCards();


        Card[] cards = cn.getCards();
        assertEquals(1, cards.length);
        assertEquals("Hello [..] b]]", cards[0].getFront());
        assertEquals("Hello Bo b]]", cards[0].getBack());
    }
}