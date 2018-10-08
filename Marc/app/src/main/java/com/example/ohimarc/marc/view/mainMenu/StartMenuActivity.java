package com.example.ohimarc.marc.view.mainMenu;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.MainMenuPresenter;
import com.example.ohimarc.marc.view.Home;



public class StartMenuActivity extends AppCompatActivity implements StartMenuView {
    private MainMenuPresenter mainPresenter;
    private AdapterUserRC adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar));

        mainPresenter = new MainMenuPresenter(this,getFilesDir().getAbsolutePath());
        mainPresenter.start();

        RecyclerView rv = findViewById(R.id.userRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        adapter = new AdapterUserRC(mainPresenter);

        rv.setAdapter(adapter);

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
        Intent intent = new Intent(StartMenuActivity.this, Home.class);

        startActivity(intent);
        finish();
    }

    public void failedUserCreation(){
        Toast.makeText(this, "Failed to create user! Make sure the app has permission to read/write" ,Toast.LENGTH_LONG).show();
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