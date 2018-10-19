package com.example.ohimarc.marc.view.flashcardView;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * This interface's responsibility is forcing the Activity that implements it (FlashcardActivity)
 * to implement the methods below. The methods are to be called from the Activity's Presenter
 * (FlashcardPresenter).
 */

public interface FlashcardView {
    /**
     * This method is supposed to be implemented by FlashcardActivity. The purpose of the method
     * is to change the texts of the card when the card is flipped. The method is called by
     * FlashcardPresenter as only the Presenter knows what texts are contained in a specific
     * Card object.
     *
     * @param qOrA is a String that describes whether the question or answer is displayed on the
     *             card.
     * @param text is a String that describes either the question or answer of the card.
     */
    void flipCardButton(String qOrA, String text);

    /**
     * This method is supposed to be implemented by FlashcardActivity. The purpose of this method
     * is to initialize the texts of the card. This method is called by FlashcardPresenter as
     * only the Presenter knows what texts are contained in a specific Card object.
     *
     * @param cardText
     */
    void initTexts(String cardText);

    /**
     * This method is supposed to be implemented by FlashcardActivity. The purpose of this method
     * is to navigate to a different screen, when there are no more cards to be displayed. This
     * method is called by FlashcardPresenter as only the Presenter knows when there are no more
     * cards in the deck.
     */
    void changeView();
}
