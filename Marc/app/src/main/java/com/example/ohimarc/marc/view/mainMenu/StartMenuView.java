package com.example.ohimarc.marc.view.mainMenu;

public interface StartMenuView {

    /**
     * Tells the view that the user is logged in
     * */
    void login();

    /**
     * Tells the view that the creation of a user failed
     * */
    void failedUserCreation();

    /**
     * Tells the view to prompt the user for deletion
     * */
    void promptForDeletion(int index, String name);
}
