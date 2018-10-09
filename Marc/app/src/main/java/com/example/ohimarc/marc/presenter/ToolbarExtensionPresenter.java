package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.ToolbarExtensionView;

public class ToolbarExtensionPresenter implements Presenter {

    private ToolbarExtensionView view;
    private UserStorage store;

    public ToolbarExtensionPresenter(ToolbarExtensionView view, String filePath) {
        this.view = view;
        this.store = new LocalUserStorage(filePath);
    }

    public void logoutButton() {
        //Some functionality for logging out through the model
        MemorizationTrainingTool.getInstance().setActiveUser(null);
        store.storeState(MemorizationTrainingTool.getInstance());
        view.navigateLogout();
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
    }

}
