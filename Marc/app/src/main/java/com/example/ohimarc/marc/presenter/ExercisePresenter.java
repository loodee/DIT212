package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;

public class ExercisePresenter implements Presenter {


    MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private int index;

    public ExercisePresenter(int index) {
        this.index = index;
    }

    @Override
    public void onCreate() {
    }

    public String getDeckTitle() {
        //return mtt.getActiveUser().getDeck(index).getTitle();
        return "This is a deck title";
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
