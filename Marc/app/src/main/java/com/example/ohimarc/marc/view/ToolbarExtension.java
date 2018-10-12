package com.example.ohimarc.marc.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ToolbarExtensionPresenter;
import com.example.ohimarc.marc.view.choosingDeck.ChoosingDeckActivity;
import com.example.ohimarc.marc.view.mainMenu.StartMenuActivity;

import java.util.Objects;

abstract public class ToolbarExtension extends AppCompatActivity implements ToolbarExtensionView {

    private ToolbarExtensionPresenter presenter;

    protected TextView titleText;
    private Toolbar tb;
    private DrawerLayout navView;
    private ActionBarDrawerToggle navToggle;
    private NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ToolbarExtensionPresenter(this, getFilesDir().getAbsolutePath());
    }

    private void initViews(int viewID) {
        tb = findViewById(R.id.toolbar);
        titleText = findViewById(R.id.toolbar_text);
        navView = findViewById(viewID);
        navigation = findViewById(R.id.activity_navigation);
    }

    private void setUpToolbar() {
        setSupportActionBar(tb);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

    }

    private void initNavToggle(Activity act) {
        navToggle = new ActionBarDrawerToggle(act, navView, R.string.open, R.string.close);
        navView.addDrawerListener(navToggle);
        navToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    protected void initExtension(Activity activity, int viewID, String title) {
        initViews(viewID);
        setUpToolbar();
        initNavToggle(activity);
        initNavigationListeners();
        titleText.setText(title);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items, menu);
        return true;
    }

    private boolean thisActivityIsNextActivity(Class<?> nextClass) {
        if (this.getClass().getSimpleName().equals(nextClass.getSimpleName())) {
            return true;
        }
        return false;
    }

    private boolean inHome() {
        if (this.getClass().getSimpleName().equals(HomeActivity.class.getSimpleName())) {
            return true;
        }
        return false;
    }

    private void initNavigationListeners() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                Class<?> nextActivity;
                switch (menuItem.getItemId()) {
                    case (R.id.home_button):            //Special case, home is not allowed to be finished.
                        navView.closeDrawers();
                        if (!inHome()) {
                            finish();
                        }
                        return true;
                    case (R.id.exercises_button):
                        intent = new Intent(getApplicationContext(), ChoosingDeckActivity.class);
                        nextActivity = ChoosingDeckActivity.class;
                        break;
                    case (R.id.achievements_button):
                        intent = null;
                        nextActivity = null;
                        break;
                    case (R.id.decks_button):
                        intent = new Intent(getApplicationContext(), AddRemoveDeckActivity.class);
                        nextActivity = AddRemoveDeckActivity.class;
                        break;
                    case (R.id.settings_button):
                        intent = null;
                        nextActivity = null;
                        break;
                    default:
                        intent = null;
                        nextActivity = null;
                        break;
                }
                if (intent != null) {
                    if (inHome()) {
                        navView.closeDrawers();
                        startActivity(intent);
                    } else if (thisActivityIsNextActivity(nextActivity)) {
                        navView.closeDrawers();
                    } else {
                        startActivity(intent);
                        finish();
                    }
                }
                return true;
            }
        });
    }

    public void logoutClicked(View v) {
        presenter.logoutButton();
    }

    public void navigateLogout() {
        Intent intent = new Intent(getApplicationContext(), StartMenuActivity.class);
        startActivity(intent);
        finish();
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
