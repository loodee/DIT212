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

public class EditDeckActivity extends AppCompatActivity {

    private Card test = new Card("Test", "Test2");
    private Deck testDeck = new Deck("testDeck");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);
        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar));
        final TextView card = findViewById(R.id.tv_card);
        TextView deckTitle = findViewById(R.id.tv_deck_title);
        deckTitle.setText(testDeck.getTitle());
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Edit Deck");


        ImageButton addCardButton = findViewById(R.id.btn_add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBasicNote("front of the card", "butt of the card");
                // card.setText(newCard.toString());
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
}