package com.example.ohimarc.marc.view.startMenuView;

public interface StartMenuView {

    /**
     * Tells the view that the user is logged in
     * */
    void login();

    /**
     * Tells the view to prompt the user for deletion
     * @param index the index of the user which we want the prompt for
     * @param name the name of the user which we want the prompt for
     * */
    void promptForDeletion(int index, String name);
}
