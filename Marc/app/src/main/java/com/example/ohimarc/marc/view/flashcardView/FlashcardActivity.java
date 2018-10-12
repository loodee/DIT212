package com.example.ohimarc.marc.view.flashcardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ohimarc.marc.presenter.FlashcardPresenter;
import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.view.resultsView.ResultsActivity;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

public class FlashcardActivity extends ToolbarExtension implements FlashcardView {

    private FlashcardPresenter presenter;

    private Button cardButton;
    private TextView cardTitle;
    private int deckIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        cardTitle = findViewById(R.id.cardTitle);
        cardButton = findViewById(R.id.cardButton);

        unpackBundle();

        presenter = new FlashcardPresenter(this, deckIndex);
        presenter.onCreate();
        initExtension(this, R.id.flashcard_activity, presenter.getDeckTitle());
    }

    public void initTexts(String deckTitleText, String cardText) {
        cardButton.setText(cardText);
        cardTitle.setText("Q:");
    }

    public void flipCardButton(String qOrA, String text) {
        cardTitle.setText(qOrA);
        cardButton.setText(text);
    }

    public void flipCardButtonClicked(View v) {
        boolean bool = false;
        if (cardTitle.getText().equals("Q:")) {
            bool = true;
        }
        presenter.flashCardClicked(bool);
    }

    public void correctButtonClicked(View v) {
        presenter.resultButtonsClicked(true);
    }

    public void incorrectButtonClicked(View v) {
        presenter.resultButtonsClicked(false);
    }

    public void changeView() {
        Intent intent = new Intent(FlashcardActivity.this, ResultsActivity.class);
        packBundle(intent);
        startActivity(intent);
        finish();
    }

    private void unpackBundle() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            deckIndex = b.getInt("deckIndex");
        }
    }

    private void packBundle(Intent intent) {
        Bundle b = new Bundle();
        b.putIntegerArrayList("results", presenter.getAmountCorrectAnswers());
        b.putString("mode", presenter.getGameName());
        b.putInt("deckIndex", deckIndex);
        intent.putExtras(b);
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
