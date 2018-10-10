package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.FlashCardGame;
import com.example.ohimarc.marc.model.QuizGame;
import com.example.ohimarc.marc.view.exerciseView.ExerciseView;

public class ExercisePresenter implements Presenter {

    private ExerciseView view;


    public ExercisePresenter(ExerciseView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

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
