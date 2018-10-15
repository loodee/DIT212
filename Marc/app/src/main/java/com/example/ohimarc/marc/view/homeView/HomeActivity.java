package com.example.ohimarc.marc.view.homeView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.HomePresenter;
import com.example.ohimarc.marc.view.addRemoveDeckView.AddRemoveDeckActivity;
import com.example.ohimarc.marc.view.choosingDeckView.ChoosingDeckActivity;
import com.example.ohimarc.marc.view.statsView.StatsActivity;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

public class HomeActivity extends ToolbarExtension {

    private final HomePresenter presenter = new HomePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        initExtension(this, R.id.homeActivity,"HomeActivity");
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
    }

    public void deckButton(View view){
        Intent intent = new Intent(HomeActivity.this,AddRemoveDeckActivity.class);
        startActivity(intent);
    }

    public void statsButton(View view){
        Log.d("test", "Pressed stats button");

        Intent intent = new Intent(HomeActivity.this,StatsActivity.class);
        startActivity(intent);
    }

}
