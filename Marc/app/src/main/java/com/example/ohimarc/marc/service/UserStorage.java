package com.example.ohimarc.marc.service;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.User;
import java.util.List;

public interface UserStorage {

    /**
     * Given a list of users stores all the users so they can be accessed at a later time
     * @param users The user that are going to be saved
     * */
    void storeUsers(List<User> users);

    /**
     * Returns a list of all stored users
     * */
    List<User> getStoredUsers();

}
