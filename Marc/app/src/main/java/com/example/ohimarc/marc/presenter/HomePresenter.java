package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;

public class HomePresenter {

    public boolean isLoggedOut() {
        return MemorizationTrainingTool.getInstance().getActiveUser() == null;
    }
}
