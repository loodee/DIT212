package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;

/**
 * @author Gustav Albertsson
 *
 * This class is responsible for the handling communication between HomeActivity and the model
 * */
public class HomePresenter {

    /**
     * @return returns true if there is no user currently logged in, if a user is logged in false is returned
     */
    public boolean isLoggedOut() {
        return MemorizationTrainingTool.getInstance().getActiveUser() == null;
    }
}
