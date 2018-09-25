package com.example.ohimarc.marc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ohimarc.marc.models.*;
import com.example.ohimarc.marc.R;

public class FlashcardActivity extends AppCompatActivity {

    private Card test = new Card("Test","Test2");
    private Button cardButton;
    private TextView cardTitle;
    private TextView deckTitle;
    private Deck testDeck = new Deck("testDeck");
    private FlashCardGame testGame = new FlashCardGame(testDeck);


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        cardButton = (Button)findViewById(R.id.cardButton);
        cardTitle = (TextView)findViewById(R.id.cardTitle);
        deckTitle = (TextView)findViewById(R.id.deckTitle);
        cardTitle.setText("Q");
        testDeck.addCard(test.getFront(),test.getBack());
        cardButton.setText(testDeck.getCardInfo(0)[0]);
        deckTitle.setText(testDeck.getTitle());
    }

    public void flashCardClicked(View view){
        //Log.d("test","FLASHCARD CLICKED");
        if(cardButton.getText().equals(testDeck.getCardInfo(0)[0])) {
            cardButton.setText(testDeck.getCardInfo(0)[1]);
            cardTitle.setText("A");
        }
        else{
            cardButton.setText(testDeck.getCardInfo(0)[0]);
            cardTitle.setText("Q");
        }
    }


}
