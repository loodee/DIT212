package com.example.ohimarc.marc.view.toolbarExtensionView;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * This interface's responsibility is forcing the Activity that implements it (ToolbarExtension)
 * to implement the methods below. The methods are to be called from the Activity's Presenter
 * (ToolbarExtensionPresenter).
 */

public interface ToolbarExtensionView {

    /**
     * This method is supposed to be implemented by ToolbarExtension. The purpose of this method is
     * to navigate to the Login screen. This method is called by ToolbarExtensionPresenter, as the
     * Presenter needs to handle the model prior to logging out a user.
     */
    void navigateLogout();
}
