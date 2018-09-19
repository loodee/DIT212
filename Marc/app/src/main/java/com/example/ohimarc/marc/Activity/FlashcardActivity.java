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
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        button = (Button)findViewById(R.id.button2);
        button.setText(test.getFront());
    }

    public void flashCardClicked(View view){
        //Log.d("test","FLASHCARD CLICKED");
        button.setText(test.getBack());

    }


}
