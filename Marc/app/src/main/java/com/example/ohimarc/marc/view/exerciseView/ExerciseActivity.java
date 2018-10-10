package com.example.ohimarc.marc.view.exerciseView;

import android.os.Bundle;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ExercisePresenter;
import com.example.ohimarc.marc.view.ToolbarExtension;

public class ExerciseActivity extends ToolbarExtension implements ExerciseView {

    private ExercisePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        initExtension(this, R.id.activity_exercise, "TODO: Deck Title");
        presenter = new ExercisePresenter(this);
        presenter.onCreate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
