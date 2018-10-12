package com.example.ohimarc.marc.view.editDeckView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.presenter.EditDeckPresenter;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

import java.util.Objects;

public class EditDeckActivity extends ToolbarExtension implements EditDeckContract.View {
    private EditDeckPresenter editDeckPresenter;
    private Deck deck;
    private AdapterEditDeckRC adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int deckIndex = Objects.requireNonNull(getIntent().getExtras()).getInt("deckIndex");
        deck = MemorizationTrainingTool.getInstance().getActiveUser().getDeck(deckIndex);
        editDeckPresenter = new EditDeckPresenter(this, deckIndex);
        adapter = new AdapterEditDeckRC(editDeckPresenter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);
        deckTitles();

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
                intent.putExtra("noteIndex", -1);
                intent.putExtra("deckIndex", deckIndex);
                startActivity(intent);
            }
        });
        initExtension(this, R.id.activity_edit_deck, "Edit Deck");
    }

    @Override
    protected void onResume() {
        editDeckPresenter.start();
        super.onResume();
    }

    @Override
    public void updateDeckList() {
        RecyclerView revVi = findViewById(R.id.rv_recyclerView);
        Objects.requireNonNull(revVi.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public void deckTitles() {
        TextView deckTitle = findViewById(R.id.tv_deck_title);
        deckTitle.setText(deck.getTitle());
    }

    @Override
    public void promptForDeletion(final int index, Deck deck) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete this card's parent note, as well as its other associated cards?");

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

    /**
     *
     * @param noteIndex is the card in the list that is clicked on
     */
    @Override
    public void editCardInDeck(int noteIndex) {
        Intent intent = new Intent(EditDeckActivity.this, EditNoteActivity.class);
        intent.putExtra("noteIndex", noteIndex);
        startActivity(intent);
    }
}