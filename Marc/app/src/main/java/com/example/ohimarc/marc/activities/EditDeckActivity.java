package com.example.ohimarc.marc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ohimarc.marc.models.*;

import com.example.ohimarc.marc.R;

public class EditDeckActivity extends AppCompatActivity {

    private Card test = new Card("Test", "Test2");
    private Deck testDeck = new Deck("testDeck");
    //private RecyclerView mRecyclerView;
    //private RecyclerView.LayoutManager mLayoutManager;
    // recycleview for future, scroll through new cards

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);

        final TextView card = findViewById(R.id.tv_card);
        TextView deckTitle = findViewById(R.id.tv_deck_title);
        deckTitle.setText(testDeck.getTitle());
        //mRecyclerView = (RecyclerView) findViewById(R.id.rc_cards);
        //mLayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(mLayoutManager);

        ImageButton addCardButton = findViewById(R.id.btn_add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card newCard = new Card("New card front", "New card back");
                addCard(newCard);
                card.setText(newCard.toString());
            }
        });
    }

    public void addCard(Card card) {
        testDeck.addCard(card);
    }
}