package com.example.ohimarc.marc.view.editdeck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.model.Card;
import com.example.ohimarc.marc.model.Deck;

public class EditDeckActivity extends AppCompatActivity implements EditDeckContract.View{


    private Card test = new Card("Test", "Test2");
    private Deck testDeck = new Deck("testDeck");
    private EditDeckContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);
        //deckTitles(); fixa metoden igen
        testDeck.addBasicNote("hej", "san"); // testing purposes

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar));
        final TextView card = findViewById(R.id.tv_card);
        //editDeckTitle(); fixa metoden igen igen


        RecyclerView rv = findViewById(R.id.rv_recyclerView);
        rv.setAdapter(new AdapterEditDeckRC(presenter));
        //TODO logiken e klar ska stoppa datan i listan?



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


    public void setPresenter(EditDeckContract.Presenter presenter) {
        this.presenter = presenter;
    }
}