package com.example.ohimarc.marc.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ohimarc.marc.model.ToolbarExtension;
import com.example.ohimarc.marc.presenter.FlashcardPresenter;
import com.example.ohimarc.marc.R;

public class FlashcardActivity extends ToolbarExtension implements FlashcardView {

    FlashcardPresenter presenter = new FlashcardPresenter(this);

    private Button cardButton;
    private TextView cardTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        cardTitle = findViewById(R.id.cardTitle);
        cardButton = findViewById(R.id.cardButton);
        initiateToolbar();
        presenter.onCreate();
    }

    public void initTexts(String deckTitleText, String cardText) {
        cardButton.setText(cardText);
        cardTitle.setText("Q:");
        titleText.setText(deckTitleText);
    }

    public void flipCardButton(String qora, String text) {
        cardTitle.setText(qora);
        cardButton.setText(text);
    }

    public void flipCardButtonClicked(View v) {
        boolean bool = false;
        if(cardTitle.getText().equals("Q:")) {
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
