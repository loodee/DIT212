package com.example.ohimarc.marc.view.startMenuView;

/**
 * @author Gustav Albertsson
 *
 * This class is responsible for forcing the activity to have certain methods, so that the presenter
 * does not have to be dependent on an implementation.
 * */
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
