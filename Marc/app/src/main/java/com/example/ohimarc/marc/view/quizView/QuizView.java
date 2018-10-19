package com.example.ohimarc.marc.view.quizView;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * This interface's responsibility is forcing the Activity that implements it (QuizActivity)
 * to implement the methods below. The methods are to be called from the Activity's Presenter
 * (QuizPresenter).
 */

public interface QuizView {

    /**
     * This method is supposed to be implemented by QuizActivity. The purpose of this method
     * is to initialize the texts of the card and its answers. This method is called by
     * QuizPresenter as only the Presenter knows what texts are contained in a specific Card object.
     *
     * @param list is a list of Strings that is supposed to contain the question String, and four
     *             possible answer Strings.
     */
    void initTexts(String[] list);

    /**
     * This method is supposed to be implemented by QuizActivity. The purpose of this method is to
     * mark the correct answer with a green color. This method is called by QuizPresenter as only
     * the Presenter knows what answer is the correct answer for a specific Card object.
     *
     * @param i is the index of the button which is supposed to be highlighted.
     */
    void highlightRightAnswer(int i);

    /**
     * This method is supposed to be implemented by QuizActivity. The purpose of this method is to
     * mark the incorrect answer with a red color. This method is called by QuizPresenter as only
     * the Presenter knows what answer is the incorrect answer for a specific Card object.
     *
     * @param i is the index of the button which is supposed to be highlighted.
     */
    void highlightWrongAnswer(int i);

    /**
     * This method is supposed to be implemented by QuizActivity. The purpose of this method
     * is to navigate to a different screen, when there are no more cards to be displayed. This
     * method is called by QuizPresenter as only the Presenter knows when there are no more
     * cards in the deck.
     */
    void changeView();
}
