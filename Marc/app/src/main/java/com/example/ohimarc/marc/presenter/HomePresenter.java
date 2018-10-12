package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;

public class HomePresenter {

    /**
     * @return returns true if there is no user currently logged in, if a user is logged in false is returned
     */
    public boolean isLoggedOut() {
        return MemorizationTrainingTool.getInstance().getActiveUser() == null;
    }
}
