package com.example.ohimarc.marc.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.presenter.ResultPresenter;
import com.example.ohimarc.marc.R;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity implements ResultsView {

    ResultPresenter presenter;

    private ArrayList<Integer> value;
    private String deckTitle;
    private String mode;

    private TextView resultText;
    private TextView deckTitleText;
    private TextView modeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));

        resultText = findViewById(R.id.scoreText);
        deckTitleText = findViewById(R.id.deckTitleText);
        modeText = findViewById(R.id.modeText);

        bundleHandler();

        presenter = new ResultPresenter(value, this);
        presenter.onCreate();
    }

    private void bundleHandler() {
        Bundle b = getIntent().getExtras();
        value = null;
        if(b != null) {
            value = b.getIntegerArrayList("results");
            deckTitle = b.getString("deckTitle");
            mode = b.getString("mode");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items,menu);
        return true;
    }

    public void initTexts(int correct, int total) {
        resultText.setText("Score: " + correct + "/" + total);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Results");
        deckTitleText.setText(deckTitle);
        modeText.setText("Mode: " + mode);

    }

    public void retryButton(View v) {
        Intent intent = new Intent(ResultsActivity.this, FlashcardActivity.class);
        startActivity(intent);
        finish();
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
