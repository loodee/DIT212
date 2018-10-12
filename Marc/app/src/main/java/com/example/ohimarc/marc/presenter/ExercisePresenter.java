package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;

public class ExercisePresenter {


    MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private int index;

    public ExercisePresenter(int index) {
        this.index = index;
    }


    public String getDeckTitle() {
        return mtt.getActiveUser().getDeck(index).getTitle();
    }

    public int getDeckSize() {
        return mtt.getActiveUser().getDeck(index).getDeckSize();
    }

}
