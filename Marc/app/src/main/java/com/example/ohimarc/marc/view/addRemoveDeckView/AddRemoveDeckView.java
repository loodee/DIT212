package com.example.ohimarc.marc.view.addRemoveDeckView;

/**
 * @author Victor Johansson (Vroxie on github)
 */

/**
 * This interface says what other can use from the classes who implements this interface
 * The only class who implements this i AddRemoveDeckViewHolder
 */
public interface AddRemoveDeckView {

    /**
     * Sets the title of a item in recyclerview, in this case the deckTitle
     *
     * @param title the title that will be set, (the deckTitle)
     */
    void setTitle(String title);

}
