package com.example.ohimarc.marc.view.editdeck;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.model.Card;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.presenter.EditDeckPresenter;

import java.util.Objects;

public class EditDeckActivity extends AppCompatActivity implements EditDeckContract.View {


    private Card test = new Card("Test", "Test2");
    private Deck testDeck = new Deck("testDeck");
    private EditDeckPresenter editDeckPresenter = new EditDeckPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);
        deckTitles();
        testDeck.addBasicNote("hej", "san"); // testing purposes

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar));
        editDeckTitle();

        RecyclerView rv = findViewById(R.id.rv_recyclerView);
        rv.setAdapter(new AdapterEditDeckRC(editDeckPresenter));
        editDeckPresenter.start();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);


        ImageButton addCardButton = findViewById(R.id.fb_add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBasicNote("front of the card", "butt of the card");
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
        //this.presenter = presenter;
    }

    @Override
    public void updateDeckList() {
        RecyclerView revVi = findViewById(R.id.rv_recyclerView);
        Objects.requireNonNull(revVi.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public void deckTitles() {
        TextView deckTitle = findViewById(R.id.tv_deck_title);
        deckTitle.setText(testDeck.getTitle());

    }

    @Override
    public void editDeckTitle() {
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Edit Deck");
    }

}