package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtensionView;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * @author Gustav Albertsson (galbertsson on github)
 */

public class ToolbarExtensionPresenter {

    private final ToolbarExtensionView view;
    private final UserStorage store;

    public ToolbarExtensionPresenter(ToolbarExtensionView view, String filePath) {
        this.view = view;
        this.store = new LocalUserStorage(filePath);
    }

    public void logoutButton() {
        MemorizationTrainingTool.getInstance().setActiveUser(null);
        store.storeState(MemorizationTrainingTool.getInstance());
        view.navigateLogout();
    }

}
