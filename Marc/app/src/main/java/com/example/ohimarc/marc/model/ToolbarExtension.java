package com.example.ohimarc.marc.model;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.example.ohimarc.marc.R;

abstract public class ToolbarExtension extends AppCompatActivity {

    public TextView titleText;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items,menu);
        return true;
    }

    protected void initiateToolbar(String title) {
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        tb.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleText = findViewById(R.id.toolbar_text);
        titleText.setText(title);
    }

    protected void initiateToolbar() {
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        tb.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleText = findViewById(R.id.toolbar_text);
    }
}
