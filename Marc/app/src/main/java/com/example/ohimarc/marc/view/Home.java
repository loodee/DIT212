package com.example.ohimarc.marc.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.ohimarc.marc.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_items,menu);
        return true;
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
