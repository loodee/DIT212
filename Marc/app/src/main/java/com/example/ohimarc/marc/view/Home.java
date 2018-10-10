package com.example.ohimarc.marc.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.HomePresenter;
import com.example.ohimarc.marc.StaticTestDeck;
import com.example.ohimarc.marc.view.editdeck.EditDeckActivity;

public class Home extends ToolbarExtension {

    HomePresenter presenter = new HomePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        initExtension(this, R.id.homeactivity,"Home");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(presenter.isLoggedOut()){
            logout();
        }
    }

    private void logout() {
        finish();
    }

    public void exercise_button(View view) {
        Intent intent = new Intent(Home.this, FlashcardActivity.class);
        startActivity(intent);
        //finish();
    }

    public void deck_button(View view){
        Intent intent = new Intent(Home.this,AddRemoveDeckActivity.class);
        startActivity(intent);
    }

}
