package com.example.ohimarc.marc.view.exerciseView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ExercisePresenter;
import com.example.ohimarc.marc.view.FlashcardActivity;
import com.example.ohimarc.marc.view.ToolbarExtension;
import com.example.ohimarc.marc.view.quizMode.QuizActivity;

public class ExerciseActivity extends ToolbarExtension implements ExerciseView {

    private ExercisePresenter presenter;
    private int deckIndex;
    private int modeIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        unpackBundle();
        presenter = new ExercisePresenter(deckIndex);
        presenter.onCreate();
        String deckTitle = presenter.getDeckTitle();
        initExtension(this, R.id.activity_exercise, deckTitle);
    }

    public void flashcardClicked(View v) {
        modeIndex = 0;
        navigate();
    }

    public void quizClicked(View v) {
        modeIndex = 1;
        navigate();
    }

    @Override
    public boolean navigate() {
        Intent intent;
        switch(modeIndex) {
            case(0):
                intent = new Intent(getApplicationContext(), FlashcardActivity.class);
                break;
            case(1):
                if(presenter.getDeckSize()>3) {
                    intent = new Intent(getApplicationContext(), QuizActivity.class);
                    break;
                }
                else{
                    Toast.makeText(getApplicationContext(),"The deck needs to contain more than 4 cards to play the quiz mode.", Toast.LENGTH_LONG).show();
                    return true;
                }
            default: intent = null;
        }
        if(intent != null) {
            packBundle(intent);
            startActivity(intent);
            finish();
        }
        return true;
    }

    private void packBundle(Intent intent) {
        Bundle b = new Bundle();
        b.putInt("deckIndex" , deckIndex);
        intent.putExtras(b);
    }

    private void unpackBundle() {
        Bundle b = getIntent().getExtras();
        if(b != null) {
            deckIndex = b.getInt("deckIndex");
        }
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
