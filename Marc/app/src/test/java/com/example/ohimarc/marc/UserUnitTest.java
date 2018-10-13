package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.User;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class UserUnitTest {
    @Test
    public void createUser() {
        String name = "Bob";
        
        User u = new User(name);

        assertEquals(name, u.getName());
    }

    @Test
    public void createNullNameUser() {
        String name = null;

        User u = new User(name);

        assertEquals("", u.getName());
    }

    @Test
    public void createNewDeck() {
        User u = new User("Bob");

        String deckName = "English animals";
        u.createNewDeck(deckName);

        assertEquals(deckName, u.getDeck(0).getTitle());
        assertEquals(0, u.getDeck(0).getDeckSize());
    }


    @Test
    public void getDeckTitles() {
        User u = new User("Bob");

        String deckName = "English animals";
        u.createNewDeck(deckName+"1");
        u.createNewDeck(deckName+"2");
        u.createNewDeck(deckName+"3");

        List<String> names = u.getDeckTitles();

        for (int i = 0; i < names.size(); i++) {
            assertEquals(deckName+(i+1), names.get(i));
        }
    }

    @Test
    public void getDeckInvalidDeck() {
        User u = new User("Bob");
        Deck d = u.getDeck(18);

        assertNull(d);
    }

    @Test
    public void deleteDeck() {
        User u = new User("Bob");
        Boolean b1 = u.getDeck(0) == null;
        u.createNewDeck("English animals");
        Boolean b2 = u.getDeck(0) != null;
        u.deleteDeck(0);
        Boolean b3 = u.getDeck(0) == null;
        assertTrue(b1 && b2 && b3);
    }
}
