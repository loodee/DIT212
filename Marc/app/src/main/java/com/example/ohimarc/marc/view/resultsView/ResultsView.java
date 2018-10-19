package com.example.ohimarc.marc.view.resultsView;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * This interface's responsibility is forcing the Activity that implements it (ResultsActivity)
 * to implement the methods below. The methods are to be called from the Activity's Presenter
 * (ResultPresenter).
 */

public interface ResultsView {

    /**
     * This method is supposed to be implemented by ResultsActivity. The purpose of this method is
     * to initialize all texts in the Activity. This method is called by ResultPresenter as only
     * the Presenter knows what texts are supposed to be displayed.
     *
     * @param correct is the number of correct answers given by the proceeding game played.
     * @param total   is the number of total questions given by the proceeding game played.
     */
    void initTexts(int correct, int total);
}
