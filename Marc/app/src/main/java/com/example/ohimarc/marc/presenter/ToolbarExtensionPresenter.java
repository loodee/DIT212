package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.service.UserStorageFactory;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtensionView;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * @author Gustav Albertsson (galbertsson on github)
 * The purpose of this Presenter is to update the model, prior to logging a user out through
 * the Activity ToolbarExtension.
 */

public class ToolbarExtensionPresenter {

    private final ToolbarExtensionView view;
    private final UserStorage store;

    public ToolbarExtensionPresenter(ToolbarExtensionView view, String filePath) {
        this.view = view;
        this.store = UserStorageFactory.createLocalUserStorage(filePath);
    }

    public void logoutButton() {
        MemorizationTrainingTool.getInstance().setActiveUser(null);
        store.storeState(MemorizationTrainingTool.getInstance());
        view.navigateLogout();
    }

}
