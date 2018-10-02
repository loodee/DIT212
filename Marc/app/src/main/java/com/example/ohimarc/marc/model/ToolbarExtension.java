package com.example.ohimarc.marc.model;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
    protected DrawerLayout mView;
    protected ActionBarDrawerToggle mButton;

    private void initViews(int viewID) {
        tb = findViewById(R.id.toolbar);
        titleText = findViewById(R.id.toolbar_text);
        mView = findViewById(viewID);
    }

    private void supportToolbar() {
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private void initmButton(Activity act) {
        mButton = new ActionBarDrawerToggle(act, mView, R.string.Open, R.string.Close);
        mView.addDrawerListener(mButton);
        mButton.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void initToolbar(Activity activity, int viewID, String title) {
        initViews(viewID);
        supportToolbar();
        initmButton(activity);
        titleText.setText(title);
    }

    protected void initToolbar(Activity activity, int viewID){
        initViews(viewID);
        supportToolbar();
        initmButton(activity);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mButton.onOptionsItemSelected(item)) {
            return true;
        }
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
