package com.example.ohimarc.marc.view.flashcardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.ohimarc.marc.R;
import com.example.ohimarc.marc.presenter.FlashcardPresenter;
import com.example.ohimarc.marc.view.resultsView.ResultsActivity;
import com.example.ohimarc.marc.view.toolbarExtensionView.ToolbarExtension;

/**
 * @author Alexander Sandberg (alexandersand on github)
 */

public class FlashcardActivity extends ToolbarExtension implements FlashcardView {

    private FlashcardPresenter presenter;

    private Button cardButton;
    private TextView cardTitle;
    private TextView textOnButton;
    private int deckIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        cardTitle = findViewById(R.id.cardTitle);
        cardButton = findViewById(R.id.cardButton);
        textOnButton = findViewById(R.id.text_on_button);

        unpackBundle();

        presenter = new FlashcardPresenter(this, deckIndex);
        initExtension(this, R.id.flashcard_activity, presenter.getDeckTitle());
        cardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startRotation(0, 180);
                flipCardButtonClicked(v);
            }
        });
    }

    /**
     * This function initializes the view with some Strings. It is called once, from
     * FlashcardPresenter.
     *
     * @param deckTitleText is a String which is the deckTitle of a selected deck.
     * @param cardText      is a String which is the front text of the first card in the deck.
     */

    public void initTexts(String deckTitleText, String cardText) {
        textOnButton.setText(cardText);
        cardTitle.setText("Q:");
    }

    /**
     * This function sets the new text to the card in the view.
     *
     * @param qOrA is a String, which simply marks the card for when a question or answer
     *             is displayed with "Q: " or "A: ".
     * @param text is a String, which is either the back or the front of the current card.
     */

    public void flipCardButton(String qOrA, String text) {
        cardTitle.setText(qOrA);
        textOnButton.setText(text);
    }


    /**
     * This function is called in the XML-file activity_flashcard when the flashcard is clicked.
     * The function tells the presenter that it has been clicked, while also telling the presenter
     * if either "Q:" or "A:" is displayed on the card.
     *
     * @param v is a View which in this case is the XML-file activity_flashcard.
     */
    // en listener nu istället och inte xml som kallar på metoden
    public void flipCardButtonClicked(View v) {
        boolean bool = false;
        if (cardTitle.getText().equals("Q:")) {
            bool = true;
        }
        presenter.flashCardClicked(bool);
    }

    /**
     * This function is called in the XML-file activity_flashcard when the "Correct" button is
     * clicked. It calls a function in the presenter with the boolean "isCorrect" set as true,
     * marking that the user has answered the question correctly.
     *
     * @param v is a View which in this case is the XML-file activity_flashcard.
     */

    public void correctButtonClicked(View v) {
        presenter.resultButtonsClicked(true);
    }

    /**
     * This function is called in the XML-file activity_flashcard when the "Incorrect" button is
     * clicked. It calls a function in the presenter with the boolean "isCorrect" set as false,
     * marking that the user has answered the question incorrectly.
     *
     * @param v is a View which in this case is the XML-file activity_flashcard.
     */

    public void incorrectButtonClicked(View v) {
        presenter.resultButtonsClicked(false);
    }

    /**
     * This function handles the navigation to the next activity, namely ResultsActivity.
     * It is called from FlashcardPresenter when no more cards are available.
     * It sets the Intent, packs a bundle, starts the activity and finished itself.
     */

    public void changeView() {
        Intent intent = new Intent(FlashcardActivity.this, ResultsActivity.class);
        packBundle(intent);
        startActivity(intent);
        finish();
    }

    /**
     * This function unpacks the bundle, where an int is expected to be found with the key
     * "deckIndex". This int marks which deck has been selected, which is later used in the
     * FlashcardPresenter.
     */

    private void unpackBundle() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            deckIndex = b.getInt("deckIndex");
        }
    }

    /**
     * This function packs a bundle for ResultsActivity. It puts the results into the bundle,
     * the current game selected, i.e "Flashcard Game", while also forwarding the deckIndex.
     *
     * @param intent is an Intent, given by the function changeView().
     */

    private void packBundle(Intent intent) {
        Bundle b = new Bundle();
        b.putIntegerArrayList("results", presenter.getAmountCorrectAnswers());
        b.putString("mode", presenter.getGameName());
        b.putInt("deckIndex", deckIndex);
        intent.putExtras(b);
    }

    private void startRotation(float start, float end) {
        final float centerX = cardButton.getWidth() / 2.0f;
        final float centerY = cardButton.getHeight() / 2.0f;

        rotation rotation = new rotation(start, end, centerX, centerY, 0f, false);
        rotation.setDuration(1000);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new LinearInterpolator());

        cardButton.startAnimation(rotation);
    }
}
