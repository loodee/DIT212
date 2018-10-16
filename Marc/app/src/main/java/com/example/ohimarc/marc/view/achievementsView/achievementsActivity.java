package com.example.ohimarc.marc.view.achievementsView;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AchievementsPresenter;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

/**
 * @author Alexander Sandberg (alexandersand on github)
 */

public class AchievementsActivity extends ToolbarExtension implements AchievementsView {


    private final Button[] buttons = new Button[16];
    private Drawable trophy;

    private AchievementsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        initItems();
        presenter = new AchievementsPresenter(this, buttons.length);
        initExtension(this, R.id.activity_achievements, "Achievements");
    }

    /**
     * This method initializes all items to be used in this Activity. It also adds all initialized
     * Button objects to the Button list buttons.
     */
    private void initItems() {
        trophy = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_trophy);

        Button ach0 = findViewById(R.id.ach1);
        buttons[0] = ach0;
        Button ach1 = findViewById(R.id.ach2);
        buttons[1] = ach1;
        Button ach2 = findViewById(R.id.ach3);
        buttons[2] = ach2;
        Button ach3 = findViewById(R.id.ach4);
        buttons[3] = ach3;
        Button ach4 = findViewById(R.id.ach5);
        buttons[4] = ach4;
        Button ach5 = findViewById(R.id.ach6);
        buttons[5] = ach5;
        Button ach6 = findViewById(R.id.ach7);
        buttons[6] = ach6;
        Button ach7 = findViewById(R.id.ach8);
        buttons[7] = ach7;
        Button ach8 = findViewById(R.id.ach9);
        buttons[8] = ach8;
        Button ach9 = findViewById(R.id.ach10);
        buttons[9] = ach9;
        Button ach10 = findViewById(R.id.ach11);
        buttons[10] = ach10;
        Button ach11 = findViewById(R.id.ach12);
        buttons[11] = ach11;
        Button ach12 = findViewById(R.id.ach13);
        buttons[12] = ach12;
        Button ach13 = findViewById(R.id.ach14);
        buttons[13] = ach13;
        Button ach14 = findViewById(R.id.ach15);
        buttons[14] = ach14;
        Button ach15 = findViewById(R.id.ach16);
        buttons[15] = ach15;
    }


    /**
     * This method sets the background of a Button in the list buttons to the look of a trophy,
     * marking that the achievement has been achieved.
     *
     * @param index is the index of the Button object in buttons that is to be manipulated.
     */
    public void unlockAchievement(int index) {
        buttons[index].setBackground(trophy);
    }

    /**
     * This method hides a Button object in buttons, making it invisible for the user.
     *
     * @param index is the index of the Button object in buttons that is to be manipulated.
     */
    public void hideAchievement(int index) {
        buttons[index].setVisibility(View.INVISIBLE);
    }

    /**
     * This method handles all button presses in the view with a case switch. It gives an index to
     * the presenter, marking which button has been clicked.
     *
     * @param view is a View, which in this case is activity_achievements.
     */

    public void buttonPress(View view) {
        switch (view.getId()) {
            case R.id.ach1:
                presenter.achievementClicked(0);
                break;
            case R.id.ach2:
                presenter.achievementClicked(1);
                break;
            case R.id.ach3:
                presenter.achievementClicked(2);
                break;
            case R.id.ach4:
                presenter.achievementClicked(3);
                break;
            case R.id.ach5:
                presenter.achievementClicked(4);
                break;
            case R.id.ach6:
                presenter.achievementClicked(5);
                break;
            case R.id.ach7:
                presenter.achievementClicked(6);
                break;
            case R.id.ach8:
                presenter.achievementClicked(7);
                break;
            case R.id.ach9:
                presenter.achievementClicked(8);
                break;
            case R.id.ach10:
                presenter.achievementClicked(9);
                break;
            case R.id.ach11:
                presenter.achievementClicked(10);
                break;
            case R.id.ach12:
                presenter.achievementClicked(11);
                break;
            case R.id.ach13:
                presenter.achievementClicked(12);
                break;
            case R.id.ach14:
                presenter.achievementClicked(13);
                break;
            case R.id.ach15:
                presenter.achievementClicked(14);
                break;
            case R.id.ach16:
                presenter.achievementClicked(15);
                break;
            default:
                break;
        }
    }

    /**
     * This method brings forth a popup in the view, with a describing text for an achievement.
     *
     * @param text is a String provided by the presenter.
     */

    public void showAchievementPopup(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(text);

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.delete_deck_popup, (ViewGroup) findViewById(R.id.baseLayout), false);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}
