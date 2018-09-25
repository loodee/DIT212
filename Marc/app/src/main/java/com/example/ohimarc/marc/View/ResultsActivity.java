package com.example.ohimarc.marc.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.ohimarc.marc.R;

public class ResultsActivity extends AppCompatActivity implements ResultsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
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
