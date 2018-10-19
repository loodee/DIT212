package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.User;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.service.UserStorageFactory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;


public class LocalUserStorageUnitTests {


    private UserStorage storage;
    private MemorizationTrainingTool mtt;
    private MemorizationTrainingTool stored;

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setup() {
        mtt = new MemorizationTrainingTool();
        try {
            storage = UserStorageFactory.createLocalUserStorage(folder.newFolder("test").getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readNoFile() {
        mtt = storage.getStoredState();

        assertEquals(mtt.getUsers().size(), 0);
    }

    @Test
    public void saveUser() {
        mtt.addNewUser("Bob");

        storage.storeState(mtt);
        stored = storage.getStoredState();

        assertEquals("Bob", stored.getUsers().get(0).getName());
    }

    @Test
    public void saveNullUserList() {
        storage.storeState(null);
        stored = storage.getStoredState();

        assertEquals(0, stored.getUsers().size());
    }

    @Test
    public void saveEmptyList() {
        storage.storeState(mtt);
        stored = storage.getStoredState();

        assertEquals(stored.getUsers().size(), 0);
    }

    @Test
    public void saveSeveralUsers() {
        mtt.addNewUser("Bob");
        mtt.addNewUser("Alice");

        storage.storeState(mtt);
        stored = storage.getStoredState();

        assertEquals(2, stored.getUsers().size());
        assertEquals("Bob", stored.getUsers().get(0).getName());
        assertEquals("Alice", stored.getUsers().get(1).getName());
    }

    @Test
    public void saveUserWithDeck() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        User u = mtt.getActiveUser();
        u.createNewDeck("Test Deck");

        storage.storeState(mtt);
        stored = storage.getStoredState();

        assertEquals(1, stored.getActiveUser().getDeckTitles().size());
        assertEquals(mtt.getActiveUser().getDeckTitles().get(0), stored.getActiveUser().getDeckTitles().get(0));
    }

    @Test
    public void saveUserWithDecks() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        User u = mtt.getActiveUser();
        u.createNewDeck("Test Deck");
        u.createNewDeck("Test Deck1");
        u.createNewDeck("Test Deck2");

        storage.storeState(mtt);
        stored = storage.getStoredState();

        assertEquals(3, stored.getActiveUser().getDeckTitles().size());
        assertEquals(mtt.getActiveUser().getDeckTitles().get(0), stored.getActiveUser().getDeckTitles().get(0));
        assertEquals(mtt.getActiveUser().getDeckTitles().get(1), stored.getActiveUser().getDeckTitles().get(1));
        assertEquals(mtt.getActiveUser().getDeckTitles().get(2), stored.getActiveUser().getDeckTitles().get(2));
    }

    @Test
    public void saveUserWithDeckAndCard() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        User u = mtt.getActiveUser();
        u.createNewDeck("Test Deck");

        Deck d = u.getDeck(0);
        d.addBasicNote("Some front", "Some back");

        storage.storeState(mtt);
        stored = storage.getStoredState();

        assertEquals(1, stored.getActiveUser().getDeckTitles().size());
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[0][0], stored.getActiveUser().getDeck(0).getCardCopies()[0][0]);
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[0][1], stored.getActiveUser().getDeck(0).getCardCopies()[0][1]);
    }

    @Test
    public void saveUserWithDeckAndCards() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        User u = mtt.getActiveUser();
        u.createNewDeck("Test Deck");

        Deck d = u.getDeck(0);
        d.addBasicNote("Some front", "Some back");
        d.addBasicNote("Some front2", "Some back2");

        storage.storeState(mtt);
        stored = storage.getStoredState();

        assertEquals(1, stored.getActiveUser().getDeckTitles().size());
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[0][0], stored.getActiveUser().getDeck(0).getCardCopies()[0][0]);
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[0][1], stored.getActiveUser().getDeck(0).getCardCopies()[0][1]);
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[1][0], stored.getActiveUser().getDeck(0).getCardCopies()[1][0]);
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[1][1], stored.getActiveUser().getDeck(0).getCardCopies()[1][1]);
    }

    @Test
    public void saveUserWithDecksAndCards() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        User u = mtt.getActiveUser();
        u.createNewDeck("Test Deck");
        u.createNewDeck("Test Deck2");

        Deck d = u.getDeck(0);
        d.addBasicNote("Some front", "Some back");
        d.addBasicNote("Some front2", "Some back2");

        d = u.getDeck(1);
        d.addBasicNote("Front", "Back");

        storage.storeState(mtt);
        stored = storage.getStoredState();

        assertEquals(2, stored.getActiveUser().getDeckTitles().size());
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[0][0], stored.getActiveUser().getDeck(0).getCardCopies()[0][0]);
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[0][1], stored.getActiveUser().getDeck(0).getCardCopies()[0][1]);
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[1][0], stored.getActiveUser().getDeck(0).getCardCopies()[1][0]);
        assertEquals(mtt.getActiveUser().getDeck(0).getCardCopies()[1][1], stored.getActiveUser().getDeck(0).getCardCopies()[1][1]);

        assertEquals(mtt.getActiveUser().getDeck(1).getCardCopies()[0][0], stored.getActiveUser().getDeck(1).getCardCopies()[0][0]);
        assertEquals(mtt.getActiveUser().getDeck(1).getCardCopies()[0][1], stored.getActiveUser().getDeck(1).getCardCopies()[0][1]);
    }
}
