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

    /**
     * This is the constructor of ToolbarExtensionPresenter.
     *
     * @param view     is the interface ToolbarExtensionView, which is implemented by ToolbarExtension.
     *                 This instance is used to call methods in ToolbarExtension.
     * @param filePath is a file path, stored as a String, provided by ToolbarExtension. It is
     *                 needed for saving data later on.
     */
    public ToolbarExtensionPresenter(ToolbarExtensionView view, String filePath) {
        this.view = view;
        this.store = UserStorageFactory.createLocalUserStorage(filePath);
    }

    /**
     * This method contains functionality for logging out a user. Prior to logging out, the model
     * needs to be updated with this information. This provides the only purpose of this Presenter.
     * The user is set to null, the information is stored, and ToolbarExtension is told to navigate
     * to the login screen.
     */
    public void logoutButton() {
        MemorizationTrainingTool.getInstance().setActiveUser(null);
        store.storeState(MemorizationTrainingTool.getInstance());
        view.navigateLogout();
    }

}
