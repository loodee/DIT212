/**
 * Author: Victor Johansson githubnice: Vroxie
 * Last updated 20/9 2018
 */
package com.example.ohimarc.marc.View;

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


    private Button cardButton;
    private TextView cardTitle;

    FlashcardPresenter presenter = new FlashcardPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        cardTitle = findViewById(R.id.cardTitle);
        cardButton = findViewById(R.id.cardButton);
        cardTitle.setText("Q:");
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
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

    public void setTitle(String deckTitleText) {
        ActionBar ab = getSupportActionBar();
        ab.setTitle(deckTitleText);
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

    public void correctButton() {

    }

    public void incorrectButton() {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items,menu);
        return true;
    }
}
