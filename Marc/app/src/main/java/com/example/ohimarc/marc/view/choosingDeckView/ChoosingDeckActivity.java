package com.example.ohimarc.marc.view.choosingDeckView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ChoosingDeckPresenter;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;
import com.example.ohimarc.marc.view.exerciseView.ExerciseActivity;

/**
 * @author  Victor Johansson (Vroxie on github)
 *
 *
 *  This class is the activity for Choosing a deck you want to play
 */
public class ChoosingDeckActivity extends ToolbarExtension implements ChoosingDeckView {

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

        ChoosingDeckPresenter presenter = new ChoosingDeckPresenter(this);

        setContentView(R.layout.activity_choosing_deck);
        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter mAdapter = new ChoosingDeckAdapter(presenter);
        mRecyclerView.setAdapter(mAdapter);


        initExtension(this, R.id.choosingDeckActivity, "Choose a Deck");
    }


    /**
     * Handles when a deck is pressed, i.e navigates to select game mode screen
     * with that particular deck chosen.
     *
     * @param index what deck in the RecyclerView that has been pressed
     */
    public void deckIsClicked(int index) {
        Intent intent = new Intent(getApplicationContext(), ExerciseActivity.class);
        packBundle(index, intent);
        startActivity(intent);
        finish();
    }

    /**
     * Sets up that should sent to next activity
     *
     * @param index  what deck that should be "packed"
     * @param intent Where to put the data, intent is the object that will be sent to next activity
     */
    private void packBundle(int index, Intent intent) {
        Bundle b = new Bundle();
        b.putInt("deckIndex", index);
        intent.putExtras(b);
    }

}
