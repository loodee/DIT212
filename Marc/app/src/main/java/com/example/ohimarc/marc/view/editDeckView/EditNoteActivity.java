package com.example.ohimarc.marc.view.editDeckView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.EditNotePresenter;

import java.util.Objects;

public class EditNoteActivity extends AppCompatActivity implements EditNoteView {
    private EditNotePresenter presenter;
    private TextInputLayout frontLayout, backLayout, clozeLayout;
    private EditText frontEditText, backEditText, clozeEditText;
    private Toast toast;
    private boolean isEditing;
    private Spinner dropdown;
    private NoteType type;

    private enum NoteType {BASIC, CLOZE}

    private void setupVars(int noteIndex, int deckIndex) {
        frontLayout = findViewById(R.id.textInputFront);
        backLayout = findViewById(R.id.textInputBack);
        clozeLayout = findViewById(R.id.textInputCloze);
        frontEditText = findViewById(R.id.input_front);
        backEditText = findViewById(R.id.input_back);
        clozeEditText = findViewById(R.id.input_cloze);
        dropdown = findViewById(R.id.s_spinner);

        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
        ActionBar bar = getSupportActionBar();

        if (noteIndex == -1) {      // if adding a new Note
            isEditing = false;
            if (bar != null) bar.setTitle("Add Note");
        } else {                    // if editing an existing Note
            isEditing = true;
            if (bar != null) bar.setTitle("Edit Note");
        }

        presenter = new EditNotePresenter(this, noteIndex, deckIndex, getFilesDir().getAbsolutePath());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        int noteIndex = Objects.requireNonNull(getIntent().getExtras()).getInt("noteIndex");
        int deckIndex = getIntent().getExtras().getInt("deckIndex");

        setupVars(noteIndex, deckIndex);

        setupDropdown();
        setupListeners();
        setupToast();
    }

    public void selfDestruct() {
        finishAfterTransition();
    }

    public void setupBasic(String front, String back) {
        frontEditText.setText(front);
        backEditText.setText(back);

        type = NoteType.BASIC;
    }

    public void setupCloze(String text) {
        clozeEditText.setText(text);

        type = NoteType.CLOZE;
    }

    public void setupNew() {
        type = NoteType.BASIC;
    }

    public void confirmAdd(View v) {
        confirmAdd();
    }

    private void confirmAdd() {
        switch (type) {
            case BASIC:
                confirmAddBasic();
                break;
            case CLOZE:
                confirmAddCloze();
                break;
        }
    }

    private void confirmAddBasic() {
        String frontText = frontEditText.getText().toString();
        String backText = backEditText.getText().toString();

        presenter.confirmAddBasicClicked(frontText, backText, isEditing);
    }

    private void confirmAddCloze() {
        String clozeText = clozeEditText.getText().toString();

        presenter.confirmAddClozeClicked(clozeText, isEditing);
    }

    public void resetInputs() {
        frontEditText.setText("");
        backEditText.setText("");
        clozeEditText.setText("");

        switch (type) {
            case BASIC:
                frontEditText.requestFocus();
                break;
            case CLOZE:
                clozeEditText.requestFocus();
                break;
        }
    }

    public void showToast() {
        toast.show();
    }

    public void showErrors() {
        if (type == NoteType.BASIC) {
            String errorMsg = "Field cannot be blank.";
            String frontText = frontEditText.getText().toString();
            String backText = backEditText.getText().toString();

            if (presenter.invalidInput(frontText)) frontLayout.setError(errorMsg);
            if (presenter.invalidInput(backText)) backLayout.setError(errorMsg);
        } else if (type == NoteType.CLOZE) {
            // TODO: Implement more specific error messages
            String errorMsg = "Invalid cloze note syntax.";
            String clozeText = clozeEditText.getText().toString();

            if (presenter.invalidInputCloze(clozeText)) clozeLayout.setError(errorMsg);
        }
    }

    private void hideErrors() {
        frontLayout.setError(null);
        backLayout.setError(null);
        clozeLayout.setError(null);
    }

    private void setupDropdown() {
        String[] items = new String[]{"Basic note", "Cloze note"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        int selection;
        switch (type) {
            case BASIC:
                selection = 0;
                break;
            case CLOZE:
                selection = 1;
                break;
            default:
                selection = 0;
        }
        dropdown.setSelection(selection);
    }

    @SuppressLint("ShowToast")
    private void setupToast() {
        Context context = getApplicationContext();
        CharSequence text = "Note saved.";
        int duration = Toast.LENGTH_SHORT;

        toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.TOP, 0, 16);
    }

    private void basicSelected() {
        frontLayout.setVisibility(View.VISIBLE);
        backLayout.setVisibility(View.VISIBLE);
        clozeLayout.setVisibility(View.GONE);

        type = NoteType.BASIC;
    }

    private void clozeSelected() {
        frontLayout.setVisibility(View.GONE);
        backLayout.setVisibility(View.GONE);
        clozeLayout.setVisibility(View.VISIBLE);

        type = NoteType.CLOZE;
    }

    private void setupListeners() {
        clozeEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
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
        clozeEditText.addTextChangedListener(new TextWatcher() {
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
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (id == 0) basicSelected();
                else if (id == 1) clozeSelected();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
}
