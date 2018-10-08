package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.User;
import com.example.ohimarc.marc.service.LocalUserStorage;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LocalUserStorageUnitTests {


    private LocalUserStorage storage;
    private MemorizationTrainingTool mtt;
    private MemorizationTrainingTool stored;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setup(){
        mtt = new MemorizationTrainingTool();
        try {
            storage = new LocalUserStorage(folder.newFolder("test").getAbsolutePath());
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

}
