package com.example.ohimarc.marc.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AddNotePresenter;

public class AddNoteActivity extends AppCompatActivity implements AddNoteView {

    AddNotePresenter presenter = new AddNotePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Add Note");
        presenter.onCreate();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    public void confirmAdd(View v) {
        String front = ((EditText) findViewById(R.id.input_front)).getText().toString();
        String back = ((EditText) findViewById(R.id.input_back)).getText().toString();
        presenter.confirmAddClicked(front, back);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
