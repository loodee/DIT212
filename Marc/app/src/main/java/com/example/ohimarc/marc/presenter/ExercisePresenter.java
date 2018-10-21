package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * The purpose of this Presenter is to handle any interaction with the model, for the Activity.
 * Whenever data needs to be extracted in the model by ExerciseActivity, it is
 * supposed to be handled by this Presenter.
 */

public class ExercisePresenter {

    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private final int index;

    /**
     * This is the constructor of ExercisePresenter.
     *
     * @param index is the index of the Deck that has been selected in the previous view.
     *              It is needed to get data from the model, while provided by ExerciseActivity.
     */
    public ExercisePresenter(int index) {
        this.index = index;
    }

    /**
     * This function talks with the model through MemorisationTrainingTool, and gets the title
     * of a specific deck.
     *
     * @return the title of the selected deck, which is used in ExerciseActivity.
     */

    public String getDeckTitle() {
        return mtt.getActiveUser().getDeck(index).getTitle();
    }

    /**
     * This function talks with the model through MemorisationTrainingTool, and gets the size
     * of a specific deck.
     *
     * @return the size of the selected deck, which is used in ExerciseActivity.
     */

    public int getDeckSize() {
        return mtt.getActiveUser().getDeck(index).getDeckSize();
    }

}
