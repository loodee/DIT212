package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Card;
import com.example.ohimarc.marc.model.ClozeNote;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ClozeNoteUnitTest {

    @Test
    public void add(){
        ClozeNote cn = new ClozeNote("[[a::Ed]] Hello [[b::Bob]]");

        cn.generateCards();

        Card[] cards = cn.getCards();

        assertEquals(2, cards.length);
        assertEquals("[..] Hello Bob", cards[0].getFront());
        assertEquals("Ed Hello [..]", cards[1].getFront());
        assertEquals("Ed Hello Bob", cards[0].getBack());
        assertEquals("Ed Hello Bob", cards[1].getBack());
    }


    @Test
    public void addMultiple(){
        ClozeNote cn = new ClozeNote("[[a::Ed]] Hello [[a::Bob]]");

        cn.generateCards();

        Card[] cards = cn.getCards();

        assertEquals(1, cards.length);
        assertEquals("[..] Hello [..]", cards[0].getFront());
    }

    @Test
    public void addInvalidSyntax(){
        ClozeNote cn = new ClozeNote("Hello [[a::Bob]");

        cn.generateCards();

        Card[] cards = cn.getCards();

        assertEquals(0, cards.length);
    }

    @Test
    public void addWithSpecialCharacter(){
        ClozeNote cn = new ClozeNote("Hello [[a::Bo]b]]");

        cn.generateCards();

        Card[] cards = cn.getCards();

        assertEquals(1, cards.length);
        assertEquals("Hello [..]", cards[0].getFront());
        assertEquals("Hello Bo]b", cards[0].getBack());
    }

    @Test
    public void addWithDoubleClosing(){
        ClozeNote cn = new ClozeNote("Hello [[a::Bo]] b]]");

        cn.generateCards();

        Card[] cards = cn.getCards();

        assertEquals(1, cards.length);
        assertEquals("Hello [..] b]]", cards[0].getFront());
        assertEquals("Hello Bo b]]", cards[0].getBack());
    }
}
