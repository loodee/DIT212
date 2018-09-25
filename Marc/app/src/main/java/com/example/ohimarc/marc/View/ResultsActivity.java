package com.example.ohimarc.marc.View;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.example.ohimarc.marc.Presenter.ResultPresenter;
import com.example.ohimarc.marc.R;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity implements ResultsView {

    private ArrayList<Integer> value;
    private String deckTitle;

    ResultPresenter presenter;
    private TextView resultText;
    private TextView deckTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));

        resultText = findViewById(R.id.scoreText);
        deckTitleText = findViewById(R.id.deckTitleText);

        Bundle b = getIntent().getExtras();
        value = null; // or other values
        if(b != null) {
            value = b.getIntegerArrayList("fromFCtoResults");
            deckTitle = b.getString("deckTitle");
        }
        presenter = new ResultPresenter(value, this);
        presenter.onCreate();
    }

    public void initTexts(int correct, int total) {
        resultText.setText("Score: " + correct + "/" + total);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Results");
        deckTitleText.setText(deckTitle);

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

    public void retryButton() {

    }

    public void returnButton(){

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items,menu);
        return true;
    }
}
