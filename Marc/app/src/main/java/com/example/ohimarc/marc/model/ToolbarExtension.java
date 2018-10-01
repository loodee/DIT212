package com.example.ohimarc.marc.model;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ohimarc.marc.R;

abstract public class ToolbarExtension extends AppCompatActivity {

    protected TextView titleText;
    protected Toolbar tb;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    private void initHelp() {
        tb = findViewById(R.id.toolbar);
        titleText = findViewById(R.id.toolbar_text);
    }

    protected void initiateToolbar(String title) {
        initHelp();
        setSupportActionBar(tb);
        tb.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleText.setText(title);
    }

    protected void initiateToolbar() {
        initHelp();
        setSupportActionBar(tb);
        tb.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void initiateMenu() {
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Menu selected", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast toast = Toast.makeText(getApplicationContext(), "Settings selected", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
