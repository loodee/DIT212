package com.example.ohimarc.marc.view.mainMenu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.MainMenuPresenter;


public class StartMenuActivity extends AppCompatActivity implements StartMenuContract.View {

    private MainMenuPresenter mainPresenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar));

        mainPresenter = new MainMenuPresenter(getFilesDir().getAbsolutePath());

        RecyclerView rv = findViewById(R.id.userRecyclerView);
        rv.setAdapter(new AdapterUserRC(mainPresenter));
        mainPresenter.start();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        ImageButton addCardButton = findViewById(R.id.floatingActionButton);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddUserPopup(v);
            }
        });

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

    public void showAddUserPopup(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create User");

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.add_user_popup, (ViewGroup) findViewById(R.id.baseLayout), false);
        final EditText input = (EditText) viewInflated.findViewById(R.id.input);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                mainPresenter.createUser(input.getText().toString());
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