package com.example.ohimarc.marc.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.HomePresenter;
import com.example.ohimarc.marc.view.choosingDeck.ChoosingDeckActivity;

public class HomeActivity extends ToolbarExtension {

    private final HomePresenter presenter = new HomePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        initExtension(this, R.id.homeactivity,"HomeActivity");
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

    public void exerciseButton(View view) {
        Intent intent = new Intent(HomeActivity.this, ChoosingDeckActivity.class);
        startActivity(intent);
        //finish();
    }

    public void deckButton(View view){
        Intent intent = new Intent(HomeActivity.this,AddRemoveDeckActivity.class);
        startActivity(intent);
    }

}
