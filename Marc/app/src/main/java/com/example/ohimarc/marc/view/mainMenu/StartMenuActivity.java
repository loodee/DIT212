package com.example.ohimarc.marc.view.mainMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.MainMenuPresenter;


public class StartMenuActivity extends AppCompatActivity implements StartMenuContract.View {


    private MainMenuPresenter mainPresenter = new MainMenuPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar));


        RecyclerView rv = findViewById(R.id.userRecyclerView);
        rv.setAdapter(new AdapterUserRC(mainPresenter));
        mainPresenter.start();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);


        //TODO: change to onclick
        /*ImageButton addCardButton = findViewById(R.id.fb_add_card_button);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBasicNote("front of the card", "butt of the card");
            }
        });*/
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    @Override
    public void setPresenter(StartMenuContract.Presenter presenter) {

    }

    @Override
    public void updateDeckList() {

    }

    @Override
    public void deckTitles() {

    }

    @Override
    public void editDeckTitle() {

    }
}