package com.example.ohimarc.marc.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ohimarc.marc.Model.Card;
import com.example.ohimarc.marc.R;

public class FlashcardActivity extends AppCompatActivity {

    Card test = new Card("Test","Test2");
    private Button cardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        cardButton = (Button)findViewById(R.id.cardButton);
        cardTitle = (TextView)findViewById(R.id.cardTitle);
        cardButton.setText(test.getFront());
    }

    public void flashCardClicked(View view){
        //Log.d("test","FLASHCARD CLICKED");
        button.setText(test.getBack());
            cardButton.setText(test.getBack());
    }


}
