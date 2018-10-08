package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.view.ToolbarExtensionView;

public class ToolbarExtensionPresenter implements Presenter {

    private ToolbarExtensionView view;

    public ToolbarExtensionPresenter(ToolbarExtensionView view) {
        this.view = view;
    }

    public void logoutButton() {
        //Some functionality for logging out through the model
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
