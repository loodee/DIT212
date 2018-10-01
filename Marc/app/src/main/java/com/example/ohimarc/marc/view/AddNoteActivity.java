package com.example.ohimarc.marc.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AddNotePresenter;

public class AddNoteActivity extends AppCompatActivity implements AddNoteView {

    private AddNotePresenter presenter = new AddNotePresenter(this);

    private EditText front;
    private EditText back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Add Note");

        front = findViewById(R.id.input_front);
        back = findViewById(R.id.input_back);

        setupListeners();

        presenter.onCreate();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    public void confirmAdd(View v) {
        confirmAdd();
    }

    public void confirmAdd() {
        String frontText = front.getText().toString();
        String backText = back.getText().toString();
        presenter.confirmAddClicked(frontText, backText);
    }

    public void clearInputs() {
        front.setText("");
        back.setText("");
    }

    public void resetFocus() {
        front.requestFocus();
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

    private void setupListeners() {
        back.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    confirmAdd();
                    handled = true;
                }
                return handled;
            }
        });
    }
}
