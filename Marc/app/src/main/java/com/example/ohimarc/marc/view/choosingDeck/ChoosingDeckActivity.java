package com.example.ohimarc.marc.view.choosingDeck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ChoosingDeckPresenter;
import com.example.ohimarc.marc.view.ToolbarExtension;
import com.example.ohimarc.marc.view.exerciseView.ExerciseActivity;


public class ChoosingDeckActivity extends ToolbarExtension implements ChoosingDeckView{


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ChoosingDeckPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new ChoosingDeckPresenter(this);

        setContentView(R.layout.activity_choosing_deck);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new ChoosingDeckAdapter(presenter);
        mRecyclerView.setAdapter(mAdapter);



        initExtension(this, R.id.choosingDeckActivity, "Choose a Deck");
    }


    public void deckIsClicked(int index) {
        Intent intent = new Intent(getApplicationContext(), ExerciseActivity.class);
        packBundle(index,intent);
        startActivity(intent);
        finish();
    }

    private void packBundle(int index, Intent intent){
        Bundle b = new Bundle();
        b.putInt("deckIndex",index);
        intent.putExtras(b);
    }

}
