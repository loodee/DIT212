package com.example.ohimarc.marc.view.toolbarExtensionView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.ToolbarExtensionPresenter;
import com.example.ohimarc.marc.view.addRemoveDeckView.AddRemoveDeckActivity;
import com.example.ohimarc.marc.view.homeView.HomeActivity;
import com.example.ohimarc.marc.view.choosingDeckView.ChoosingDeckActivity;
import com.example.ohimarc.marc.view.startMenuView.StartMenuActivity;
import com.example.ohimarc.marc.view.achievementsView.AchievementsActivity;
import com.example.ohimarc.marc.view.statsView.StatsActivity;

import java.util.Objects;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * The purpose of this abstract Activity is to simplify the usage of our applications toolbar and
 * quick menu in any Activity that needs a toolbar and quick menu. It contains multiple helper
 * methods, where it sets up the toolbar and side menu. It also contains methods for navigation
 * for the quick menu.
 */

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

    /**
     * This function is a helper function to initExtension. This function initializes some local
     * objects.
     *
     * @param viewID is the ID of the view that the ToolbarExtension is currently active for.
     */

    private void initViews(int viewID) {
        tb = findViewById(R.id.toolbar);
        titleText = findViewById(R.id.toolbar_text);
        navView = findViewById(viewID);
        navigation = findViewById(R.id.activity_navigation);
    }

    /**
     * This function sets the support for a custom Toolbar and removes the standard title from it.
     * It is designed to be a helper function for initExtension.
     */

    private void setUpToolbar() {
        setSupportActionBar(tb);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
    }

    /**
     * This function initializes the navigation button in the toolbar. It is designed to be a
     * helper function for initExtension.
     *
     * @param act is the Activity in which this navigation buttons is currently active for.
     */

    private void initNavToggle(Activity act) {
        navToggle = new ActionBarDrawerToggle(act, navView, R.string.open, R.string.close);
        navView.addDrawerListener(navToggle);
        navToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    /**
     * This function sets up the customized toolbar and navigation view for any activity which
     * decides to extend this class. It utilizes the helper functions above, to make it easy
     * for an activity to set everything up, reducing the copy and paste of code throughout
     * the program.
     *
     * @param activity is the Activity in which the ToolbarExtension is currently active for.
     * @param viewID   is the ID of the view in which the ToolbarExtension is currently active for.
     * @param title    is a String that is desired to be the title of the current Activity.
     */

    protected void initExtension(Activity activity, int viewID, String title) {
        initViews(viewID);
        setUpToolbar();
        initNavToggle(activity);
        initNavigationListeners();
        titleText.setText(title);
    }

    /**
     * @param nextClass is the class which marks the next Activity to be navigated to.
     * @return true if this activity is also the next activity. false otherwise.
     */

    private boolean thisActivityIsNextActivity(Class<?> nextClass) {
        return this.getClass().getSimpleName().equals(nextClass.getSimpleName());
    }

    /**
     * @return true if the current Activity is HomeActivity.
     */

    private boolean inHome() {
        return this.getClass().getSimpleName().equals(HomeActivity.class.getSimpleName());
    }

    /**
     * This function handles any navigation through the quick menu, using a case switch.
     * If the user clicks a navigation item, an Intent is set, and the variable nextActivity is
     * set. There is a special case. If the user clicks home, the switch will finish the current
     * Activity if it isn't HomeActivity. Otherwise it will just close the quick menu. This will
     * also finish the function.
     * After this, if the Intent isn't set to null, navigation will be commenced, commented further
     * below.
     */

    private void initNavigationListeners() {
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                Class<?> nextActivity;
                switch (menuItem.getItemId()) {
                    case (R.id.home_button):            //Special case, home is not allowed to be finished.
                        navView.closeDrawers();
                        if (!inHome()) finish();
                        return true;
                    case (R.id.exercises_button):
                        intent = new Intent(getApplicationContext(), ChoosingDeckActivity.class);
                        nextActivity = ChoosingDeckActivity.class;
                        break;
                    case (R.id.achievements_button):
                        intent = new Intent(getApplicationContext(), AchievementsActivity.class);
                        nextActivity = AchievementsActivity.class;
                        break;
                    case (R.id.decks_button):
                        intent = new Intent(getApplicationContext(), AddRemoveDeckActivity.class);
                        nextActivity = AddRemoveDeckActivity.class;
                        break;
                    case (R.id.stats_button):
                        intent = new Intent(getApplicationContext(), StatsActivity.class);
                        nextActivity = StatsActivity.class;
                        break;
                    default:
                        intent = null;
                        nextActivity = null;
                        break;
                }
                if (intent != null) {
                    if (inHome()) {                                             //If you're in HomeActivity:
                        navView.closeDrawers();                                 //Close the quick menu -
                        startActivity(intent);                                  //Start the next Activity.
                    } else if (thisActivityIsNextActivity(nextActivity)) {      //if current Activity is the next Activity:
                        navView.closeDrawers();                                 //Close the quick menu.
                    } else {                                                    //If none of the above:
                        startActivity(intent);                                  //Start the next Activity -
                        finish();                                               //Finish the current Activity.
                    }
                }
                return true;
            }
        });
    }

    /**
     * This is a function called from the XML-file activity_navigation. It calls the function
     * logoutButton in ToolbarExtensionPresenter.
     *
     * @param v is a View which in this case is the XML-file activity_navigation.
     */
    public void logoutClicked(View v) {
        presenter.logoutButton();
    }

    /**
     * This function navigates the user to the "Login screen", if a successful logout has been
     * made earlier.
     */
    public void navigateLogout() {
        Intent intent = new Intent(getApplicationContext(), StartMenuActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * This function handles the click action of the navigation item in the toolbar.
     *
     * @param item is a required MenuItem when Overriding this function.
     * @return true if navToggle was selected. Pass the call to the super class otherwise.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return navToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
