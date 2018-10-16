package com.example.ohimarc.marc.view.achievementsView;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.AchievementsPresenter;

public class AchievementsActivity extends AppCompatActivity implements AchievementsView {


    private Button ach0;
    private Button ach1;
    private Button ach2;
    private Button ach3;
    private Button ach4;
    private Button ach5;
    private Button ach6;
    private Button ach7;
    private Button ach8;
    private Button[] buttons = new Button[9];
    private Drawable trophy;

    private AchievementsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);


        initItems();
        presenter = new AchievementsPresenter(this, buttons.length);
    }

    private void initItems() {
        trophy = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_trophy);

        ach0 = findViewById(R.id.ach1);     buttons[0] = ach0;
        ach1 = findViewById(R.id.ach2);     buttons[1] = ach1;
        ach2 = findViewById(R.id.ach3);     buttons[2] = ach2;
        ach3 = findViewById(R.id.ach4);     buttons[3] = ach3;
        ach4 = findViewById(R.id.ach5);     buttons[4] = ach4;
        ach5 = findViewById(R.id.ach6);     buttons[5] = ach5;
        ach6 = findViewById(R.id.ach7);     buttons[6] = ach6;
        ach7 = findViewById(R.id.ach8);     buttons[7] = ach7;
        ach8 = findViewById(R.id.ach9);     buttons[8] = ach8;
    }

    public void unlockAchievement(int index) {
        buttons[index].setBackground(trophy);
    }

    public void hideAchievement(int index) {
        buttons[index].setVisibility(View.INVISIBLE);
    }

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
            default: break;
        }
    }

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
