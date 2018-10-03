package com.example.ohimarc.marc.view;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
    protected DrawerLayout navView;
    protected ActionBarDrawerToggle navToggle;
    protected NavigationView navigation;

    private void initViews(int viewID) {
        tb = findViewById(R.id.toolbar);
        titleText = findViewById(R.id.toolbar_text);
        navView = findViewById(viewID);
        navigation = findViewById(R.id.navigation);
    }

    private void setUpToolbar() {
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private void initNavToggle(Activity act) {
        navToggle = new ActionBarDrawerToggle(act, navView, R.string.Open, R.string.Close);
        navView.addDrawerListener(navToggle);
        navToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void initExtension(Activity activity, int viewID, String title) {
        initViews(viewID);
        setUpToolbar();
        initNavToggle(activity);
        initNavigationListeners();
        titleText.setText(title);
    }

    protected void initExtension(Activity activity, int viewID) {
        initViews(viewID);
        setUpToolbar();
        initNavToggle(activity);
        initNavigationListeners();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    private boolean currentActivityEqualsNextActivity(String className) {
        if (this.getClass().getSimpleName().equals(className)) {
            return true;
        }
        return false;
    }

    private void initNavigationListeners() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case (R.id.home_button):
                        if (!currentActivityEqualsNextActivity(Home.class.getSimpleName())) {
                            Intent intent = new Intent(getApplicationContext(), Home.class);
                            startActivity(intent);
                            finish();
                        }
                        navView.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

    public void logoutClicked(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Logout Clicked", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (navToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}