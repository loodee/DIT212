/**
 * Author: Victor Johansson githubnice: Vroxie
 * Last updated 20/9 2018
 */
package com.example.ohimarc.marc.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ohimarc.marc.Model.*;
import com.example.ohimarc.marc.R;

public class FlashcardActivity extends AppCompatActivity {

    private Card test = new Card("Test","Test2");
    private Button cardButton;
    private TextView cardTitle;
    private TextView deckTitle;
    private Deck testDeck = new Deck("testDeck");
    private FlashCardGame testGame = new FlashCardGame(testDeck);


    /**
     * chooses which activity that will be shown and sets tex etc.
     * @param savedInstanceState this is to start at last instance the app was in
     * before the app were shut down
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        cardTitle = findViewById(R.id.cardTitle);
        cardTitle.setText("Q:");
        cardButton = findViewById(R.id.cardButton);
        testDeck.addCard(test.getFront(),test.getBack());
        cardButton.setText(testGame.peekNextCard()[0]);
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
        ActionBar ab = getSupportActionBar();
        ab.setTitle(testGame.getDeckTitle());
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items,menu);
        return true;
    }

    /**
     * checking which "side" that is showing i.e either the question or the answer
     * So depening on which "side" that is shown when the card is pressed
     * the method "flips" the card
     * @param view telling which view that is clicked
     */
    public void flashCardClicked(View view){
        //Log.d("test","FLASHCARD CLICKED");
        boolean isQuestion = cardButton.getText().equals(testGame.peekNextCard()[0]);
        if(isQuestion) {
            cardButton.setText(testGame.peekNextCard()[1]);
            cardTitle.setText("A:");
        }
        else{
            cardButton.setText(testGame.peekNextCard()[0]);
            cardTitle.setText("Q:");
        }
    }


}
