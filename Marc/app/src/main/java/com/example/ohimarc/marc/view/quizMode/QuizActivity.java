package com.example.ohimarc.marc.view.quizMode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.QuizPresenter;
import com.example.ohimarc.marc.view.ResultsActivity;
import com.example.ohimarc.marc.view.ToolbarExtension;

public class QuizActivity extends ToolbarExtension implements QuizView {

    private QuizPresenter presenter;

    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    Button[] buttons = new Button[4];
    private boolean answered;

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
        buttons[0] = answer1;
        buttons[1] = answer2;
        buttons[2] = answer3;
        buttons[3] = answer4;
        answered = false;
        presenter = new QuizPresenter(this);
        presenter.onCreate();
        initExtension(this,R.id.quizactivity,presenter.getDeckTitle());
    }

    @Override
    public void highlightRightA(int i) {
        buttons[i].setBackgroundColor(Color.GREEN);
    }

    @Override
    public void highlightWrongA(int i) {
        buttons[i].setBackgroundColor(Color.RED);
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
        if(!answered) {
            presenter.questionAnswered(1);
            answered = true;
        }
    }

    public void answer2Clicked(View v) {
        if(!answered) {
            presenter.questionAnswered(2);
            answered = true;
        }
    }

    public void answer3Clicked(View v) {
        if(!answered) {
            presenter.questionAnswered(3);
            answered = true;
        }
    }

    public void answer4Clicked(View v) {
        if(!answered) {
            presenter.questionAnswered(4);
            answered = true;
        }
    }

    public void proceedClicked(View v) {
        if(answered) {
            presenter.proceed();
            for (Button b : buttons) {
                b.setBackgroundColor(Color.WHITE);
            }
            answered = false;
        }
    }

    @Override
    public void changeView() {
        Intent intent = new Intent(QuizActivity.this, ResultsActivity.class);

        Bundle b = new Bundle();
        b.putIntegerArrayList("results", presenter.getAmountCorrectAnswers());
        b.putString("deckTitle", presenter.getDeckTitle());
        b.putString("mode", presenter.getGameName());

        intent.putExtras(b);
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
