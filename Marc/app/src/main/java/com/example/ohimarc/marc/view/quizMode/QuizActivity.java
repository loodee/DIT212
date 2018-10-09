package com.example.ohimarc.marc.view.quizMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.QuizPresenter;

public class QuizActivity extends AppCompatActivity implements QuizView {

    private QuizPresenter presenter;

    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        question = findViewById(R.id.card);

        presenter = new QuizPresenter(this);
        presenter.onCreate();
    }

    @Override
    public void initTexts(String q, String a1, String a2, String a3, String a4) {
        question.setText(q);
        answer1.setText(a1);
        answer2.setText(a2);
        answer3.setText(a3);
        answer4.setText(a4);
    }

    public void answer1Clicked(View v) {
        presenter.questionAnswered(1);
    }

    public void answer2Clicked(View v) {
        presenter.questionAnswered(2);
    }

    public void answer3Clicked(View v) {
        presenter.questionAnswered(3);
    }

    public void answer4Clicked(View v) {
        presenter.questionAnswered(4);
    }

    public void proceedClicked(View v) {
        presenter.proceed();
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
