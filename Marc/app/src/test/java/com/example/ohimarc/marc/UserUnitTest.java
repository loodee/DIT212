package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Card;
import com.example.ohimarc.marc.model.User;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserUnitTest {
    @Test
    public void createUser() {
        String name = "Bob";
        
        User u = new User(name);

        assertEquals(u.getName(),name);
    }

    @Test
    public void createNullNameUser() {
        String name = null;

        User u = new User(name);

        assertEquals(u.getName(), "");
    }
}
