package com.example.ohimarc.marc.service;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;

/**
 * @author Gustav Albertsson
 * <p>
 * Interface for persistant storage of MemorizationTrainingTool
 */
public interface UserStorage {

    /**
     * Given a list of users stores all the users so they can be accessed at a later time, returns false if the users fails to save
     *
     * @param mtt The users that are going to be saved
     */
    void storeState(MemorizationTrainingTool mtt);

    /**
     * Retrieves the MemorizationTrainingTool from the persistent storage.
     *
     * @return A MemorizationTrainingTool from the persistent storage. If none is saved, a new instance is returned.
     */
    MemorizationTrainingTool getStoredState();

}
