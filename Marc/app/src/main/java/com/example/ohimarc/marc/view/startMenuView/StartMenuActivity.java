package com.example.ohimarc.marc.view.startMenuView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.StartMenuPresenter;
import com.example.ohimarc.marc.view.homeView.HomeActivity;


/**
 * @author Gustav Albertsson
 *
 * Activity for showing the startMenu, this activity is responsible for choosing a user.
 * */
public class StartMenuActivity extends AppCompatActivity implements StartMenuView {

    private StartMenuPresenter mainPresenter;
    private AdapterUserRC adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        mainPresenter = new StartMenuPresenter(this,getFilesDir().getAbsolutePath());

        if(mainPresenter.loggedIn()){
            login();
        }

        RecyclerView rv = findViewById(R.id.userRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        adapter = new AdapterUserRC(mainPresenter);

        rv.setAdapter(adapter);

        ImageButton addCardButton = findViewById(R.id.floatingActionButton);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddUserPopup();
            }
        });

    }

    private void showAddUserPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create User");

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.add_user_popup, (ViewGroup) findViewById(R.id.baseLayout), false);
        final EditText input = viewInflated.findViewById(R.id.input);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                mainPresenter.createUser(input.getText().toString());
                adapter.notifyDataSetChanged();
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

    public void login() {
        Intent intent = new Intent(StartMenuActivity.this, HomeActivity.class);

        startActivity(intent);
        finish();
    }

    @Override
    public void promptForDeletion(final int index, String name) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure you want to delete " + name + "?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mainPresenter.confirmDeletion(index);
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