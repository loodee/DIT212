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

/**
 * @author Alexander Sandberg (alexandersand on github)
 * The purpose of this Activity is to set up the Results view, and to handle any user interaction
 * with the UI. It mainly contains a couple of navigation methods.
 */

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

        presenter = new ResultPresenter(this, values, deckIndex, mode, getFilesDir().getAbsolutePath());
        presenter.onCreate();
        initExtension(this, R.id.results_activity, "Results");
    }

    /**
     * This function initializes the texts of the view.
     *
     * @param correct is an int, which marks the amount of correct answers given in the previous
     *                activity.
     * @param total   is an int, which marks the amount of total questions given in the previous
     *                activity.
     */

    public void initTexts(int correct, int total) {
        resultText.setText("Score: " + correct + "/" + total);
        deckTitleText.setText("Deck: " + presenter.getDeckTitle());
        modeText.setText("Mode: " + mode);
    }

    /**
     * This function is called in the XML-file activity_results when the "Retry" button is clicked.
     * It checks which activity it originates from, and sets an Intent back to that activity.
     * If Intent isn't set to null, it will pack a bundle, start the activity and finish itself.
     *
     * @param v is a View which in this case is the XML-file activity_results.
     */

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

    /**
     * This function is called in the XML-file activity_results when the "Return to deck" button
     * is clicked. It will set an Intent to ChoosingDeckActivity, start the activity and
     * finish itself.
     *
     * @param v is a View which in this case is the XML-file activity_results.
     */

    public void returnClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), ChoosingDeckActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * This function unpacks a bundle given by the previous activity. Here, an Integer ArrayList
     * containing the results, a String mode and an int deckIndex is expected to be found.
     */

    private void unpackBundle() {
        Bundle b = getIntent().getExtras();
        values = null;
        if (b != null) {
            values = b.getIntegerArrayList("results");
            mode = b.getString("mode");
            deckIndex = b.getInt("deckIndex");
        }
    }

    /**
     * This function packs a bundle for the next activity. It creates a Bundle b and puts the int
     * deckIndex into it with the key "deckIndex".
     *
     * @param intent is an Intent which is given by the function retryButton above. This is the
     *               Intent which the bundle is supposed to belong to.
     */

    private void packBundle(Intent intent) {
        Bundle b = new Bundle();
        b.putInt("deckIndex", deckIndex);
        intent.putExtras(b);
    }
}
