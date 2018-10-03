package com.example.ohimarc.marc.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AddNotePresenter;

public class AddNoteActivity extends AppCompatActivity implements AddNoteView {
    private AddNotePresenter presenter = new AddNotePresenter(this);

    private TextInputLayout frontLayout, backLayout;
    private EditText frontEditText, backEditText;

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
        ActionBar bar = getSupportActionBar();
        if (bar != null) bar.setTitle("Add Note");

        frontLayout = findViewById(R.id.textInputFront);
        backLayout = findViewById(R.id.textInputBack);
        frontEditText = findViewById(R.id.input_front);
        backEditText = findViewById(R.id.input_back);

        setupListeners();
        setupToast();

        presenter.onCreate();
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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    public void confirmAdd(View v) {
        confirmAdd();
    }

    public void confirmAdd() {
        String frontText = frontEditText.getText().toString();
        String backText = backEditText.getText().toString();

        presenter.confirmAddClicked(frontText, backText);
    }

    public void resetInputs() {
        frontEditText.setText("");
        backEditText.setText("");
        frontEditText.requestFocus();
    }

    public void showToast() {
        toast.show();
    }

    public void showErrors() {
        String errorMsg = "Field cannot be blank.";
        String frontText = frontEditText.getText().toString();
        String backText = backEditText.getText().toString();

        if (presenter.invalidInput(frontText)) frontLayout.setError(errorMsg);
        if (presenter.invalidInput(backText)) backLayout.setError(errorMsg);
    }

    private void hideErrors() {
        frontLayout.setError(null);
        backLayout.setError(null);
    }

    private void setupToast() {
        Context context = getApplicationContext();
        CharSequence text = "Note saved.";
        int duration = Toast.LENGTH_SHORT;

        toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.TOP, 0, 16);
    }

    private void setupListeners() {
        backEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
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
        frontEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hideErrors();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        backEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hideErrors();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
