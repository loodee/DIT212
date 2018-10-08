package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.User;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MemorizationTrainingToolUnitTest {

    MemorizationTrainingTool mtt;

    @Before
    public void setUp(){
        mtt = new MemorizationTrainingTool();
    }

    @Test
    public void addUser() {
        mtt.addNewUser("Bob");

        assertEquals(mtt.getUsers().get(0).getName(), "Bob");
    }

    @Test
    public void setAndGetActive() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        assertEquals(0, mtt.getActiveUserId().intValue());
    }


    @Test
    public void setAndGetActiveUser() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        assertEquals("Bob", mtt.getActiveUser().getName());
    }

    @Test
    public void removeUser() {
        mtt.addNewUser("Bob");
        mtt.removeUser(0);

        assertEquals(0, mtt.getUsers().size());
    }


    @Test
    public void removeActiveUserId() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        mtt.removeUser(0);

        assertEquals(0, mtt.getUsers().size());
        assertNull(mtt.getActiveUserId());
    }

    @Test
    public void removeActiveUser() {
        mtt.addNewUser("Bob");
        mtt.setActiveUser(0);

        mtt.removeUser(0);

        assertEquals(0, mtt.getUsers().size());
        assertNull(mtt.getActiveUser());
    }

    @Test
    public void removeInvalidUser() {
        mtt.addNewUser("Bob");
        mtt.removeUser(1);

        assertEquals(1, mtt.getUsers().size());
    }


    @Test
    public void getUserNames() {
        mtt.addNewUser("Bob");
        mtt.addNewUser("Ed");

        assertEquals(2, mtt.getUserNames().size());
        assertEquals("Bob", mtt.getUserNames().get(0));
        assertEquals("Ed", mtt.getUserNames().get(1));
    }

    @Test
    public void setUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("Bob"));
        users.add(new User("Ed"));

        mtt.setUsers(users);

        assertEquals(2, mtt.getUserNames().size());
        assertEquals("Bob", mtt.getUserNames().get(0));
        assertEquals("Ed", mtt.getUserNames().get(1));
    }


    @Test
    public void setUsersIsCopy(){
        List<User> users = new ArrayList<>();
        users.add(new User("Bob"));
        users.add(new User("Ed"));

        mtt.setUsers(users);

        users.remove(0);
        assertEquals(2, mtt.getUserNames().size());
        assertEquals("Bob", mtt.getUserNames().get(0));
        assertEquals("Ed", mtt.getUserNames().get(1));
    }
}