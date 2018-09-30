package com.example.ohimarc.marc.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ohimarc.marc.model.*;

import com.example.ohimarc.marc.R;

public class EditDeckActivity extends AppCompatActivity implements  EditDeckView{


    private Card test = new Card("Test", "Test2");
    private Deck testDeck = new Deck("testDeck");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);
        deckTitles();

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar));
        final TextView card = findViewById(R.id.tv_card);
        editDeckTitle();

        ImageButton addCardButton = findViewById(R.id.fb_add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBasicNote("front of the card", "butt of the card");
                 //card.setText(card.toString());
            }
        });
    }

    public void addBasicNote(String front, String back) {
        testDeck.addBasicNote(front, back);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    public void deckTitles(){
        TextView deckTitle = findViewById(R.id.tv_deck_title);
        deckTitle.setText(testDeck.getTitle());
        //skall vara EditDeckPresenter.getDeckTitle

    }

    public void editDeckTitle(){
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Edit Deck");
    }

}