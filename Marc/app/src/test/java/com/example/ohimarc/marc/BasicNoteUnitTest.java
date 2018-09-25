package com.example.ohimarc.marc;

import com.example.ohimarc.marc.models.BasicNote;
import com.example.ohimarc.marc.models.Card;


import org.junit.Test;

import static org.junit.Assert.*;

public class BasicNoteUnitTest {
    @Test
    public void createBasicNote(){
    BasicNote b = new BasicNote("Front", "Back");

    assertEquals(b.getFront(), "Front");
    assertEquals(b.getBack(), "Back");
    }

    @Test
    public void emptyFront(){
    BasicNote b = new BasicNote (null, "Back");

    assertEquals(b.getFront(), "");
    assertEquals(b.getBack(), "Back");
    }

    @Test
    public void emptyBack(){
    BasicNote b = new BasicNote ("Front", null);

    assertEquals(b.getFront(),("Front"));
    assertEquals(b.getBack(),"");
    }

    @Test
    public void checkCardsFront(){
        BasicNote b = new BasicNote("Front", "Back");

        b.generateCards();

        Card generatedCard = b.getCards()[0];
        assertEquals(b.getFront(), generatedCard.getFront());

    }

    @Test
    public void checkCardsBack(){
        BasicNote b = new BasicNote("Front", "Back");

        b.generateCards();

        Card generatedCard = b.getCards()[0];
        assertEquals(b.getBack(), generatedCard.getBack());
    }


}
