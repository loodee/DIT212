package com.example.ohimarc.marc.view.quizMode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.QuizPresenter;
import com.example.ohimarc.marc.view.ResultsActivity;
import com.example.ohimarc.marc.view.ToolbarExtension;

public class QuizActivity extends ToolbarExtension implements QuizView {

    private QuizPresenter presenter;

    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button answerButton4;
    Button[] buttons = new Button[4];

    private boolean hasAnswered = false;
    private int deckIndex;

    private TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionText = findViewById(R.id.card);

        assignButtons();
        putButtonsInButtons();
        unpackBundle();

        presenter = new QuizPresenter(this, deckIndex);
        presenter.onCreate();
        initExtension(this, R.id.quiz_activity, presenter.getDeckTitle());
    }

    private void assignButtons() {
        answerButton1 = findViewById(R.id.answer1);
        answerButton2 = findViewById(R.id.answer2);
        answerButton3 = findViewById(R.id.answer3);
        answerButton4 = findViewById(R.id.answer4);
    }

    private void putButtonsInButtons() {
        buttons[0] = answerButton1;
        buttons[1] = answerButton2;
        buttons[2] = answerButton3;
        buttons[3] = answerButton4;
    }

    public void highlightRightAnswer(int i) {
        buttons[i].setBackgroundColor(Color.GREEN);
    }

    public void highlightWrongAnswer(int i) {
        buttons[i].setBackgroundColor(Color.RED);
    }

    public void initTexts(String[] list) {
        questionText.setText(list[0]);
        for (int i = 0; i < 4; i++) {
            buttons[i].setText(list[i + 1]);
        }
    }

    public void answer1Clicked(View v) {
        if (!hasAnswered) {
            presenter.questionAnswered(1);
            hasAnswered = true;
        }
    }

    public void answer2Clicked(View v) {
        if (!hasAnswered) {
            presenter.questionAnswered(2);
            hasAnswered = true;
        }
    }

    public void answer3Clicked(View v) {
        if (!hasAnswered) {
            presenter.questionAnswered(3);
            hasAnswered = true;
        }
    }

    public void answer4Clicked(View v) {
        if (!hasAnswered) {
            presenter.questionAnswered(4);
            hasAnswered = true;
        }
    }

    public void proceedClicked(View v) {
        if (hasAnswered) {
            presenter.proceed();
            for (Button b : buttons) {
                b.setBackgroundColor(Color.WHITE);
            }
            hasAnswered = false;
        } else {
            Toast toast = Toast.makeText(this, "Please select an answer.", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void packBundle(Intent intent) {
        Bundle b = new Bundle();
        b.putIntegerArrayList("results", presenter.getAmountCorrectAnswers());
        b.putInt("deckIndex", deckIndex);
        b.putString("mode", presenter.getGameName());
        intent.putExtras(b);
    }

    private void unpackBundle() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            deckIndex = b.getInt("deckIndex");
        }
    }

    public void changeView() {
        Intent intent = new Intent(QuizActivity.this, ResultsActivity.class);
        packBundle(intent);
        startActivity(intent);
        finish();
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
