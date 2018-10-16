package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;

/**
 * @author Alexander Sandberg (alexandersand on github)
 */

public class ExercisePresenter {

    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private final int index;

    public ExercisePresenter(int index) {
        this.index = index;
    }

    /**
     * This function talks with the model through MemorisationTrainingTool, and gets the title
     * of a specific deck.
     * @return the title of the selected deck, which is used in ExerciseActivity.
     */

    public String getDeckTitle() {
        return mtt.getActiveUser().getDeck(index).getTitle();
    }

    /**
     * This function talks with the model through MemorisationTrainingTool, and gets the size
     * of a specific deck.
     * @return the size of the selected deck, which is used in ExerciseActivity.
     */

    public int getDeckSize() {
        return mtt.getActiveUser().getDeck(index).getDeckSize();
    }

}
