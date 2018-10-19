package com.example.ohimarc.marc.view.addRemoveDeckView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AddRemoveDeckPresenter;
import com.example.ohimarc.marc.view.editDeckView.EditDeckActivity;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

/**
 * @author Victor Johansson, (Vroxie on github)
 */

/**
 * This class is the activity for viewing the users decks
 * The user can scroll through his/her decks and also add or remove decks
 */
public class AddRemoveDeckActivity extends ToolbarExtension implements AddDeckView {

    private RecyclerView.Adapter mAdapter;

    private AddRemoveDeckPresenter presenter;

    /**
     * Sets up the screen when this activity is started
     * Such as recyclerview, which layout file shall be ran etc.
     *
     * @param savedInstanceState what was active when last closed this screen
     *                           in case you want to save something
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new AddRemoveDeckPresenter(this, getFilesDir().getAbsolutePath());

        setContentView(R.layout.activity_add_remove_deck);
        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new AddRemoveAdapter(presenter);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        initExtension(this, R.id.addRemoveDeckActivity, "Decks");
    }

    /**
     * Handles the press on the "Add-deck" button
     * Creates a popup where the user types in what the title of deck should be
     * Then tells the presenter to add a deck with that particular title the list of decks
     *
     * @param v What view that has been pressed
     */
    public void addButtonClicked(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create Deck");

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.add_deck_popup, (ViewGroup) findViewById(R.id.baseLayout), false);
        final EditText input = viewInflated.findViewById(R.id.input);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s = input.getText().toString();
                if (s.replaceAll("\\s", "").isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You cant create a deck without a name!", Toast.LENGTH_LONG).show();
                } else {
                    presenter.addDeck(input.getText().toString());
                    mAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
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
     * Handles deletion of a deck, i.e the user has swiped a deck
     * Sets up a popup that asks the user if he/she is sure of the deletion of that deck
     * If the user really wants to delete then, tells the presenter to delete that deck from the list of decks
     *
     * @param deckIndex what deck that have been swiped, i.e what deck that may be shall be deleted
     */
    private void deleteDeck(final int deckIndex) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do you really want to delete this deck?");

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.delete_deck_popup, (ViewGroup) findViewById(R.id.baseLayout), false);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                presenter.deleteDeck(deckIndex);
                mAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                mAdapter.notifyDataSetChanged();
            }
        });

        builder.show();
    }

    /**
     * Handles if a deck is pressed
     * If pressed then send the user to a new activity where that decks' cards/notes can be viewed
     *
     * @param deckIndex what deck that has been pressed
     */
    @Override
    public void deckIsClicked(int deckIndex) {
        Intent intent = new Intent(AddRemoveDeckActivity.this, EditDeckActivity.class);
        intent.putExtra("deckIndex", deckIndex);
        startActivity(intent);
        finish();
    }

    /**
     * This object handles the swiping of decks in the recyclerview
     * So it decides which direction it is possible to swiped etc.
     */
    private final ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        /**
         * Handles if a deck is moved
         * @param recyclerView which is recyclerview this object is contained
         * @param viewHolder the viewholder for that recyclerview
         * @param target the viewholder for that item has been moved
         * @return do nothing since it should not be possible to move the decks
         */
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        /**
         * Handles if a deck is swiped
         * Points out which deck that has been swiped and sends that to deleteDeck(int index)
         * @param viewHolder The viewholder for that item that has been swiped
         * @param swipeDir which direction the decks has been swiped( in our case that does not matter)
         */
        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            /*
            Point out which element that has been swiped
             */
            int position = viewHolder.getAdapterPosition();
            deleteDeck(position);
        }


    };

}

