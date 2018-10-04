package com.example.ohimarc.marc;

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
    private List<User> users;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setup(){

        try {
            storage = new LocalUserStorage(folder.newFolder("test").getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        users = new ArrayList<>();
    }

    @Test
    public void readNoFile() {
        List<User> usersFromStore = storage.getStoredUsers();

        assertEquals(usersFromStore.size(), 0);
    }

    @Test
    public void saveUser() {
        users.add(new User("Bob"));

        storage.storeUsers(users);
        List<User> usersFromStore = storage.getStoredUsers();

        assertEquals(users.get(0).getName(), usersFromStore.get(0).getName());
    }

    @Test
    public void saveNullUserList() {
        storage.storeUsers(null);
        List<User> usersFromStore = storage.getStoredUsers();

        assertEquals(usersFromStore.size(), 0);
    }

    @Test
    public void saveEmptyList() {
        storage.storeUsers(users);
        List<User> usersFromStore = storage.getStoredUsers();

        assertEquals(usersFromStore.size(), 0);
    }

    @Test
    public void saveSeveralUsers() {
        users.add(new User("Bob"));
        users.add(new User("Alice"));

        storage.storeUsers(users);
        List<User> usersFromStore = storage.getStoredUsers();

        assertEquals(users.size(), usersFromStore.size());
        assertEquals(users.get(0).getName(), usersFromStore.get(0).getName());
        assertEquals(users.get(1).getName(), usersFromStore.get(1).getName());
    }

}
