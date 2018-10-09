package com.example.ohimarc.marc.view.quizMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.QuizPresenter;

public class QuizActivity extends AppCompatActivity implements QuizView {

    private QuizPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        presenter = new QuizPresenter(this);
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
