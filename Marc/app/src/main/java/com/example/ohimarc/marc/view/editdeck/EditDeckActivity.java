package com.example.ohimarc.marc.view.editdeck;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.presenter.EditDeckPresenter;

import java.util.Objects;

public class EditDeckActivity extends AppCompatActivity implements EditDeckContract.View {


    private Deck testDeck = new Deck("testDeck");
    private EditDeckPresenter editDeckPresenter = new EditDeckPresenter(this);
    private AdapterEditDeckRC adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        adapter = new AdapterEditDeckRC(editDeckPresenter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);
        deckTitles();

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar));
        editDeckTitle();

        RecyclerView rv = findViewById(R.id.rv_recyclerView);
        rv.setAdapter(adapter);
        editDeckPresenter.start();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);


        ImageButton addCardButton = findViewById(R.id.fb_add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditDeckActivity.this, EditNoteActivity.class);
                intent.putExtra("index", -1);
                startActivity(intent);
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    @Override
    protected void onResume() {
        editDeckPresenter.start();
        super.onResume();
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

    @Override
    public void promptForDeletion(final int index, Deck deck) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure you want to delete " + deck + "?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editDeckPresenter.confirmDeletion(index);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


}