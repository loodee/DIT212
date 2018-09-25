package com.example.ohimarc.marc.View;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ohimarc.marc.Presenter.FlashcardPresenter;
import com.example.ohimarc.marc.R;

public class FlashcardActivity extends AppCompatActivity implements FlashcardView {

    FlashcardPresenter presenter = new FlashcardPresenter(this);

    private Button cardButton;
    private TextView cardTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        cardTitle = findViewById(R.id.cardTitle);
        cardButton = findViewById(R.id.cardButton);
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
        presenter.onCreate();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items,menu);
        return true;
    }

    public void initTexts(String deckTitleText, String cardText) {
        ActionBar ab = getSupportActionBar();
        ab.setTitle(deckTitleText);
        cardButton.setText(cardText);
        cardTitle.setText("Q:");
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
