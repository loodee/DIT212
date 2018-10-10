package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.exerciseView.ExerciseView;

public class ExercisePresenter implements Presenter {


    MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private ExerciseView view;

    public ExercisePresenter(ExerciseView view, int index) {
        this.view = view;
    }

    @Override
    public void onCreate() {
    }

    public void quizButton() {

    }

    public void flashcardButton() {

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
