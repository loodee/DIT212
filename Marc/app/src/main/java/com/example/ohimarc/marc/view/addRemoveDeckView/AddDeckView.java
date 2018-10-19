package com.example.ohimarc.marc.view.addRemoveDeckView;

/**
 * @author Victor Johansson (Vroie on github)
 */

/**
 * This interfaces' responsibility is to say which methods the presenter of AddRemoveDeck can use
 * The only class who implements this interface is then of course the activity for AddRemoveDeck
 */
public interface AddDeckView {
    void deckIsClicked(int index);
}
