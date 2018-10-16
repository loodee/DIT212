package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.ClozeNote;
import com.example.ohimarc.marc.model.Card;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClozeNoteUnitTest {
    private String text1 = "Cloze S.R. Cool";
    private ClozeNote c = new ClozeNote(text1);

    // TODO: Add Card-related tests once card generation in ClozeNotes is implemented.

    @Test
    public void createClozeNote() {
        assertEquals(c.getText(), text1);
        // assertEquals(c.getSize(), 1);
    }

    @Test
    public void emptyText() {
        ClozeNote apa = new ClozeNote(null);
        assertEquals(apa.getText(), "");
    }

    @Test
    public void checkCardsFront() {
    }

    @Test
    public void checkCardsBack() {
    }

    @Test
    public void checkCardInfo() {
    }

    @Test
    public void testSetText() {
        ClozeNote bepa = new ClozeNote("old text");
        String newText = "new text";
        bepa.setText("new text");
        assertEquals(bepa.getText(), newText);
    }

    @Test
    public void testGetText() {
        assertEquals(c.getText(), text1);
    }
}
