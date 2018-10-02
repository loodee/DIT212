package com.example.ohimarc.marc.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.model.ToolbarExtension;

public class Home extends ToolbarExtension {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initToolbar(this, R.id.homeactivity,"Home");
    }

    public void exercise_button(View view) {
        Intent intent = new Intent(Home.this, FlashcardActivity.class);
        startActivity(intent);
        //finish();
    }
}
