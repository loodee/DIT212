package com.example.ohimarc.marc.view.choosingDeckView;

/**
 * @author Victor Johansson (Vroie on github)
 */

/**
 * This interfaces' responsibility is to say which methods the presenter of ChoosingDeck can use
 * The only class who implements this interface is then of course the activity for ChoosingDeck
 */
public interface ChoosingDeckView {
    void deckIsClicked(int index);
}
