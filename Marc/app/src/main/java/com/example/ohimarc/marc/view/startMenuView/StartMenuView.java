package com.example.ohimarc.marc.view.startMenuView;

public interface StartMenuView {

    /**
     * Tells the view that the user is logged in
     * */
    void login();

    /**
     * Tells the view to prompt the user for deletion
     * */
    void promptForDeletion(int index, String name);
}
