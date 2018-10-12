package com.example.ohimarc.marc.view.resultsView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.presenter.ResultPresenter;
import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;
import com.example.ohimarc.marc.view.choosingDeckView.ChoosingDeckActivity;
import com.example.ohimarc.marc.view.flashcardView.FlashcardActivity;
import com.example.ohimarc.marc.view.quizView.QuizActivity;

import java.util.ArrayList;

public class ResultsActivity extends ToolbarExtension implements ResultsView {

    private ResultPresenter presenter;

    private ArrayList<Integer> values;
    private String mode;
    private int deckIndex;

    private TextView resultText;
    private TextView deckTitleText;
    private TextView modeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        resultText = findViewById(R.id.scoreText);
        deckTitleText = findViewById(R.id.deckTitleText);
        modeText = findViewById(R.id.modeText);
        titleText = findViewById(R.id.toolbar_text);

        unpackBundle();

        presenter = new ResultPresenter(this, values, deckIndex, mode);
        presenter.onCreate();
        initExtension(this, R.id.results_activity, "Results");
    }

    public void initTexts(int correct, int total) {
        resultText.setText("Score: " + correct + "/" + total);
        deckTitleText.setText("Deck: " + presenter.getDeckTitle());
        modeText.setText("Mode: " + mode);
    }

    public void retryButton(View v) {
        Intent intent;
        switch (mode) {
            case ("Flashcard Game"):
                intent = new Intent(ResultsActivity.this, FlashcardActivity.class);
                break;
            case ("Quiz Game"):
                intent = new Intent(ResultsActivity.this, QuizActivity.class);
                break;
            default:
                intent = null;
                break;
        }
        if (intent != null) {
            packBundle(intent);
            startActivity(intent);
            finish();
        }
    }

    public void returnClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), ChoosingDeckActivity.class);
        startActivity(intent);
        finish();
    }

    private void unpackBundle() {
        Bundle b = getIntent().getExtras();
        values = null;
        if (b != null) {
            values = b.getIntegerArrayList("results");
            mode = b.getString("mode");
            deckIndex = b.getInt("deckIndex");
        }
    }

    private void packBundle(Intent intent) {
        Bundle b = new Bundle();
        b.putInt("deckIndex", deckIndex);
        intent.putExtras(b);
    }
}
