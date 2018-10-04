package com.example.ohimarc.marc.service;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.User;
import java.util.List;

public interface UserStorage {

    /**
     * Given a list of users stores all the users so they can be accessed at a later time, returns false if the users fails to save
     * @param users The users that are going to be saved
     * @return returns true if the users are successfully stored, otherwise returns false
     * */
    boolean storeUsers(List<User> users);

    /**
     * Retries all the stored users and removes them
     * @return A list of all stored users, if there are no users saved an empty List object will be returned
     * */
    List<User> getStoredUsers();

}
